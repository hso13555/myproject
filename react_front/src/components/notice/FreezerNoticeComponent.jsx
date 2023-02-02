import React, { useState } from "react";
import { useEffect } from "react";
import Card from "react-bootstrap/Card";
import CloseButton from "react-bootstrap/CloseButton";
import { instance } from "../api/Api";

const FreezerNoticeComponent = (props) => {
  const [itemList, setItemList] = useState([]);

  useEffect(() => {
    const onItemList = async () => {
      console.log("onItemList 실행됌");
      try {
        const response = await instance.get(`/api/inventory/all`);
        const data = response.data.body.inventoryItem;
        console.log("바디값" + JSON.stringify(data));
        setItemList(data);
      } catch (error) {
        console.log(error);
      }
    };

    onItemList();
  }, []);

  console.log("날짜" + Date.now());

  const convertDate = (milliSecond) => {
    const days = ["일", "월", "화", "수", "목", "금", "토"];
    const data = new Date(milliSecond); //Date객체 생성

    const year = data.getFullYear(); //0000년 가져오기
    const month = data.getMonth() + 1; //월은 0부터 시작하니 +1하기
    const date = data.getDate(); //일자 가져오기
    const day = days[data.getDay()]; //요일 가져오기

    return `${year}.${month}.${date}. (${day})`;
  };

  return (
    <div className="notice-component">
      <div className="notice-content">
        <Card>
          <div className="content-header">
            <Card.Title>냉장고 알림</Card.Title>
            <CloseButton className="right" onClick={props.onClick} />
          </div>
          <div className="content-body">
            <Card.Body>
              {itemList
                .filter(
                  (itemList) => itemList.expDate - Date.now() < "432000000"
                )
                .map((itemList) => (
                  <div className="notice">
                    <div className="img"> {itemList.item.name}</div>
                    <div className="text">
                      <div className="title">유통기한 임박!</div>
                      <span className="date-text">
                        {convertDate(itemList.expDate)}
                      </span>
                    </div>
                  </div>
                ))}
            </Card.Body>
          </div>
        </Card>
      </div>
    </div>
  );
};

export default FreezerNoticeComponent;
