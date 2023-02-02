import React, { useState } from "react";
import { useEffect } from "react";
import { instance } from "../components/api/Api";
//template
import { Button, Form, InputGroup } from "react-bootstrap";
//component
import Header from "../components/common/Header";
import RecipeListComponent from "../components/recipe/List/RecipeListComponent";

const RecipePage = () => {
  const [search, setSearch] = useState("");
  const [isSearch, setIsSearch] = useState(false);
  const [recipeList, setRecipeList] = useState([]);
  const [filterItem, setFilterItem] = useState([]);

  useEffect(() => {
    //전체 레시피 받기
    const onRecipeList = async () => {
      try {
        const response = await instance.get(`/api/recipe`);
        setRecipeList(response.data.body.recipes);
        console.log("리스트" + JSON.stringify(recipeList));
      } catch (error) {
        console.log(error);
      }
    };
    onRecipeList();
  }, []);

  useEffect(() => {
    if (search === "") {
      setIsSearch(false);
      setFilterItem([]);
    } else {
      setIsSearch(true);
      const name = recipeList.filter((item) => {
        return item.name.includes(search);
      });
      setFilterItem(name);
      console.log("필터된레시피" + name);
    }
  }, [search]);

  console.log("필터" + JSON.stringify(filterItem));
  return (
    <div className="page recipe-page">
      <Header />
      <div className="layout container">
        <div className="search">
          <InputGroup>
            <Form.Control
              placeholder="메뉴 이름을 검색하세요."
              type="text"
              onChange={(e) => {
                setSearch(e.target.value);
              }}
            />
            <Button variant="outline-primary" className="btn-find">
              찾기
            </Button>
          </InputGroup>
        </div>
        <RecipeListComponent filterItem={filterItem} isSearch={isSearch} />
      </div>
    </div>
  );
};

export default RecipePage;
