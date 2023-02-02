import React, { useState } from "react";
import { Link, Route } from "react-router-dom";
import { instance } from "../../api/Api";
import { useEffect } from "react";
import { Paging } from "../../common/Paging";
import { useNavigate } from "react-router-dom";

const RecipeListComponent = (props) => {
  const [recipeList, setRecipeList] = useState([]);
  const [likedList, setLikedList] = useState([]);
  const [currentpage, setCurrentpage] = useState(1); //현재페이지
  const [postPerPage] = useState(10); //페이지당 아이템 개수

  const [indexOfLastPost, setIndexOfLastPost] = useState(0);
  const [indexOfFirstPost, setIndexOfFirstPost] = useState(0);
  const [currentPosts, setCurrentPosts] = useState(0);

  const navigate = useNavigate();

  useEffect(() => {
    setIndexOfLastPost(currentpage * postPerPage);
    setIndexOfFirstPost(indexOfLastPost - postPerPage);
    setCurrentPosts(recipeList.slice(indexOfFirstPost, indexOfLastPost));
  }, [currentpage, indexOfFirstPost, indexOfLastPost, recipeList, postPerPage]);

  useEffect(() => {
    //전체 레시피 잘라서 받기
    const onRecipeList = async () => {
      try {
        const response = await instance.get(
          `/api/recipe?page=${currentpage}&size=${postPerPage}&sort=id,desc`
        );
        console.log("레시피데이터" + JSON.stringify(response));
        setRecipeList(response.data.body.recipes);
        console.log("리스트" + JSON.stringify(recipeList));
      } catch (error) {
        console.log(error);
      }
    };
    onRecipeList();
  }, [currentpage]);

  const setPage = (e) => {
    setCurrentpage(e);
  };
  useEffect(() => {
    const onLikedList = async () => {
      try {
        const response = await instance.get(`/api/liked/me`);
        console.log("나의 좋아요 데이터" + JSON.stringify(response.data.body));
        setLikedList(response.data.body.likedRecipeRespDto);
      } catch (error) {
        console.log(error);
      }
    };
    onLikedList();
  }, []);
  return (
    <>
      <h5>
        좋아요한 레시피 <span>(1050)</span>
      </h5>
      <div className="recipe-component">
        <div className="recipe-content">
          <div className="recipe-list">
            {likedList.map((r) => (
              <div className="recipe-item" key={r.id}>
                <img
                  className="list-img"
                  src={r.recipe.img}
                  alt={r.recipe.name}
                  onClick={() => navigate(`/recipe/${r.recipe.id}`)}
                />
                <div className="list-title">{r.recipe.name}</div>
              </div>
            ))}
          </div>
        </div>
      </div>
      <h5>
        레시피 <span>(1050)</span>
      </h5>
      <div className="recipe-component">
        <div className="recipe-content">
          <div className="recipe-list">
            {recipeList.map((r) => (
              <div className="recipe-item" key={r.id}>
                <img
                  className="list-img"
                  src={r.img}
                  alt={r.name}
                  onClick={() => navigate(`/recipe/${r.id}`)}
                />
                <div className="list-title">{r.name}</div>
              </div>
            ))}
          </div>
        </div>
      </div>
      <Paging page={currentpage} count="1050" setPage={setPage} />
    </>
  );
};

export default RecipeListComponent;
