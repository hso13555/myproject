import React from "react";
// template
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Modal from "react-bootstrap/Modal";

const FreezerCreateModal = (props) => {
  return (
    <div>
      <Modal show={props.onShow} onHide={props.onHide} centered>
        <Modal.Header closeButton>
          <Modal.Title>냉장고 생성</Modal.Title>
        </Modal.Header>
        <Form onSubmit={props.onSubmit}>
          <Modal.Body>
            <Form.Control
              type="text"
              placeholder={props.placeholder}
              onChange={props.onChange}
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

export default FreezerCreateModal;
