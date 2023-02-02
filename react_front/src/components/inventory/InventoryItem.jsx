import React, { useState } from "react";
import NutrientComponent from "../nutrient/NutrientComponent";

const InventoryItem = (props) => {
  const itemList = props.itemList;
  const [itemInfo, setItemInfo] = useState([]);
  const [showModal, setShowModal] = useState(false);

  const index = props.index;

  console.log("아이템인포" + JSON.stringify(itemInfo));

  const closeModalHandler = () => {
    setShowModal(false);
  };

  const modalHandler = (itemName) => {
    console.log("파인드" + itemList.find((e) => e.item.name));
    setItemInfo(itemList.find((e) => e.item.name === itemName));
    setShowModal(true);
  };
  console.log("아이템인포" + itemInfo);
  return (
    <>
      <div className="item col">
        {itemList
          .filter((it) => {
            return it.storage === props.storage;
          })
          .map((it) => (
            <li key={it.id}>
              <img
                alt="itemImage"
                className="item-img"
                src={it.item.img}
                onClick={() => modalHandler(it.item.name)}
              />
              <div>{it.item.name}</div>
            </li>
          ))}

        {showModal ? (
          <NutrientComponent
            setItemReload={props.setItemReload}
            itemInfo={itemInfo}
            show={showModal}
            onHide={closeModalHandler}
            setItemInfo={setItemInfo}
          />
        ) : null}
      </div>
    </>
  );
};

export default InventoryItem;
