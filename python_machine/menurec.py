import pandas as pd
import numpy as np
from sklearn.feature_extraction.text import CountVectorizer  # 피체 벡터화
from sklearn.metrics.pairwise import cosine_similarity  # 코사인 유사도


def find_similar_movies (input_title , matrix, n, alpha):

#csv 파일 read
meta = pd.read_csv('recipe.csv', encoding='cp949')

#필요한 칼럼만 짜르기
meta = meta[['CKG_NM','INQ_CNT','RCMM_CNT','CKG_STA_ACTO_NM','CKG_MTRL_ACTO_NM''CKG_KND_ACTO_NM']]

meta.columns = ['name', #메뉴명
              'views', #조회수
              'rec', #추천수
              'cate_1',
              'cate_2',
              'cate_3' #종류

              ]



df['cate_mix'] = df['cate_1'] + df['cate_2'] +  df['cate_3']
df['cate_mix'] = df['cate_mix'].str.replace("/", " ")

count_vect_category = CountVectorizer(min_df=0, ngram_range=(1,2))
menu_category = count_vect_category.fit_transform(df['cate_mix'])
menu_simi_cate = cosine_similarity(menu_category, menu_category)
menu_simi_cate_sorted_ind = menu_simi_cate.argsort()[:, ::-1]



봄 = ['쑥','달래','냉이','두릅','우엉','딸기','한라봉','취나물','씀바퀴','매실','멍게','소라','꼬막','더덕','참다랑어','미더덕','쭈꾸미','바지락','도미','키조개','다슬기','장어']
여름 = ['감자','복분자','토마토','수박','전복','참외','매실','복숭아','블루베리','포도','갈치','고구마','옥수수','자두','도라지']
가을 = ['고등어','광어','굴','대하','새우','해삼','호박','무','배추','가리비','귤','토마토','홍합']
겨울 = ['배추','무','사과','대하','우엉','한라봉','유자','늙은호박','귤','석류','더덕','아귀','과메기','가리비','굴','광어','명태','도미','삼치']

맑음 = ['밀면','냉면','냉']
비 = ['전','찌개','수제비','국수','볶이','수프','탕','우동']
눈 = ['고구마','호빵','우동','어묵','호박죽']
흐림 = ['찌개','전','수제비']




print(df)