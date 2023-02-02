import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
// template
import Card from "react-bootstrap/Card";
import Dropdown from "react-bootstrap/Dropdown";
// icon
import { AiOutlineMore } from "react-icons/ai";
import FredgeClose from "../fredge/FredgeClose";

import FreezerChangeModal from "./modals/FreezerChangeModal";
import FreezerDeleteModal from "./modals/FreezerDeleteModal";

const FreezerContainer = (props) => {
  const navigate = useNavigate();
  const index = props.index;

  // 이름 변경modal
  const [changeFreezerModal, setChangeFreezerModal] = useState(false);

  const changeModalShow = () => setChangeFreezerModal(true);
  const changeModalHide = () => setChangeFreezerModal(false);
  // 삭제 확인 모달
  const [deleteFreezerModal, setDeleteFreezerModal] = useState(false);

  const deleteModalShow = () => setDeleteFreezerModal(true);
  const deleteModalHide = () => setDeleteFreezerModal(false);

  //

  const freezerNavigateHandler = (e) => {
    e.preventDefault();
    navigate(`/inventory/${index}`, { state: index });
  };

  return (
    <div className="character">
      <Card>
        <div className="content-header">
          <div className="title">{props.onFreezer.name}</div>
          <Dropdown className="character-dropdown custom-dropdown">
            <Dropdown.Toggle id="characterDropdown">
              <AiOutlineMore className="icon" />
            </Dropdown.Toggle>
            <Dropdown.Menu>
              <Dropdown.Item onClick={changeModalShow}>이름 변경</Dropdown.Item>
              <Dropdown.Item onClick={deleteModalShow}>삭제</Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        </div>
        <div className="content-body" onClick={freezerNavigateHandler}>
          <FredgeClose />
        </div>
      </Card>
      {changeFreezerModal && (
        <FreezerChangeModal
          onShow={changeModalShow}
          onHide={changeModalHide}
          onChange={props.onChange}
          index={props.index}
          placeholder="냉장고 이름 뭘로 바꿀까용"
          buttonName="수정"
        />
      )}

      {deleteFreezerModal && (
        <FreezerDeleteModal
          onShow={deleteModalShow}
          onHide={deleteModalHide}
          onChange={props.onChange}
          index={props.index}
        />
      )}
    </div>
  );
};

export default FreezerContainer;
