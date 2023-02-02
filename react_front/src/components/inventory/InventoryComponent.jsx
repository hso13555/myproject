import React, { useState, useEffect } from "react";
import { instance } from "../api/Api";
// component
import InventoryCarousel from "./InventoryCarousel";
import InventoryItemAdd from "./InventoryItemAdd";

const InventoryComponent = (props) => {
  const [itemCreateShow, setItemCreateShow] = useState(false);
  const [itemList, setItemList] = useState([]);
  const [itemReload, setItemReload] = useState(false);

  const index = props.index;

  useEffect(() => {
    const onItemList = async () => {
      console.log("onItemList 실행됌");
      try {
        const response = await instance.get(`/api/inventory/${index}`);
        const data = response.data.body.inventoryItem;
        setItemList(data);
        setItemReload(false);
      } catch (error) {
        console.log(error);
      }
    };

    onItemList();
  }, [itemReload, index]);

  // 냉장 보관 / 냉동 보관 / 실온 보관

  return (
    <div className="inventory-component">
      <div className="inventory-content">
        <div className="content-header">
          <InventoryItemAdd
            index={props.index}
            itemCreateShow={itemCreateShow}
            setItemCreateShow={setItemCreateShow}
            setItemReload={setItemReload}
            itemReload={itemReload}
          />
        </div>

        <div className="content-body">
          <InventoryCarousel
            setItemReload={setItemReload}
            index={props.index}
            itemCreateShow={itemCreateShow}
            itemList={itemList}
          />
        </div>
      </div>
    </div>
  );
};

export default InventoryComponent;
