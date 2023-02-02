import numpy as np
import pandas as pd
import json
import csv

# 키워드별 메뉴 가져오기
path1 = "./menu/menu.json"

with open(path1, "r", encoding="utf-8") as json_file:
  json_data = json.load(json_file)
json.dumps(json_data, indent="\t", ensure_ascii=False)


#
menuList = []
menuDict = {}

for idx, i in enumerate(json_data):
  menu = i['mkDict']
  menuIngre = i['ikDict']

  # 메뉴 키워드
  menuKeyword = np.array([
    "밥", "덮밥", "볶음밥", "솥밥", "비빔밥", "죽", "국밥", "주먹밥", "이유식", "미음", "라이스", "초밥", "김밥",
    "떡", "누룽지", "묵사발", "롤", "국", "탕","탕수", "전골", "백숙", "볶음탕", "냉국", "찌개", "스튜", "짜글이",
    "샤브샤브", "나베", "찜","훠궈", "밀푀유나베", "우동", "라면", "짬뽕", "냉면", "파스타", "수제비", "말이", "조림", "전", "젓", "나물",
    "무침", "구이", "볶음", "파전","겉절이", "피클", "부침개", "절임", "장아찌", "쌈", "불고기", "갈비", "강정", "돼지",
    "소고기", "쇠고기", "닭", "오리", "양", "스테이크", "꼬치", "돈까스", "제육", "주물럭", "곱창", "산적", "수육",
    "샐러드", "샌드위치", "카나페", "김치"
  ])

  for mk in menuKeyword:
    menus = menu[mk]
    for m in menus:
      list = np.array(
        [mk, m]
      )
      menuDict = {
        "menuKind" : list[0],
        "menuName" : list[1]
      }
      menuList.append(menuDict)

  # 재료 메뉴
  ingreKeyword = np.array([
    "쑥", "달래", "냉이", "두릅", "우엉", "딸기", "매실", "꼬막","더덕", "미더덕", "바지락",
    "다슬기", "장어", "감자", "토마토", "전복", "참외", "복숭아", "갈치", "고구마", "옥수수", "도라지",
    "키조개", "은행", "배추", "게", "귤", "호박", "대하", "새우", "굴", "꼬막", "고등어", "꽁치",
    "홍합", " 삼치", "사과", "마늘", "맛살", "참치", "아보카도", "크림", "만두", "콩나물", "삼겹살",
    "채소", "묵은지", "연어", "오징어", "베이컨", "달걀", "카레", "버섯", "가지", "고추", "오이", "깍두기",
    "된장", "카르보나라", "쌈장", "떡볶이", "열무", "소보로", "멸치", "포두부", "연두부", "순두부", "두부",
    "양배추", "날치알", "양파","대파", "치즈", "어묵", "골뱅이", "버터", "순대", "할라피뇨", "햄", "콩", 
    "짜장", "미나리", "게살", "부추", "매생이", "시금치", "당근", "크래미", "피자", "팽이", "흑임자",
    "아스파라거스", "노각", "바나나", "명란", "꽁치", "백합", "황태", "견과류", "토란", "고사리", "낙지", "번데기",
    "깨", "완자", "미소", "깻잎", "맥주", "생태", "도루묵", "해물", "차돌박이", "동태", "쥐포", "톳",
    "청경채", "연근", "파래", "파프리카", "랍스터", "곤약", "시래기", "등갈비", "가자미", "숙주"
  ])

  for mi in menuIngre:
    menus = menuIngre[mi]
    for m in menus:
      list = np.array(
        [mi, m]
      )
      menuDict = {
        "menuKind" : list[0],
        "menuName" : list[1]
      }
      menuList.append(menuDict)

menuData = pd.DataFrame(menuList)
menuData.to_csv("./menu/csv/menuData.csv", encoding='utf-8-sig')