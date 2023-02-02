import React, { useCallback, useState } from "react";
// template
import Button from "react-bootstrap/Button";
import ButtonGroup from "react-bootstrap/ButtonGroup";
import Form from "react-bootstrap/Form";
// icon
import { BiMinus } from "react-icons/bi";
import { BsPlus } from "react-icons/bs";
// component

const ItemAddForm = ({ onFreezerItemAdd, hide, filtered }) => {
  const [itemName, setItemName] = useState("");
  const [storage, setStorage] = useState("");
  const [expDate, setExpDate] = useState();
  const [regDate, setRegDate] = useState();

  const [isStorage, setIsStorage] = useState(false);
  const [isExpDate, setIsExpDate] = useState(false);
  const [isRegDate, setIsRegDate] = useState(false);

  const submitHandler = useCallback(
    (e) => {
      e.preventDefault();
      onFreezerItemAdd(itemName, storage, expDate, regDate);
    },
    [itemName, storage, expDate, regDate, onFreezerItemAdd]
  );

  const storageHandler = (e) => {
    e.preventDefault();
    setItemName(filtered[0].name);
    setStorage(e.target.value);
    setIsStorage(true);
  };

  const expDateHandler = (e) => {
    e.preventDefault();
    setExpDate(e.target.value);
    setIsExpDate(true);
  };
  console.log("유통기한" + expDate);
  const regDateHandler = (e) => {
    e.preventDefault();
    setRegDate(e.target.value);
    setIsRegDate(true);
  };
  console.log("등록일" + regDate);

  return (
    <div className="ingr">
      {filtered.map((item, index) => {
        return (
          <div className="ingr-img" key={index}>
            <img className="ingr-onion img" src={item.img} />
          </div>
        );
      })}

      <div className="ingr-content">
        <div className="ingr-form">
          <Form onSubmit={submitHandler}>
            <Form.Group className="mb-3 form-group" controlId="">
              <Form.Label>저장소</Form.Label>
              <Form.Select name="" onChange={storageHandler}>
                <option value="0">선택하세요</option>
                <option value="냉장">냉장</option>
                <option value="냉동">냉동</option>
                <option value="실온">실온</option>
              </Form.Select>
            </Form.Group>
            <Form.Group className="mb-3 form-group" controlId="">
              <Form.Label>등록일</Form.Label>
              <Form.Control type="date" name="" onChange={regDateHandler} />
            </Form.Group>
            <Form.Group className="mb-3 form-group" controlId="">
              <Form.Label>유통기한</Form.Label>
              <Form.Control type="date" name="" onChange={expDateHandler} />
            </Form.Group>
            <div className="modal-footer">
              <Button
                variant="primary"
                type="submit"
                onClick={hide}
                className="btn-create"
                disabled={!(isExpDate && isRegDate && isStorage)}
              >
                등록
              </Button>
            </div>
          </Form>
        </div>
      </div>
    </div>
  );
};

export default ItemAddForm;
