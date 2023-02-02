import React, { useEffect, useState } from "react";
import { instance } from "../api/Api";
import RecipeContentModal from "./modals/RecipeContentModal";
// component

const RecipesSearch = ({ itemName }) => {
  const [recipeNameList, setRecipeNameList] = useState([]);
  const [recipeShow, setRecipeShow] = useState(false);
  const [recipeName, setRecipeName] = useState();
  const handleClose = () => setRecipeShow(false);
  const itemHandleShow = (name) => {
    setRecipeShow(true);
    setRecipeName(name);
  };

  useEffect(() => {
    // 재료 이름으로 레시피 제목 검색
    const onSearchRecipeName = async () => {
      try {
        const response = await instance.get(
          `/api/recipeItem/recipe/${itemName}`
        );
        const data = response.data.body.recipeItems;
        console.log("레시피데이터" + JSON.stringify(data));
        setRecipeNameList(data);
      } catch (error) {
        console.log(error);
      }
    };
    onSearchRecipeName();
  }, [itemName]);

  return (
    <>
      {recipeNameList.map((recipeNameList) => (
        <div className="item col" key={recipeNameList.recipeName}>
          <img
            alt="재료 사진"
            className="item-img"
            src={recipeNameList.recipeImg}
            onClick={() => itemHandleShow(recipeNameList.recipeName)}
          />
          <div className="item-title">{recipeNameList.recipeName}</div>
        </div>
      ))}
      <RecipeContentModal
        recipeShow={recipeShow}
        handleClose={handleClose}
        recipeName={recipeName}
      />
    </>
  );
};

export default RecipesSearch;
