import React from "react";
// template
import { useCallback, useState } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Modal from "react-bootstrap/Modal";
import { useNavigate } from "react-router-dom";
import { instance } from "../../api/Api";

const FreezerChangeModal = (props) => {
  const navigate = useNavigate();
  const [freezerName, SetFreezerName] = useState("");

  const changeFreezerNameHandler = useCallback((e) => {
    SetFreezerName(e.target.value);
  }, []);

  const changeSubmitHandler = (e) => {
    e.preventDefault();
    props.onHide();
    onChangeName(freezerName);
  };

  //수정처리
  const onChangeName = async (freezerName) => {
    console.log("수정처리 작동!");
    const data = {
      name: freezerName,
    };
    const index = props.index;
    try {
      await instance.put(`/api/freezer/${index}`, JSON.stringify(data));
      props.onChange();
      navigate("/freezer");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <Modal show={props.onShow} onHide={props.onHide} centered>
        <Modal.Header closeButton>
          <Modal.Title>냉장고 이름 변경</Modal.Title>
        </Modal.Header>
        <Form onSubmit={changeSubmitHandler}>
          <Modal.Body>
            <Form.Control
              type="text"
              placeholder={props.placeholder}
              onChange={changeFreezerNameHandler}
              required
            />
          </Modal.Body>
          <Modal.Footer>
            <Button type="submit" variant="primary">
              {props.buttonName}
            </Button>
          </Modal.Footer>
        </Form>
      </Modal>
    </div>
  );
};

export default FreezerChangeModal;
