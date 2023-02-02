import React, { useState } from "react";
import { useEffect } from "react";
import { instance } from "../api/Api";
// component
import ItemAddForm from "./ItemAddForm";
import ItemSearchForm from "./ItemSearchForm";

const ItemSearchAddComponent = (props) => {
  //재료검색..

  const [itemList, setItemList] = useState([]);
  const [filtered, setFiltered] = useState([]);

  /////////// 이 부분 뭔가 손 봐야 할것 같은데....?
  useEffect(() => {
    const itemSearch = async () => {
      try {
        const response = await instance.get(`/api/item`);
        const data = response.data.body.item;
        console.log("데이터" + JSON.stringify(data));
        setItemList(data);
      } catch (error) {
        console.log(error);
      }
    };
    itemSearch();
  }, []);

  const itemNameHandler = (name) => {
    const itemInfo = itemList.filter((item) => {
      return item.name == name;
    });
    setFiltered(itemInfo);
  };
  console.log("필터된거" + filtered);
  return (
    <div className="ingr-component">
      <div className="ingr-content">
        <ItemSearchForm itemList={itemList} itemNameHandler={itemNameHandler} />
        <ItemAddForm
          onFreezerItemAdd={props.onFreezerItemAdd}
          hide={props.hide}
          filtered={filtered}
        />
      </div>
    </div>
  );
};

export default ItemSearchAddComponent;
