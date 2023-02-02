from urllib.parse import quote_plus
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import json


def crolling(plusUrl):
    baseUrl = 'https://www.google.com/search?q='
    url = baseUrl + quote_plus(plusUrl)

    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))
    driver.get(url)

    html = driver.page_source
    soup = BeautifulSoup(html, 'html.parser')

    # 이름
    nameIngr = plusUrl

    # 이미지
    try:
        img = soup.select_one(
            '#media_result_group > div > div > div:nth-child(2) > div > div:nth-child(1) > a > div > div > img')[
            "src"]
    except:
        img = '';

    # 1회 제공량당 함량
    try:
        servingSize = soup.select_one('#kno-nf-nc > table > tbody > tr:nth-child(1) > td > div > div > select').text
    except:
        servingSize = '';

    # 열량
    try:
        calorie = soup.select_one('#kno-nf-nc > table > tbody > tr.PZPZlf.kno-nf-cq > td > span.abs').text
    except:
        calorie = '';

    # 지방
    try:
        fat = soup.select_one(
            '#kno-nf-na > table:nth-child(1) > tbody > tr:nth-child(1) > td:nth-child(1) > span.abs').text
    except:
        fat = '';

    # 콜레스테롤
    try:
        cholesterol = soup.select_one(
            '#kno-nf-na > table:nth-child(1) > tbody > tr:nth-child(3) > td:nth-child(1) > span.abs').text
    except:
        cholesterol = '';

    # 나트륨
    try:
        sodium = soup.select_one(
            '#kno-nf-na > table:nth-child(1) > tbody > tr:nth-child(4) > td:nth-child(1) > span.abs').text
    except:
        sodium = '';
    # 칼륨
    try:
        potassium = soup.select_one(
            '#kno-nf-na > table:nth-child(1) > tbody > tr:nth-child(5) > td:nth-child(1) > span.abs').text

    except:
        potassium = '';


    # 탄수화물
    try :
        carbohydrates = soup.select_one(
            '#kno-nf-na > table:nth-child(1) > tbody > tr:nth-child(6) > td:nth-child(1) > span.abs').text
    except :
        carbohydrates = '';
    # 단백질
    try :
        protein = soup.select_one(
            '#kno-nf-na > table:nth-child(1) > tbody > tr:nth-child(9) > td:nth-child(1) > span.abs').text
    except :
        protein = '';

    print(img)
    print(nameIngr)
    print(servingSize)
    print(calorie)
    print(fat)
    print(cholesterol)
    print(sodium)
    print(potassium)
    print(carbohydrates)
    print(protein)

    # json 데이터 만들기
    item_ingr = {nameIngr: {"servingSize": servingSize, "calorie": calorie, "fat": fat, "cholesterol": cholesterol,
                            "sodium": sodium, "potassium": potassium, "carbohydrates": carbohydrates,
                            "protein": protein,
                            "img_url": img}}

    file_path = "./test.json"

    with open(file_path, 'a', encoding='utf-8') as file:
        json.dump(item_ingr, file, ensure_ascii=False)
        file.write('\n')


test_list = ['양파', '키위', '사과', '고등어', '소고기', '시금치', '배추']
for i in test_list:
    try:
        crolling(i)
    except Exception as e:
        print(e)
