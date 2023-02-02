import Modal from "react-bootstrap/Modal";
import ItemSearchAddComponent from "../../Item/ItemSearchAddComponent";

const InventoryItemAddModal = (props) => {
  return (
    <Modal
      show={props.itemCreateShow}
      size={"lg"}
      onHide={props.ItemModalClose}
    >
      <Modal.Header closeButton>
        <Modal.Title>재료 추가</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <ItemSearchAddComponent
          onFreezerItemAdd={props.onFreezerItemAdd}
          index={props.index}
          hide={props.ItemModalClose}
        />
      </Modal.Body>
    </Modal>
  );
};

export default InventoryItemAddModal;
