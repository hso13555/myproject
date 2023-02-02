import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import RecipesContentList from "../RecipesContentList";

const RecipeContentModal = (props) => {
  return (
    <Modal
      size="lg"
      show={props.recipeShow}
      onHide={props.handleClose}
      className="recipy-modal"
    >
      <Modal.Header closeButton></Modal.Header>
      <Modal.Body>
        <RecipesContentList recipeName={props.recipeName} />
      </Modal.Body>
      <Modal.Footer>
        <Button variant="primary" onClick={props.handleClose}>
          만들기2222
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default RecipeContentModal;
