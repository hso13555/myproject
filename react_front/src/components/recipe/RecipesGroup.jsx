import React from "react";
//component
import RecipesSearch from "./RecipesSearch";

const RecipesGroup = ({ itemName }) => {
  return (
    <div className="item-group row">
      <RecipesSearch itemName={itemName} />
    </div>
  );
};

export default RecipesGroup;
