import React from "react";
// template
import Card from "react-bootstrap/Card";
// component
import WeatherComponent from "../weather/WeatherComponent";
import TimeComponent from "../time/TimeComponent";

const ItemContentComponent = () => {
  return (
    <div className="ingr-content-component">
      <WeatherComponent />
      <TimeComponent />
      {/* <NutrientComponent /> */}
      {/* <RecipesComponent /> */}
    </div>
  );
};

export default ItemContentComponent;
