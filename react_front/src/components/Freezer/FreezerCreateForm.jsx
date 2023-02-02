import React, { useState, useCallback } from "react";
// template
import Card from "react-bootstrap/Card";
// icon

import { BsPlusCircleDotted } from "react-icons/bs";
import FredgeClose from "../fredge/FredgeClose";
import FreezerCreateModal from "./modals/FreezerCreateModal";

const FreezerCreateForm = ({ onRegister }) => {
  //냉장고 이름
  const [freezerName, SetFreezerName] = useState("");
  // modal
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const changeFreezerNameHandler = useCallback((e) => {
    SetFreezerName(e.target.value);
  }, []);

  const submitHandler = useCallback(
    (e) => {
      e.preventDefault();
      setShow(false);
      onRegister(freezerName);
    },
    [freezerName, onRegister]
  );

  return (
    <>
      <div className="character create">
        <Card>
          <div className="content-header">
            <div className="title">냉장고를 생성하세요. </div>
          </div>
          <div className="content-body">
            <FredgeClose />
            <button className="btn-add" onClick={handleShow}>
              <BsPlusCircleDotted className="icon" />
            </button>
          </div>
        </Card>
      </div>

      {show && (
        <FreezerCreateModal
          onShow={handleShow}
          onHide={handleClose}
          onSubmit={submitHandler}
          onChange={changeFreezerNameHandler}
          placeholder="냉장고 이름!"
          buttonName="생성"
        />
      )}
    </>
  );
};

export default FreezerCreateForm;
