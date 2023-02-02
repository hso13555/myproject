import React from "react";
import RecipeData from "../../../db/recipe.json";
import { Button } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import { instance } from "../../api/Api";
import { useEffect } from "react";
import { useState } from "react";

const Recipe = () => {
  const param = useParams();
  const navigate = useNavigate();

  const [recipe, setRecipe] = useState([]);
  const [recipeList, setRecipeList] = useState([]);
  const [recipeItem, setRecipeItem] = useState([]);
  const [isLiked, setIsLiked] = useState(false);

  const recipeId = param.recipeId;
  const recipeItems = RecipeData[5];
  useEffect(() => {
    //레시피 이름, 레시피 이미지
    const onRecipe = async () => {
      try {
        const response = await instance.get(`/api/recipe/${recipeId}`);
        console.log("레시피데이터" + JSON.stringify(response.data.body));
        setRecipe(response.data.body);
        onRecipeContent(response.data.body.name);
        onRecipeItem(response.data.body.name);
      } catch (error) {
        console.log(error);
      }
    };
    onRecipe();
    onExistLikedRecipe();
  }, []);

  //레시피 리스트
  const onRecipeContent = async (name) => {
    try {
      const response = await instance.get(`/api/recipeList/${name}`);
      console.log(
        "레시피리스트 데이터" +
          JSON.stringify(response.data.body.recipeContentList)
      );
      setRecipeList(response.data.body.recipeContentList);
    } catch (error) {
      console.log(error);
    }
  };

  const onRecipeItem = async (name) => {
    try {
      const response = await instance.get(`/api/recipeItem/${name}`);
      console.log(
        "레시피아이템" + JSON.stringify(response.data.body.recipeItems)
      );
      setRecipeItem(response.data.body.recipeItems);
    } catch (error) {
      console.log(error);
    }
  };

  const onRecipeCount = async () => {
    try {
      const response = await instance.put(`/api/recipe/count/${recipeId}`);
      console.log("레시피아이템" + JSON.stringify(response));
    } catch (error) {
      console.log(error);
    }
  };

  const onAddLikedRecipe = async () => {
    const data = param;
    console.log("데이터" + JSON.stringify(data));
    try {
      const response = await instance.post(`/api/liked`, data);
      console.log("좋아요한 아이템 추가" + JSON.stringify(response));
    } catch (error) {
      console.log(error);
    }
  };
  const onExistLikedRecipe = async () => {
    const data = param.recipeId;
    console.log("데이터" + JSON.stringify(data));
    try {
      const response = await instance.get(`/api/liked/${data}`);
      console.log("한개 조회 완료" + response.data.body);
      if (response.data.body == true) {
        setIsLiked(true);
      } else {
        setIsLiked(false);
      }
    } catch (error) {
      console.log(error);
    }
  };

  const onDeleteLikedRecipe = async () => {
    const data = param.recipeId;

    console.log("데이터" + JSON.stringify(data));
    try {
      const response = await instance.delete(`/api/liked/${data}`);
      console.log("좋아요한 아이템 추가" + JSON.stringify(response));
    } catch (error) {
      console.log(error);
    }
  };

  const countUpHandler = (e) => {
    e.preventDefault();
    onRecipeCount();
    setIsLiked(!isLiked);
    onAddLikedRecipe();
  };

  const countDownHandler = (e) => {
    e.preventDefault();
    onRecipeCount();
    setIsLiked(!isLiked);
    onDeleteLikedRecipe();
  };

  return (
    <div className="recipe">
      <div className="content-header">
        <h5 className="sub-title">{recipeItems.menu_sub_title}</h5>
        <h2 className="title">{recipe.name}</h2>
        <img className="recipe-main-img" src={recipe.img} alt={recipe.name} />
      </div>
      <div className="content-body">
        <div className="ingrs">
          <div className="ingr-header">
            <h5 className="ingr-title">{recipeItems.ingre_title}</h5>
            <span className="ingr-sub">{recipeItems.ingre_sub}</span>
          </div>
          <div className="ingr-content">
            {recipeItem.map((i) => (
              <div className="ingr" key={i.id}>
                <span className="ingr-name">{i.itemName}</span>
                <span className="ingr-value">{i.itemCount}</span>
              </div>
            ))}
          </div>
        </div>

        <div className="recipe-desc">
          {recipeList.map((r) => (
            <div className="step" key={r.id}>
              <div className="step-desc">
                <div className="step-num">{r.recipeListNo}</div>
                <span className="step-cont">{r.recipeList}</span>
              </div>
              <img className="step-img" src={r.imgUrl} alt={r.recipeListNo} />
            </div>
          ))}
        </div>
      </div>
      <div className="content-footer">
        <Button
          variant="primary"
          className="btn-make"
          onClick={() => {
            navigate("/recipe");
          }}
        >
          뒤로가기
        </Button>
        {!isLiked ? (
          <Button
            variant="primary"
            className="btn-make"
            onClick={countUpHandler}
          >
            좋아요
          </Button>
        ) : (
          <Button
            variant="primary"
            className="btn-make"
            onClick={countDownHandler}
          >
            좋아요 취소
          </Button>
        )}
      </div>
    </div>
  );
};

export default Recipe;
