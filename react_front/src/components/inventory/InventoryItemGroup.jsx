import InventoryItem from "./InventoryItem";

const InventoryItemGroup = (props) => {
  // 냉장고 속 재료 목록 그룹 (한 줄)
  return (
    <div className="inventory-list">
      <ul className="ingr-group">
        <InventoryItem
          setItemReload={props.setItemReload}
          index={props.index}
          itemCreateShow={props.itemCreateShow}
          itemList={props.itemList}
          storage={props.storage}
        />
      </ul>
    </div>
  );
};

export default InventoryItemGroup;
