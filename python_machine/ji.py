from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

import time
import json

from webdriver_manager.chrome import ChromeDriverManager

# 브라우저 꺼짐 방지
chrome_options = Options()
chrome_options.add_experimental_option('detach', True)
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

# 브라우저 생성
browser = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

def recipe_group() :

  # 메뉴 이름
  menu_title = driver.find_element(By.CSS_SELECTOR, '.view2_summary h3').text
  # 인분
  menu_info1 = driver.find_element(By.CSS_SELECTOR, '.view2_summary_info1').text
  # 시간
  menu_info2 = driver.find_element(By.CSS_SELECTOR, '.view2_summary_info2').text
  # 난이도
  menu_info3 = driver.find_element(By.CSS_SELECTOR, '.view2_summary_info3').text

  # 재료 구성
  ingres = driver.find_elements(By.CSS_SELECTOR, '#divConfirmedMaterialArea ul li')
  ingre_list = []
  for ingre in ingres :
    ingre_attr = ingre.find_element(By.CSS_SELECTOR, 'a').text
    ingre_attr_unit = ingre.find_element(By.CSS_SELECTOR, '.ingre_unit').text
    ingre_list.append(ingre_attr)
    ingre_list.append(ingre_attr_unit)

  # 조리 순서
  cook_step = driver.find_elements(By.CSS_SELECTOR, '.view_step .view_step_cont')
  step_list = []
  for step in cook_step :
    step_cont = step.find_element(By.CSS_SELECTOR, '.media-body').text.replace(" ", "")
    step_list.append(step_cont)

  # 출력
  menu_recipe = {
    "title" : menu_title,
    "menu_info1" : menu_info1,
    "menu_info2" : menu_info2,
    "menu_info3" : menu_info3,
    "ingre" : ingre_list,
    "recipe" : step_list
  }

  print(menu_recipe)

  # 레시피 json 저장
  path = './data/recipe_data.json'
  with open(path, 'a', encoding="utf-8") as file:
    json.dump(menu_recipe, file, indent="\t", ensure_ascii=False)


while True:
  driver.get('https://www.10000recipe.com/recipe/list.html?q=&query=&cat1=&cat2=&cat3=&cat4=63&fct=&order=reco&lastcate=cat4&dsearch=&copyshot=&scrap=&degree=&portion=&time=&niresource=')
  driver.implicitly_wait(5) # 웹 페이지 로딩 될 떄까지 5초 기다림

  menu_list = driver.find_element(By.CSS_SELECTOR, '.common_sp_list_ul .common_sp_list_li')

  item_link = driver.find_elements(By.CSS_SELECTOR, '.common_sp_link')



  print(item_link)

  item_link.click()
  time.sleep(2)

  recipe = recipe_group()
  print(recipe)

  # 페이지 뒤로가기
  driver.back()
  time.sleep(5)