import numpy as np
import pandas as pd
import json
import csv

# 키워드별 메뉴 가져오기
path2 = "./menu/json/menu.json"

with open(path2, "r", encoding="utf-8") as json_file:
  json_data = json.load(json_file)
json.dumps(json_data, indent="\t", ensure_ascii=False)

# 메뉴 분류
menuKeywordList = []
menuIngreList = []

for idx, i in enumerate(json_data):
  menuKeyword = i['mkDict']
  menuIngre = i['ikDict']

  menuKeywordList.append(menuKeyword)
  menuIngreList.append(menuIngre)

# 제철 메뉴 분류
seasonList = []
seasonDict = {}

for s_mil in menuIngreList:
  season_01 = s_mil['달래'] + s_mil['냉이']
  season_02 = s_mil['토마토'] + s_mil['참외']
  season_03 = s_mil['대하'] + s_mil['은행']
  season_04 = s_mil['배추'] + s_mil['삼치']

  for s_01 in season_01:
    seasons = np.array(
      ["봄", 3, 4, 5, s_01]
    )

    seasonDict = {
      "seasonName" : seasons[0],
      'seasonStartMonth' : seasons[1],
      'seasonMidleMonth' : seasons[2],
      'seasonEndMonth' : seasons[3],
      'menuName' : seasons[4]
    }
    seasonList.append(seasonDict)

  for s_02 in season_02:
    seasons = np.array(
      ["여름", 6, 7, 8, s_02]
    )
    seasonDict = {
      "seasonName" : seasons[0],
      'seasonStartMonth' : seasons[1],
      'seasonMidleMonth' : seasons[2],
      'seasonEndMonth' : seasons[3],
      'menuName' : seasons[4]
    }
    seasonList.append(seasonDict)
  
  for s_03 in season_03:
    seasons = np.array(
      ["가을", 9, 10, 11, s_03]
    )
    seasonDict = {
      "seasonName" : seasons[0],
      'seasonStartMonth' : seasons[1],
      'seasonMidleMonth' : seasons[2],
      'seasonEndMonth' : seasons[3],
      'menuName' : seasons[4]
    }
    seasonList.append(seasonDict)
  
  for s_04 in season_04:
    seasons = np.array(
      ["겨울", 12,1, 2, s_04]
    )
    seasonDict = {
      "seasonName" : seasons[0],
      'seasonStartMonth' : seasons[1],
      'seasonMidleMonth' : seasons[2],
      'seasonEndMonth' : seasons[3],
      'menuName' : seasons[4]
    }
    seasonList.append(seasonDict)

# 시간 메뉴 분류
timeList = []
timeDict = {}

for t_mkl in menuKeywordList:
  time_01 = t_mkl['샌드위치'] + t_mkl['김밥']
  time_02 = t_mkl['볶음밥'] + t_mkl['샐러드']
  time_03 = t_mkl['돼지'] + t_mkl['볶음탕']
  time_04 = t_mkl['카나페'] + t_mkl['강정']
  time_05 = t_mkl['곱창'] + t_mkl['꼬치']

  for t_01 in time_01:
    times = np.array(
      ["아침", 6, 10, t_01]
    )

    timeDict = {
      'timeName' : times[0],
      'timeStart' : times[1],
      'timeEnd' : times[2],
      'menuName' : times[3]
    }
    timeList.append(timeDict)

  for t_02 in time_02:
    times = np.array(
      ["점심", 11, 14, t_02]
    )

    timeDict = {
      'timeName' : times[0],
      'timeStart' : times[1],
      'timeEnd' : times[2],
      'menuName' : times[3]
    }
    timeList.append(timeDict)

  for t_03 in time_03:
    times = np.array(
      ["저녁", 17, 20, t_03]
    )

    timeDict = {
      'timeName' : times[0],
      'timeStart' : times[1],
      'timeEnd' : times[2],
      'menuName' : times[3]
    }
    timeList.append(timeDict)

  for t_04 in time_04:
    times = np.array(
      ["간식", 11, 16, t_04]
    )

    timeDict = {
      'timeName' : times[0],
      'timeStart' : times[1],
      'timeEnd' : times[2],
      'menuName' : times[3]
    }
    timeList.append(timeDict)

  for t_05 in time_05:
    times = np.array(
      ["야식", 21, 24, t_05]
    )

    timeDict = {
      'timeName' : times[0],
      'timeStart' : times[1],
      'timeEnd' : times[2],
      'menuName' : times[3]
    }
    timeList.append(timeDict)

# 날씨 메뉴 분류
weatherList = []
weatherDict = {}

for w_mkl in menuKeywordList:
  weather_01 = w_mkl['돼지']
  weather_02 = w_mkl['국밥']
  weather_03 = w_mkl['찌개']
  weather_04 = w_mkl['파전'] + w_mkl['부침개'] + w_mkl['전']
  weather_05 = w_mkl['전골']
  weather_06 = w_mkl['찜']
  weather_07 = w_mkl['샤브샤브']
  weather_08 = w_mkl['백숙']
  weather_09 = w_mkl['냉국']
  weather_10 = w_mkl['탕'] + w_mkl['나베']

  for w_01 in weather_01:
    weathers = np.array(
      ["Clear", "맑음", w_01]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_02 in weather_02:
    weathers = np.array(
      ["Cloud", "구름", w_02]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_03 in weather_03:
    weathers = np.array(
      ["Wind", "바람", w_03]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_04 in weather_04:
    weathers = np.array(
      ["Rain", "비", w_04]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_05 in weather_05:
    weathers = np.array(
      ["Snow", "눈", w_05]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_06 in weather_06:
    weathers = np.array(
      ["Fog", "안개", w_06]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_07 in weather_07:
    weathers = np.array(
      ["Hail", "우박", w_07]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_08 in weather_08:
    weathers = np.array(
      ["Tropical Night", "열대야", w_08]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_09 in weather_09:
    weathers = np.array(
      ["Heat Wave", "폭염", w_09]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

  for w_10 in weather_10:
    weathers = np.array(
      ["Cold Wave", "한파", w_10]
    )

    weatherDict = {
      'weatherEnName' : weathers[0],
      'weatherKrName' : weathers[1],
      'menuName' : weathers[2]
    }
    weatherList.append(weatherDict)

# 온도 메뉴 분류
tempList = []
tempDict = {}

for ts_mil in menuIngreList:
  temp_01 = ts_mil['게']
  temp_02 = ts_mil['홍합'] + ts_mil['꼬막']
  temp_03 = ts_mil['딸기'] + ts_mil['굴']
  temp_04 = ts_mil['다슬기'] + ts_mil['옥수수']
  temp_05 = ts_mil['복숭아'] + ts_mil['감자']
  temp_06 = ts_mil['고구마']
  temp_07 = ts_mil['장어']
  temp_08 = ts_mil['전복']

  for tp_01 in temp_01:
    temps = np.array(
      ["", 0, tp_01]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

  for tp_02 in temp_02:
    temps = np.array(
      [1, 5, tp_02]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

  for tp_03 in temp_03:
    temps = np.array(
      [5, 10, tp_03]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

  for tp_04 in temp_04:
    temps = np.array(
      [10, 15, tp_04]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

  for tp_05 in temp_05:
    temps = np.array(
      [15, 20, tp_05]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

  for tp_06 in temp_06:
    temps = np.array(
      [20, 25, tp_06]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

  for tp_07 in temp_07:
    temps = np.array(
      [25, 30, tp_07]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

  for tp_08 in temp_08:
    temps = np.array(
      [30, "" ,tp_08]
    )

    tempDict = {
      'lowestTemp' : temps[0],
      'highestTemp' : temps[1],
      'menuName' : temps[2]
    }
    tempList.append(tempDict)

# csv 파일 저장
seasonData = pd.DataFrame(seasonList)
seasonData.to_csv("./menu/csv/seasonData.csv", encoding='utf-8-sig')

timeData = pd.DataFrame(timeList)
timeData.to_csv("./menu/csv/timeData.csv", encoding='utf-8-sig')

weatherData = pd.DataFrame(weatherList)
weatherData.to_csv("./menu/csv/weatherData.csv", encoding='utf-8-sig')

tempData = pd.DataFrame(tempList)
tempData.to_csv("./menu/csv/tempData.csv", encoding='utf-8-sig')


