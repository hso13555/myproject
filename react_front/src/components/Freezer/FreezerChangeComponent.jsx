import React from "react";
import { useState, useEffect } from "react";
import { instance } from "../api/Api";
//template
import Card from "react-bootstrap/Card";
import CloseButton from "react-bootstrap/CloseButton";
//component
import FreezerChangeContainer from "./FreezerChangeContainer";

const FreezerChangeComponent = (props) => {
  const [freezer, SetFreezer] = useState([]);

  //조회처리
  const onListUp = async () => {
    try {
      const response = await instance.get("/api/freezer");
      const data = response.data.body.freezers;
      console.log(data)
      SetFreezer(data);
    } catch (error) {
      console.log("에러" + error);
    }
  };

  useEffect(() => {
    onListUp();
  }, []);

  return (
    <div className="change-component">
      <div className="change-content">
        <Card>
          <div className="content-header">
            <Card.Title>냉장고 체인지</Card.Title>
            <CloseButton className="right" onClick={props.onClick} />
          </div>
          <div className="content-body">
            <Card.Body>
              <FreezerChangeContainer freezer={freezer} />
            </Card.Body>
          </div>
        </Card>
      </div>
    </div>
  );
};

export default FreezerChangeComponent;
