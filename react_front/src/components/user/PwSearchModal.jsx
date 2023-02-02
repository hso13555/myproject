import React, { useState } from "react";

import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import PwSearchForm from "./PwSearchForm";

const PwSearchModal = () => {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  return (
    <div>
      <Button variant="text" onClick={handleShow} className="btn-pw">
        비밀번호를 잊으셨나요?
      </Button>

      <Modal show={show} onHide={handleClose}>
        <Modal.Header>
          <Modal.Title>비밀번호 찾기</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <PwSearchForm />
        </Modal.Body>
        <Modal.Footer>
          <Button
            className="btn_close"
            variant="secondary"
            onClick={handleClose}
          >
            닫기
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};
export default PwSearchModal;
