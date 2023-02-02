import React, { useEffect, useState } from "react";
import { instance } from "../api/Api";
// component

const RecipesContentList = (props) => {
  const [recipeList, setRecipeList] = useState([]);
  console.log("이름" + props.recipeName);
  const recipeName = props.recipeName;
  useEffect(() => {
    const onSearchRecipeList = async () => {
      try {
        const response = await instance.get(`/api/recipeList/${recipeName}`);
        const data = response.data.body.recipeContentList;
        console.log("응답" + JSON.stringify(data));
        setRecipeList(data);
      } catch (error) {
        console.log(error);
      }
    };
    onSearchRecipeList();
  }, [recipeName]);

  return (
    <>
      <h5>{props.recipeName} 만들기</h5>
      {recipeList.map((recipeList, index) => (
        <div key={index} className="items-component">
          <div className="items-content">
            <div className="content-header">
              <div className="content-body">{recipeList.recipeList}</div>
            </div>
          </div>
        </div>
      ))}
    </>
  );
};

export default RecipesContentList;
