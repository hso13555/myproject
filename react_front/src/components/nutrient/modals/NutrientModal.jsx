import Modal from "react-bootstrap/Modal";
import RecipesGroup from "../../recipe/RecipesGroup";
import NutrientTable from "../NutrientTable";
import Button from "react-bootstrap/Button";
import { instance } from "../../api/Api";

const NutrientModal = ({
  show,
  onHide,
  itemInfo,
  setItemInfo,
  setItemReload
}) => {
  console.log("로그" + JSON.stringify(itemInfo));
  const InventoryItemId = itemInfo.id;
  console.log(setItemReload)

  const onDeleteInventoryItem = async () => {
    try {
      const response = await instance.delete(
        `/api/inventory/delete/${InventoryItemId}`
      );
      console.log("응답" + JSON.stringify(response));
      setItemReload(true);
    } catch (error) {
      console.log(error);
    }
  };

  const deleteHandler = () => {
    onDeleteInventoryItem();
  };

  return (
    <>
      <Modal
        size="lg"
        show={show}
        onHide={onHide}
        className="ingr-detail-modal"
      >
        <Modal.Header closeButton>
          <img
            className="ingr-img"
            src={itemInfo.item.img}
            alt={itemInfo.item.name}
          />

          <div className="detail-ingr">
            <h5 className="title">{itemInfo.item.name}</h5>
            {/* <span className="count-text">갯수 : {itemInfo.count}</span> */}
          </div>
          <Button
            onClick={() => {
              deleteHandler();
              onHide();
            }}
          >
            삭제
          </Button>
        </Modal.Header>

        <Modal.Body>
          <NutrientTable itemInfo={itemInfo.item} />
          <h5>메뉴 추천</h5>
          <div className="content-body">
            <RecipesGroup itemName={itemInfo.item.name} />
          </div>
        </Modal.Body>
        <Modal.Footer></Modal.Footer>
      </Modal>
    </>
  );
};

export default NutrientModal;
