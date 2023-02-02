import numpy as np
import pandas as pd
import json

# 레시피 메뉴 이름 가져오기
path1 = "./menu/json/recipe.json"

with open(path1, "r", encoding="utf-8") as json_file:
  json_data = json.load(json_file)
json.dumps(json_data, indent="\t", ensure_ascii=False)

menuList = []
menuDict = {}
menuNameList = []

for i in json_data:
  menuName = i['menu_title']
  menuNameList.append(menuName)

# 메뉴 키워드
menuKeyword = np.array([
  "밥", "덮밥", "볶음밥", "솥밥", "비빔밥", "죽", "국밥", "주먹밥", "이유식", "미음", "라이스", "초밥", "김밥",
  "떡", "누룽지", "묵사발", "롤", "국", "탕","탕수", "전골", "백숙", "볶음탕", "냉국", "찌개", "스튜", "짜글이",
  "샤브샤브", "나베", "찜","훠궈", "밀푀유나베", "우동", "라면", "짬뽕", "냉면", "파스타", "수제비", "말이", "조림", "전", "젓", "나물",
  "무침", "구이", "볶음", "파전","겉절이", "피클", "부침개", "절임", "장아찌", "쌈", "불고기", "갈비", "강정", "돼지",
  "소고기", "쇠고기", "닭", "오리", "양", "스테이크", "꼬치", "돈까스", "제육", "주물럭", "곱창", "산적", "수육",
  "샐러드", "샌드위치", "카나페", "김치"
])

mkDict = {}
mkList = []
mkwList = []
mkwDict = {}

for mkw in range(len(menuKeyword)):
  kind = menuKeyword[mkw]
  mkwDict = {
    "keyword" :  kind,
  }
  mkwList.append(mkwDict)

kind_01 = []
kind_02 = []
kind_03 = []
kind_04 = []
kind_05 = []
kind_06 = []
kind_07 = []
kind_08 = []
kind_09 = []
kind_10 = []
kind_11 = []
kind_12 = []
kind_13 = []
kind_14 = []
kind_15 = []
kind_16 = []
kind_17 = []
kind_18 = []
kind_19 = []
kind_20 = []
kind_21 = []
kind_22 = []
kind_23 = []
kind_24 = []
kind_25 = []
kind_26 = []
kind_27 = []
kind_28 = []
kind_29 = []
kind_30 = []
kind_31 = []
kind_32 = []
kind_33 = []
kind_34 = []
kind_35 = []
kind_36 = []
kind_37 = []
kind_38 = []
kind_39 = []
kind_40 = []
kind_41 = []
kind_42 = []
kind_43 = []
kind_44 = []
kind_45 = []
kind_46 = []
kind_47 = []
kind_48 = []
kind_49 = []
kind_50 = []
kind_51 = []
kind_52 = []
kind_53 = []
kind_54 = []
kind_55 = []
kind_56 = []
kind_57 = []
kind_58 = []
kind_59 = []
kind_60 = []
kind_61 = []
kind_62 = []
kind_63 = []
kind_64 = []
kind_65 = []
kind_66 = []
kind_67 = []
kind_68 = []
kind_69 = []
kind_70 = []
kind_71 = []
kind_72 = []
kind_73 = []
kind_74 = []

# for mk in mkwList:
for menu in menuNameList: 
  if mkwList[0]['keyword'] in menu:
    kind_01.append(menu)
  if mkwList[1]['keyword']  in menu:
    kind_02.append(menu)
  if mkwList[2]['keyword'] in menu:
    kind_03.append(menu)
  if mkwList[3]['keyword']  in menu:
    kind_04.append(menu)
  if mkwList[4]['keyword'] in menu:
    kind_05.append(menu)
  if mkwList[5]['keyword']  in menu:
    kind_06.append(menu)
  if mkwList[6]['keyword'] in menu:
    kind_07.append(menu)
  if mkwList[7]['keyword']  in menu:
    kind_08.append(menu)
  if mkwList[8]['keyword'] in menu:
    kind_09.append(menu)
  if mkwList[9]['keyword']  in menu:
    kind_10.append(menu)
  if mkwList[10]['keyword'] in menu:
    kind_11.append(menu)
  if mkwList[11]['keyword']  in menu:
    kind_12.append(menu)
  if mkwList[12]['keyword'] in menu:
    kind_13.append(menu)
  if mkwList[13]['keyword']  in menu:
    kind_14.append(menu)
  if mkwList[14]['keyword'] in menu:
    kind_15.append(menu)
  if mkwList[15]['keyword']  in menu:
    kind_16.append(menu)
  if mkwList[16]['keyword'] in menu:
    kind_17.append(menu)
  if mkwList[17]['keyword']  in menu:
    kind_18.append(menu)
  if mkwList[18]['keyword'] in menu:
    kind_19.append(menu)
  if mkwList[19]['keyword']  in menu:
    kind_20.append(menu)
  if mkwList[20]['keyword'] in menu:
    kind_21.append(menu)
  if mkwList[21]['keyword']  in menu:
    kind_22.append(menu)
  if mkwList[22]['keyword'] in menu:
    kind_23.append(menu)
  if mkwList[23]['keyword']  in menu:
    kind_24.append(menu)
  if mkwList[24]['keyword'] in menu:
    kind_25.append(menu)
  if mkwList[25]['keyword']  in menu:
    kind_26.append(menu)
  if mkwList[26]['keyword'] in menu:
    kind_27.append(menu)
  if mkwList[27]['keyword']  in menu:
    kind_28.append(menu)
  if mkwList[28]['keyword'] in menu:
    kind_29.append(menu)
  if mkwList[29]['keyword']  in menu:
    kind_30.append(menu)
  if mkwList[30]['keyword'] in menu:
    kind_31.append(menu)
  if mkwList[31]['keyword']  in menu:
    kind_32.append(menu)
  if mkwList[32]['keyword'] in menu:
    kind_33.append(menu)
  if mkwList[33]['keyword']  in menu:
    kind_34.append(menu)
  if mkwList[34]['keyword'] in menu:
    kind_35.append(menu)
  if mkwList[35]['keyword']  in menu:
    kind_36.append(menu)
  if mkwList[36]['keyword'] in menu:
    kind_37.append(menu)
  if mkwList[37]['keyword']  in menu:
    kind_38.append(menu)
  if mkwList[38]['keyword'] in menu:
    kind_39.append(menu)
  if mkwList[39]['keyword']  in menu:
    kind_40.append(menu)
  if mkwList[40]['keyword'] in menu:
    kind_41.append(menu)
  if mkwList[41]['keyword']  in menu:
    kind_42.append(menu)
  if mkwList[42]['keyword'] in menu:
    kind_43.append(menu)
  if mkwList[43]['keyword']  in menu:
    kind_44.append(menu)
  if mkwList[44]['keyword'] in menu:
    kind_45.append(menu)
  if mkwList[45]['keyword']  in menu:
    kind_46.append(menu)
  if mkwList[46]['keyword'] in menu:
    kind_47.append(menu)
  if mkwList[47]['keyword']  in menu:
    kind_48.append(menu)
  if mkwList[48]['keyword'] in menu:
    kind_49.append(menu)
  if mkwList[49]['keyword']  in menu:
    kind_50.append(menu)
  if mkwList[50]['keyword'] in menu:
    kind_51.append(menu)
  if mkwList[51]['keyword']  in menu:
    kind_52.append(menu)
  if mkwList[52]['keyword'] in menu:
    kind_53.append(menu)
  if mkwList[53]['keyword']  in menu:
    kind_54.append(menu)
  if mkwList[54]['keyword'] in menu:
    kind_55.append(menu)
  if mkwList[55]['keyword']  in menu:
    kind_56.append(menu)
  if mkwList[56]['keyword'] in menu:
    kind_57.append(menu)
  if mkwList[57]['keyword']  in menu:
    kind_58.append(menu)
  if mkwList[58]['keyword'] in menu:
    kind_59.append(menu)
  if mkwList[59]['keyword']  in menu:
    kind_60.append(menu)
  if mkwList[60]['keyword'] in menu:
    kind_61.append(menu)
  if mkwList[61]['keyword']  in menu:
    kind_62.append(menu)
  if mkwList[62]['keyword'] in menu:
    kind_63.append(menu)
  if mkwList[63]['keyword']  in menu:
    kind_64.append(menu)
  if mkwList[64]['keyword'] in menu:
    kind_65.append(menu)
  if mkwList[65]['keyword']  in menu:
    kind_66.append(menu)
  if mkwList[66]['keyword'] in menu:
    kind_67.append(menu)
  if mkwList[67]['keyword']  in menu:
    kind_68.append(menu)
  if mkwList[68]['keyword'] in menu:
    kind_69.append(menu)
  if mkwList[69]['keyword']  in menu:
    kind_70.append(menu)
  if mkwList[70]['keyword'] in menu:
    kind_71.append(menu)
  if mkwList[71]['keyword']  in menu:
    kind_72.append(menu)
  if mkwList[72]['keyword'] in menu:
    kind_73.append(menu)
  if mkwList[73]['keyword']  in menu:
    kind_74.append(menu)

mkDict = {
  "밥" : kind_01,
  "덮밥" : kind_02,
  "볶음밥" : kind_03,
  "솥밥" : kind_04,
  "비빔밥" : kind_05,
  "죽" : kind_06,
  "국밥" : kind_07,
  "주먹밥" : kind_08,
  "이유식" : kind_09,
  "미음" : kind_10,
  "라이스" : kind_11,
  "초밥" : kind_12,
  "김밥" : kind_13,
  "떡" : kind_14,
  "누룽지" : kind_15,
  "묵사발" : kind_16,
  "롤" : kind_17,
  "국" : kind_18,
  "탕" : kind_19,
  "탕수" : kind_20,
  "전골" : kind_21,
  "백숙" : kind_22,
  "볶음탕" : kind_23,
  "냉국" : kind_24,
  "찌개" : kind_25,
  "스튜" : kind_26,
  "짜글이" : kind_27,
  "샤브샤브" : kind_28,
  "나베" : kind_29,
  "찜" : kind_30,
  "훠궈" : kind_31,
  "밀푀유나베" : kind_32,
  "우동" : kind_33,
  "라면" : kind_34,
  "짬뽕" : kind_35,
  "냉면" : kind_36,
  "파스타" : kind_37,
  "수제비" : kind_38,
  "말이" : kind_39,
  "조림" : kind_40,
  "전" : kind_41,
  "젓" : kind_42,
  "나물" : kind_43,
  "무침" : kind_44,
  "구이" : kind_45,
  "볶음" : kind_46,
  "파전" : kind_47,
  "겉절이" : kind_48,
  "피클" : kind_49,
  "부침개" : kind_50,
  "절임" : kind_51,
  "장아찌" : kind_52,
  "쌈" : kind_53,
  "불고기" : kind_54,
  "갈비" : kind_55,
  "강정" : kind_56,
  "돼지" : kind_57,
  "소고기" : kind_58,
  "쇠고기" : kind_59,
  "닭" : kind_60,
  "오리" : kind_61,
  "양" : kind_62,
  "스테이크" : kind_63,
  "꼬치" : kind_64,
  "돈까스" : kind_65,
  "제육" : kind_66,
  "주물럭" : kind_67,
  "곱창" : kind_68,
  "산적" : kind_69,
  "수육" : kind_70,
  "샐러드" : kind_71,
  "샌드위치" : kind_72,
  "카나페" : kind_73,
  "김치" : kind_74,
}

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

ikwDict = {}
ikwList = []
ikList = []
ikDict = {}

for ikw in range(len(ingreKeyword)):
  ingr = ingreKeyword[ikw]
  ikwDict = {
    "keyword" :  ingr,
  }
  ikwList.append(ikwDict)

# for i in ikwList:
#   print(i['keyword'])

ingr_01 = []
ingr_02 = []
ingr_03 = []
ingr_04 = []
ingr_05 = []
ingr_06 = []
ingr_07 = []
ingr_08 = []
ingr_09 = []
ingr_10 = []
ingr_11 = []
ingr_12 = []
ingr_13 = []
ingr_14 = []
ingr_15 = []
ingr_16 = []
ingr_17 = []
ingr_18 = []
ingr_19 = []
ingr_20 = []
ingr_21 = []
ingr_22 = []
ingr_23 = []
ingr_24 = []
ingr_25 = []
ingr_26 = []
ingr_27 = []
ingr_28 = []
ingr_29 = []
ingr_30 = []
ingr_31 = []
ingr_32 = []
ingr_33 = []
ingr_34 = []
ingr_35 = []
ingr_36 = []
ingr_37 = []
ingr_38 = []
ingr_39 = []
ingr_40 = []
ingr_41 = []
ingr_42 = []
ingr_43 = []
ingr_44 = []
ingr_45 = []
ingr_46 = []
ingr_47 = []
ingr_48 = []
ingr_49 = []
ingr_50 = []
ingr_51 = []
ingr_52 = []
ingr_53 = []
ingr_54 = []
ingr_55 = []
ingr_56 = []
ingr_57 = []
ingr_58 = []
ingr_59 = []
ingr_60 = []
ingr_61 = []
ingr_62 = []
ingr_63 = []
ingr_64 = []
ingr_65 = []
ingr_66 = []
ingr_67 = []
ingr_68 = []
ingr_69 = []
ingr_70 = []
ingr_71 = []
ingr_72 = []
ingr_73 = []
ingr_74 = []
ingr_75 = []
ingr_76 = []
ingr_77 = []
ingr_78 = []
ingr_79 = []
ingr_80 = []
ingr_81 = []
ingr_82 = []
ingr_83 = []
ingr_84 = []
ingr_85 = []
ingr_86 = []
ingr_87 = []
ingr_88 = []
ingr_89 = []
ingr_90 = []
ingr_91 = []
ingr_92 = []
ingr_93 = []
ingr_94 = []
ingr_95 = []
ingr_96 = []
ingr_97 = []
ingr_98 = []
ingr_99 = []
ingr_100 = []
ingr_101 = []
ingr_102 = []
ingr_103 = []
ingr_104 = []
ingr_105 = []
ingr_106 = []
ingr_107 = []
ingr_108 = []
ingr_109 = []
ingr_110 = []
ingr_111 = []
ingr_112 = []
ingr_113 = []
ingr_114 = []
ingr_115 = []
ingr_116 = []
ingr_117 = []
ingr_118 = []
ingr_119 = []
ingr_120 = []
ingr_121 = []
ingr_122 = []
ingr_123 = []
ingr_124 = []
ingr_125 = []

# for mk in mkwList:
for ingreMenu in menuNameList: 
  if ikwList[0]['keyword'] in ingreMenu:
    ingr_01.append(ingreMenu)
  if ikwList[1]['keyword']  in ingreMenu:
    ingr_02.append(ingreMenu)
  if ikwList[2]['keyword'] in ingreMenu:
    ingr_03.append(ingreMenu)
  if ikwList[3]['keyword']  in ingreMenu:
    ingr_04.append(ingreMenu)
  if ikwList[4]['keyword'] in ingreMenu:
    ingr_05.append(ingreMenu)
  if ikwList[5]['keyword']  in ingreMenu:
    ingr_06.append(ingreMenu)
  if ikwList[6]['keyword'] in ingreMenu:
    ingr_07.append(ingreMenu)
  if ikwList[7]['keyword']  in ingreMenu:
    ingr_08.append(ingreMenu)
  if ikwList[8]['keyword'] in ingreMenu:
    ingr_09.append(ingreMenu)
  if ikwList[9]['keyword']  in ingreMenu:
    ingr_10.append(ingreMenu)
  if ikwList[10]['keyword'] in ingreMenu:
    ingr_11.append(ingreMenu)
  if ikwList[11]['keyword']  in ingreMenu:
    ingr_12.append(ingreMenu)
  if ikwList[12]['keyword'] in ingreMenu:
    ingr_13.append(ingreMenu)
  if ikwList[13]['keyword']  in ingreMenu:
    ingr_14.append(ingreMenu)
  if ikwList[14]['keyword'] in ingreMenu:
    ingr_15.append(ingreMenu)
  if ikwList[15]['keyword']  in ingreMenu:
    ingr_16.append(ingreMenu)
  if ikwList[16]['keyword'] in ingreMenu:
    ingr_17.append(ingreMenu)
  if ikwList[17]['keyword']  in ingreMenu:
    ingr_18.append(ingreMenu)
  if ikwList[18]['keyword'] in ingreMenu:
    ingr_19.append(ingreMenu)
  if ikwList[19]['keyword']  in ingreMenu:
    ingr_20.append(ingreMenu)
  if ikwList[20]['keyword'] in ingreMenu:
    ingr_21.append(ingreMenu)
  if ikwList[21]['keyword']  in ingreMenu:
    ingr_22.append(ingreMenu)
  if ikwList[22]['keyword'] in ingreMenu:
    ingr_23.append(ingreMenu)
  if ikwList[23]['keyword']  in ingreMenu:
    ingr_24.append(ingreMenu)
  if ikwList[24]['keyword'] in ingreMenu:
    ingr_25.append(ingreMenu)
  if ikwList[25]['keyword']  in ingreMenu:
    ingr_26.append(ingreMenu)
  if ikwList[26]['keyword'] in ingreMenu:
    ingr_27.append(ingreMenu)
  if ikwList[27]['keyword']  in ingreMenu:
    ingr_28.append(ingreMenu)
  if ikwList[28]['keyword'] in ingreMenu:
    ingr_29.append(ingreMenu)
  if ikwList[29]['keyword']  in ingreMenu:
    ingr_30.append(ingreMenu)
  if ikwList[30]['keyword'] in ingreMenu:
    ingr_31.append(ingreMenu)
  if ikwList[31]['keyword']  in ingreMenu:
    ingr_32.append(ingreMenu)
  if ikwList[32]['keyword'] in ingreMenu:
    ingr_33.append(ingreMenu)
  if ikwList[33]['keyword']  in ingreMenu:
    ingr_34.append(ingreMenu)
  if ikwList[34]['keyword'] in ingreMenu:
    ingr_35.append(ingreMenu)
  if ikwList[35]['keyword']  in ingreMenu:
    ingr_36.append(ingreMenu)
  if ikwList[36]['keyword'] in ingreMenu:
    ingr_37.append(ingreMenu)
  if ikwList[37]['keyword']  in ingreMenu:
    ingr_38.append(ingreMenu)
  if ikwList[38]['keyword'] in ingreMenu:
    ingr_39.append(ingreMenu)
  if ikwList[39]['keyword']  in ingreMenu:
    ingr_40.append(ingreMenu)
  if ikwList[40]['keyword'] in ingreMenu:
    ingr_41.append(ingreMenu)
  if ikwList[41]['keyword']  in ingreMenu:
    ingr_42.append(ingreMenu)
  if ikwList[42]['keyword'] in ingreMenu:
    ingr_43.append(ingreMenu)
  if ikwList[43]['keyword']  in ingreMenu:
    ingr_44.append(ingreMenu)
  if ikwList[44]['keyword'] in ingreMenu:
    ingr_45.append(ingreMenu)
  if ikwList[45]['keyword'] in ingreMenu:
    ingr_46.append(ingreMenu)
  if ikwList[46]['keyword'] in ingreMenu:
    ingr_47.append(ingreMenu)
  if ikwList[47]['keyword']  in ingreMenu:
    ingr_48.append(ingreMenu)
  if ikwList[48]['keyword'] in ingreMenu:
    ingr_49.append(ingreMenu)
  if ikwList[49]['keyword']  in ingreMenu:
    ingr_50.append(ingreMenu)
  if ikwList[50]['keyword'] in ingreMenu:
    ingr_51.append(ingreMenu)
  if ikwList[51]['keyword']  in ingreMenu:
    ingr_52.append(ingreMenu)
  if ikwList[52]['keyword'] in ingreMenu:
    ingr_53.append(ingreMenu)
  if ikwList[53]['keyword']  in ingreMenu:
    ingr_54.append(ingreMenu)
  if ikwList[54]['keyword'] in ingreMenu:
    ingr_55.append(ingreMenu)
  if ikwList[55]['keyword']  in ingreMenu:
    ingr_56.append(ingreMenu)
  if ikwList[56]['keyword'] in ingreMenu:
    ingr_57.append(ingreMenu)
  if ikwList[57]['keyword']  in ingreMenu:
    ingr_58.append(ingreMenu)
  if ikwList[58]['keyword'] in ingreMenu:
    ingr_59.append(ingreMenu)
  if ikwList[59]['keyword']  in ingreMenu:
    ingr_60.append(ingreMenu)
  if ikwList[60]['keyword'] in ingreMenu:
    ingr_61.append(ingreMenu)
  if ikwList[61]['keyword']  in ingreMenu:
    ingr_62.append(ingreMenu)
  if ikwList[62]['keyword'] in ingreMenu:
    ingr_63.append(ingreMenu)
  if ikwList[63]['keyword']  in ingreMenu:
    ingr_64.append(ingreMenu)
  if ikwList[64]['keyword'] in ingreMenu:
    ingr_65.append(ingreMenu)
  if ikwList[65]['keyword']  in ingreMenu:
    ingr_66.append(ingreMenu)
  if ikwList[66]['keyword'] in ingreMenu:
    ingr_67.append(ingreMenu)
  if ikwList[67]['keyword']  in ingreMenu:
    ingr_68.append(ingreMenu)
  if ikwList[68]['keyword'] in ingreMenu:
    ingr_69.append(ingreMenu)
  if ikwList[69]['keyword']  in ingreMenu:
    ingr_70.append(ingreMenu)
  if ikwList[70]['keyword'] in ingreMenu:
    ingr_71.append(ingreMenu)
  if ikwList[71]['keyword']  in ingreMenu:
    ingr_72.append(ingreMenu)
  if ikwList[72]['keyword'] in ingreMenu:
    ingr_73.append(ingreMenu)
  if ikwList[73]['keyword']  in ingreMenu:
    ingr_74.append(ingreMenu)
  if ikwList[74]['keyword'] in ingreMenu:
    ingr_75.append(ingreMenu)
  if ikwList[75]['keyword']  in ingreMenu:
    ingr_76.append(ingreMenu)
  if ikwList[76]['keyword'] in ingreMenu:
    ingr_77.append(ingreMenu)
  if ikwList[77]['keyword']  in ingreMenu:
    ingr_78.append(ingreMenu)
  if ikwList[78]['keyword'] in ingreMenu:
    ingr_79.append(ingreMenu)
  if ikwList[79]['keyword']  in ingreMenu:
    ingr_80.append(ingreMenu)
  if ikwList[80]['keyword'] in ingreMenu:
    ingr_81.append(ingreMenu)
  if ikwList[81]['keyword']  in ingreMenu:
    ingr_82.append(ingreMenu)
  if ikwList[82]['keyword'] in ingreMenu:
    ingr_83.append(ingreMenu)
  if ikwList[83]['keyword']  in ingreMenu:
    ingr_84.append(ingreMenu)
  if ikwList[84]['keyword'] in ingreMenu:
    ingr_85.append(ingreMenu)
  if ikwList[85]['keyword']  in ingreMenu:
    ingr_86.append(ingreMenu)
  if ikwList[86]['keyword'] in ingreMenu:
    ingr_87.append(ingreMenu)
  if ikwList[87]['keyword']  in ingreMenu:
    ingr_88.append(ingreMenu)
  if ikwList[88]['keyword'] in ingreMenu:
    ingr_89.append(ingreMenu)
  if ikwList[89]['keyword']  in ingreMenu:
    ingr_90.append(ingreMenu)
  if ikwList[90]['keyword'] in ingreMenu:
    ingr_91.append(ingreMenu)
  if ikwList[91]['keyword']  in ingreMenu:
    ingr_92.append(ingreMenu)
  if ikwList[92]['keyword'] in ingreMenu:
    ingr_93.append(ingreMenu)
  if ikwList[93]['keyword']  in ingreMenu:
    ingr_94.append(ingreMenu)
  if ikwList[94]['keyword'] in ingreMenu:
    ingr_95.append(ingreMenu)
  if ikwList[95]['keyword']  in ingreMenu:
    ingr_96.append(ingreMenu)
  if ikwList[96]['keyword'] in ingreMenu:
    ingr_97.append(ingreMenu)
  if ikwList[97]['keyword']  in ingreMenu:
    ingr_98.append(ingreMenu)
  if ikwList[98]['keyword'] in ingreMenu:
    ingr_99.append(ingreMenu)
  if ikwList[99]['keyword']  in ingreMenu:
    ingr_100.append(ingreMenu)
  if ikwList[100]['keyword']  in ingreMenu:
    ingr_101.append(ingreMenu)
  if ikwList[101]['keyword']  in ingreMenu:
    ingr_102.append(ingreMenu)
  if ikwList[102]['keyword']  in ingreMenu:
    ingr_103.append(ingreMenu)
  if ikwList[103]['keyword']  in ingreMenu:
    ingr_104.append(ingreMenu)
  if ikwList[104]['keyword']  in ingreMenu:
    ingr_105.append(ingreMenu)
  if ikwList[105]['keyword']  in ingreMenu:
    ingr_106.append(ingreMenu)
  if ikwList[106]['keyword']  in ingreMenu:
    ingr_107.append(ingreMenu)
  if ikwList[107]['keyword']  in ingreMenu:
    ingr_108.append(ingreMenu)
  if ikwList[108]['keyword']  in ingreMenu:
    ingr_109.append(ingreMenu)
  if ikwList[109]['keyword']  in ingreMenu:
    ingr_110.append(ingreMenu)
  if ikwList[110]['keyword']  in ingreMenu:
    ingr_111.append(ingreMenu)
  if ikwList[111]['keyword']  in ingreMenu:
    ingr_112.append(ingreMenu)
  if ikwList[112]['keyword']  in ingreMenu:
    ingr_113.append(ingreMenu)
  if ikwList[113]['keyword']  in ingreMenu:
    ingr_114.append(ingreMenu)
  if ikwList[114]['keyword']  in ingreMenu:
    ingr_115.append(ingreMenu)
  if ikwList[115]['keyword']  in ingreMenu:
    ingr_116.append(ingreMenu)
  if ikwList[116]['keyword']  in ingreMenu:
    ingr_117.append(ingreMenu)
  if ikwList[117]['keyword']  in ingreMenu:
    ingr_118.append(ingreMenu)
  if ikwList[118]['keyword']  in ingreMenu:
    ingr_119.append(ingreMenu)
  if ikwList[119]['keyword']  in ingreMenu:
    ingr_120.append(ingreMenu)
  if ikwList[120]['keyword']  in ingreMenu:
    ingr_121.append(ingreMenu)
  if ikwList[121]['keyword']  in ingreMenu:
    ingr_122.append(ingreMenu)
  if ikwList[122]['keyword']  in ingreMenu:
    ingr_123.append(ingreMenu)
  if ikwList[123]['keyword']  in ingreMenu:
    ingr_124.append(ingreMenu)
  if ikwList[124]['keyword']  in ingreMenu:
    ingr_125.append(ingreMenu)

ikDict = {
  "쑥" : ingr_01,
  "달래" : ingr_02,
  "냉이" : ingr_03,
  "두릅" : ingr_04,
  "우엉" : ingr_05,
  "딸기" : ingr_06,
  "매실" : ingr_07,
  "꼬막" : ingr_08,
  "더덕" : ingr_09,
  "미더덕" : ingr_10,
  "바지락" : ingr_11,
  "다슬기" : ingr_12,
  "장어" : ingr_13,
  "감자" : ingr_14,
  "토마토" : ingr_15,
  "전복" : ingr_16,
  "참외" : ingr_17,
  "복숭아" : ingr_18,
  "갈치" : ingr_19,
  "고구마" : ingr_20,
  "옥수수" : ingr_21,
  "도라지" : ingr_22,
  "키조개" : ingr_23,
  "은행" : ingr_24,
  "배추" : ingr_25,
  "게" : ingr_26,
  "귤" : ingr_27,
  "호박" : ingr_28,
  "대하" : ingr_29,
  "새우" : ingr_30,
  "굴" : ingr_31,
  "꼬막" : ingr_32,
  "고등어" : ingr_33,
  "꽁치" : ingr_34,
  "홍합" : ingr_35,
  "삼치" : ingr_36,
  "사과" : ingr_37,
  "마늘" : ingr_38,
  "맛살" : ingr_39,
  "참치" : ingr_40,
  "아보카도" : ingr_41,
  "크림" : ingr_42,
  "만두" : ingr_43,
  "콩나물" : ingr_44,
  "삼겹살" : ingr_45,
  "채소" : ingr_46,
  "묵은지" : ingr_47,
  "연어" : ingr_48,
  "오징어" : ingr_49,
  "베이컨" : ingr_50,
  "달걀" : ingr_51,
  "카레" : ingr_52,
  "버섯" : ingr_53,
  "가지" : ingr_54,
  "고추" : ingr_55,
  "오이" : ingr_56,
  "깍두기" : ingr_57,
  "된장" : ingr_58,
  "카르보나라" : ingr_59,
  "쌈장" : ingr_60,
  "떡볶이" : ingr_61,
  "열무" : ingr_62,
  "소보로" : ingr_63,
  "멸치" : ingr_64,
  "포두부" : ingr_65,
  "연두부" : ingr_66,
  "순두부" : ingr_67,
  "두부" : ingr_68,
  "양배추" : ingr_69,
  "날치알" : ingr_70,
  "양파" : ingr_71,
  "대파" : ingr_72,
  "치즈" : ingr_73,
  "어묵" : ingr_74,
  "골뱅이" : ingr_75,
  "버터" : ingr_76,
  "순대" : ingr_77,
  "할라피뇨" : ingr_78,
  "햄" : ingr_79,
  "콩" : ingr_80,
  "짜장" : ingr_81,
  "미나리" : ingr_82,
  "게살" : ingr_83,
  "부추" : ingr_84,
  "매생이" : ingr_85,
  "시금치" : ingr_86,
  "당근" : ingr_87,
  "크래미" : ingr_88,
  "피자" : ingr_89,
  "팽이" : ingr_90,
  "흑임자" : ingr_91,
  "아스파라거스" : ingr_92,
  "노각" : ingr_93,
  "바나나" : ingr_94,
  "명란" : ingr_95,
  "꽁치" : ingr_96,
  "백합" : ingr_97,
  "황태" : ingr_98,
  "견과류" : ingr_99,
  "토란" : ingr_100,
  "고사리" : ingr_101,
  "낙지" : ingr_102,
  "번데기" : ingr_103,
  "깨" : ingr_104,
  "완자" : ingr_105,
  "미소" : ingr_106,
  "깻잎" : ingr_107,
  "맥주" : ingr_108,
  "생태" : ingr_109,
  "도루묵" : ingr_110,
  "해물" : ingr_111,
  "차돌박이" : ingr_112,
  "동태" : ingr_113,
  "쥐포" : ingr_114,
  "톳" : ingr_115,
  "청경채" : ingr_116,
  "연근" : ingr_117,
  "파래" : ingr_118,
  "파프리카" : ingr_119,
  "랍스터" : ingr_120,
  "곤약" : ingr_121,
  "시래기" : ingr_122,
  "등갈비" : ingr_123,
  "가자미" : ingr_124,
  "숙주" : ingr_125,
}

ingreMenuDict = {
  "mkDict" : mkDict,
  "ikDict" : ikDict
}

