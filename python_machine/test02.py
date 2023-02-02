import numpy as np
import pandas as pd
import csv

import matplotlib as mpl
import matplotlib.pyplot as plt
import seaborn as sns

import warnings

from sklearn.metrics import mean_squared_error
from sklearn.metrics.pairwise import cosine_similarity


foods = pd.read_csv("./test01/foods.csv",encoding='cp949')
ratings = pd.read_csv("./test01/ratings.csv",encoding='cp949')

ratings_matrix = ratings.pivot_table("rating", "userId", "foodId")
print(ratings_matrix.head(1))

# ratings 데이터와 foods 데이터 결합
rating_foods = pd.merge(ratings, foods, on="foodId")

# 사용자-아이템 평점 행렬 생성
ratings_matrix = rating_foods.pivot_table("rating", "userId", "title")

# NaN값은 0으로 변환
ratings_matrix.fillna(0, inplace=True)

# 아이템-사용자 평점 행렬로 전치
ratings_matrix_T = ratings_matrix.T
ratings_matrix_T.head(3)

# 아이템 유사도 행렬
item_sim = cosine_similarity(ratings_matrix_T, ratings_matrix_T)

# 데이터 프레임 형태로 저장
item_sim_df = pd.DataFrame(item_sim, index=ratings_matrix_T.index, columns=ratings_matrix_T.index)

# item_sim_df.shape: 9719 x 9719
print(item_sim_df.iloc[:4,:4])

# BLT샌드위치 와 유사도가 높은 상위 5개 음식
ex01=item_sim_df["BLT샌드위치"].sort_values(ascending=False)[1:6]

#여기선 평점에 따른 유사도

print(ex01)


# 인수로 사용자-아이템 평점 행렬(NaN은 현재 0으로 대체), 아이템 유사도 행렬 사용
def predict_rating(ratings_arr, item_sim_arr):
    # ratings_arr: u x i, item_sim_arr: i x i
    sum_sr = ratings_arr @ item_sim_arr
    sum_s_abs = np.array([np.abs(item_sim_arr).sum(axis=1)])

    ratings_pred = sum_sr / sum_s_abs

    return ratings_pred

# 사용자별 예측 평점
ratings_pred = predict_rating(ratings_matrix.values , item_sim_df.values)

ratings_pred_matrix = pd.DataFrame(data=ratings_pred, index= ratings_matrix.index,
                                   columns = ratings_matrix.columns)
print(ratings_pred_matrix.head(3))


# 성능 평가는 MSE를 사용
def get_mse(pred, actual):
    # 평점이 있는 실제 음식만 추출 (1차원 배열로 변환)
    pred = pred[actual.nonzero()].flatten()
    actual = actual[actual.nonzero()].flatten()

    return mean_squared_error(pred, actual)
MSE1 = get_mse(ratings_pred, ratings_matrix.values)
print(f'아이템 기반 모든 인접 이웃 MSE: {MSE1:.4f}')

#아이템 기반 모든 인접 이웃 MSE: 9.7479

def predict_rating_topsim(ratings_arr, item_sim_arr, N=20):
    # 사용자-아이템 평점 행렬 크기만큼 0으로 채운 예측 행렬 초기화
    pred = np.zeros(ratings_arr.shape)

    # 사용자-아이템 평점 행렬의 열 크기(아이템 수)만큼 반복 (row: 사용자, col: 아이템)
    for col in range(ratings_arr.shape[1]):

        # 특정 아이템의 유사도 행렬 오름차순 정렬시 index .. (1)
        temp = np.argsort(item_sim_arr[:, col])

        # (1)의 index를 역순으로 나열시 상위 N개의 index = 특정 아이템의 유사도 상위 N개 아이템 index .. (2)
        top_n_items = [temp[:-1 - N:-1]]

        # 개인화된 예측 평점을 계산: 반복당 특정 아이템의 예측 평점(사용자 전체)
        for row in range(ratings_arr.shape[0]):
            # (2)의 유사도 행렬
            item_sim_arr_topN = item_sim_arr[col, :][top_n_items].T  # N x 1

            # (2)의 실제 평점 행렬
            ratings_arr_topN = ratings_arr[row, :][top_n_items]  # 1 x N

            # 예측 평점
            pred[row, col] = ratings_arr_topN @ item_sim_arr_topN
            pred[row, col] /= np.sum(np.abs(item_sim_arr_topN))

    return pred
#
# 특정 아이템과 유사도가 높은 상위 N개 아이템과의 유사도 벡터를 구한다.
# 사용자의 평점 중 앞서 구한 상위 N개 아이템에 대한 평점만 사용한다.
# 두 행렬을 곱하여서 사용자 예측 평점을 계산한다.
# 이 함수는 행, 열별로 반복을 수행하여서 데이터 크기가 크면 수행시간이 오래 걸린다.

# 사용자별 예측 평점
ratings_pred = predict_rating_topsim(ratings_matrix.values , item_sim_df.values, N=20)

# 성능 평가
MSE2 = get_mse(ratings_pred, ratings_matrix.values )
print(f'아이템 기반 인접 TOP-20 이웃 MSE: {MSE2:.4f}')
#아이템 기반 인접 TOP-20 이웃 MSE: 3.6855


# 예측 평점 데이터 프레임
ratings_pred_matrix = pd.DataFrame(data=ratings_pred, index= ratings_matrix.index,
                                   columns = ratings_matrix.columns)


# userId 9가 높은 평점을 준 음식 (실제 평점)
user_rating_id = ratings_matrix.loc[9, :]
print('userId 9가 높은 평점을 준 음식 (실제 평점)')
print(user_rating_id[ user_rating_id > 0].sort_values(ascending=False)[:10])


# 아직 먹지 않은 음식 리스트 함수
def get_unseen_foods(ratings_matrix, userId):
    # user_rating: userId의 아이템 평점 정보 (시리즈 형태: title을 index로 가진다.)
    user_rating = ratings_matrix.loc[userId, :]

    # user_rating=0인 아직 못먹은 음식
    unseen_foods_list = user_rating[user_rating == 0].index.tolist()

    # 모든 음식명을 list 객체로 만듬.
    foods_list = ratings_matrix.columns.tolist()

    # 한줄 for + if문으로 안먹은 음식 리스트 생성
    unseen_list = [foods for foods in foods_list if foods in unseen_foods_list]

    return unseen_list


# 먹지 않은 음식 중 예측 높은 순서로 시리즈 반환
def recomm_food_by_userid(pred_df, userId, unseen_list, top_n=10):
    recomm_foods = pred_df.loc[userId, unseen_list].sort_values(ascending=False)[:top_n]

    return recomm_foods

# 아직 못먹은 음식 리스트
unseen_list = get_unseen_foods(ratings_matrix, 9)

# 아이템 기반의 최근접 이웃 협업 필터링으로 음식 추천
recomm_foods = recomm_food_by_userid(ratings_pred_matrix, 9, unseen_list, top_n=10)

# 데이터 프레임 생성
recomm_foods = pd.DataFrame(data=recomm_foods.values, index=recomm_foods.index, columns=['pred_score'])
print('userId 9번이 아직 못 먹은 음식 중 예측 평점이 가장 높은 상위 10개 음식 출력했다.')
print(recomm_foods)

