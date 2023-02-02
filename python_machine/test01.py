import numpy as np
import pandas as pd
from sklearn.metrics import confusion_matrix, classification_report
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import accuracy_score

df = pd.read_csv('food.csv', encoding='cp949')

# 전처리 - 데이터 수치화
df.loc[df['food_cate'] == '과자', 'food_cate'] = 0
df.loc[df['food_cate'] == '국/탕', 'food_cate'] = 1
df.loc[df['food_cate'] == '기타', 'food_cate'] = 2
df.loc[df['food_cate'] == '김치/젓갈/장류', 'food_cate'] = 3
df.loc[df['food_cate'] == '디저트', 'food_cate'] = 4
df.loc[df['food_cate'] == '메인반찬', 'food_cate'] = 5
df.loc[df['food_cate'] == '면/만두', 'food_cate'] = 6
df.loc[df['food_cate'] == '밑반찬', 'food_cate'] = 7
df.loc[df['food_cate'] == '밥/죽/떡', 'food_cate'] = 8
df.loc[df['food_cate'] == '빵', 'food_cate'] = 9
df.loc[df['food_cate'] == '샐러드', 'food_cate'] = 10
df.loc[df['food_cate'] == '스프', 'food_cate'] = 11
df.loc[df['food_cate'] == '양념/소스/잼', 'food_cate'] = 12
df.loc[df['food_cate'] == '양식', 'food_cate'] = 13
df.loc[df['food_cate'] == '찌개', 'food_cate'] = 14
df.loc[df['food_cate'] == '차/음료/술', 'food_cate'] = 15
df.loc[df['food_cate'] == '퓨전', 'food_cate'] = 16


df.loc[df['rec_season'] == '봄', 'rec_season'] = 0
df.loc[df['rec_season'] == '여름', 'rec_season'] = 1
df.loc[df['rec_season'] == '가을', 'rec_season'] = 2
df.loc[df['rec_season'] == '겨울', 'rec_season'] = 3

df.loc[df['rec_weather'] == '맑음', 'rec_weather'] = 0
df.loc[df['rec_weather'] == '흐림', 'rec_weather'] = 1
df.loc[df['rec_weather'] == '비', 'rec_weather'] = 2
df.loc[df['rec_weather'] == '눈', 'rec_weather'] = 3

df.loc[df['rec_time'] == '아침', 'rec_time'] = 0
df.loc[df['rec_time'] == '점심', 'rec_time'] = 1
df.loc[df['rec_time'] == '저녁', 'rec_time'] = 2

print(df)

df_z = df['food_name']
print(df_z)

df_xy = df[["rec_season", "rec_weather", "rec_time"]]
data_xy = df_xy



rec_season = int(input(' : '))
rec_weather = int(input('rec_weather : '))
rec_time = int(input('rec_time : '))
target = [rec_season, rec_weather, rec_time]

size = len(df_xy)
class_target = np.tile(target, (size, 1))
class_z = np.array(df_z)


def classify(dataset, class_target, class_category, k):
    diffMat = class_target - dataset
    sqDiffMat = diffMat ** 2
    row_sum = sqDiffMat.sum(axis=1)
    distance = np.sqrt(row_sum)
    sortDist = distance.argsort()

    class_result = {}
    for i in range(k):
        c = class_category[sortDist[i]]
        class_result[c] = class_result.get(c, 0) + 1

    return class_result

k = int(input('k값을 입력해주세요 :'))
class_result = classify(data_xy, class_target, class_z, k)  # classify()함수호출
print(class_result)


