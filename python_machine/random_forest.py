import os
import pandas as pd
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import accuracy_score
import matplotlib.pyplot as plt
import seaborn as sns

df = pd.read_csv('data.csv',encoding='cp949')

print(df.dtypes)

df_corr = df.corr()

df_corr_sort = df_corr.sort_values('Unnamed: 0')
print(df_corr_sort['Unnamed: 0'].head(5))

cols = ['Unnamed: 0', 'food_name','view_count','food_cate','rec_season','rec_weather','rec_time']
sns.pairplot(df[cols])
print()plt.show();