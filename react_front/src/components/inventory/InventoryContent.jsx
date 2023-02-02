import React from "react";
// component
import InventoryPage from "../../page/InventoryPage";

const InventoryContent = (props) => {
  return (
    <main className="contents">
      <InventoryPage index={props.index} />
    </main>
  );
};

export default InventoryContent;
