import React from "react";
// component
import NutrientModal from "./modals/NutrientModal";

const NutrientComponent = (props) => {
  return (
    <NutrientModal
      setItemReload={props.setItemReload}
      show={props.show}
      onHide={props.onHide}
      itemInfo={props.itemInfo}
      setItemInfo={props.setItemInfo}
    />
  );
};

export default NutrientComponent;
