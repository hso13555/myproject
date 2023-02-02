import React from "react";
// component
import { useLocation } from "react-router-dom";
import InventoryContent from "./InventoryContent";
import Header from "../common/Header";
import { useParams } from "react-router-dom";

const InventoryLayout = () => {
  const params = useParams();
  console.log("파람" + JSON.stringify(params));
  const index = params.index;
  console.log("최초 ContentLayout" + index);
  return (
    <div className="components cts">
      <Header />
      <InventoryContent index={index} />
    </div>
  );
};

export default InventoryLayout;
