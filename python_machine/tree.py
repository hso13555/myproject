## pandas 모듈
import pandas as pd
from matplotlib import pyplot as plt
from matplotlib.pyplot import clf
from sklearn import tree
import numpy as np

## iris 데이터 모듈
from sklearn.datasets import load_iris

## train과 test set 구분 모듈
from sklearn.model_selection import train_test_split

## 데이터 표준화 모듈
from sklearn.preprocessing import StandardScaler

## 의사결정트리 모델
from sklearn.tree import DecisionTreeClassifier

## 정확도 예측 모듈(연속적인 데이터에서 사용 안함)
from sklearn.metrics import accuracy_score

## 의사결정트리 시각화
from sklearn.tree import export_graphviz

import seaborn as sns

import graphviz

import csv

df = pd.read_csv('food.csv', encoding='cp949')


# 전처리

#
# #봄
# df.loc[df['food_name'].str.contains('나물',na=False), 'rec_weather'] = 'spring'
# df.loc[df['food_name'].str.contains('꼬막',na=False), 'rec_weather'] = 'spring'
# df.loc[df['food_name'].str.contains('무침',na=False), 'rec_weather'] = 'spring'
#
# #여름
# df.loc[df['food_name'].str.contains('닭',na=False), 'rec_weather'] = 'summer'
# df.loc[df['food_name'].str.contains('감자',na=False), 'rec_weather'] = 'summer'
#
# #가을
# df.loc[df['food_name'].str.contains('밤',na=False), 'rec_weather'] = 'autumn'
# df.loc[df['food_name'].str.contains('굴',na=False), 'rec_weather'] = 'autumn'
# df.loc[df['food_name'].str.contains('대추',na=False), 'rec_weather'] = 'autumn'
#
# #겨울
# df.loc[df['food_name'].str.contains('전',na=False), 'rec_weather'] = 'winter'
# df.loc[df['food_name'].str.contains('탕',na=False), 'rec_weather'] = 'winter'
# df.loc[df['food_name'].str.contains('국',na=False), 'rec_weather'] = 'winter'
# df.loc[df['food_name'].str.contains('찌개',na=False), 'rec_weather'] = 'winter'
#


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

# X = df.values[:, 3:6]
# Y = df.values[:, 1]

X = np.array(pd.DataFrame(df, columns=['rec_season','rec_weather', 'rec_time']))
Y = np.array(pd.DataFrame(df, columns=['food_name']))
X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.3, random_state=100)

dt_clf = DecisionTreeClassifier(max_depth=50, random_state=100)

dt_clf = dt_clf.fit(X_train, y_train)

dt_prediction = dt_clf.predict(X_test)

# print(dt_prediction)

dt_clf_model_text = tree.export_text(dt_clf)

print(dt_clf_model_text)

print("train score : ", dt_clf.score(X_train, y_train))
print("test score : ", dt_clf.score(X_test, y_test))

fi = dt_clf.feature_importances_

# 중요도를 데이터프레임형식으로 만들어서 보기좋게 하기
print(pd.DataFrame(fi, index=X).sort_values(by=0, ascending= False))



