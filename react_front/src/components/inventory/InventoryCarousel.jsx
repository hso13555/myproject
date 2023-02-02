//template
import { Swiper, SwiperSlide } from "swiper/react";
import { Navigation } from "swiper";
// component
import InventoryItemGroup from "./InventoryItemGroup";

const InventoryCarousel = (props) => {
  console.log("InventoryCarousel" + props.index);
  return (
    <Swiper
      className="inventory-carousel"
      navigation={true}
      modules={[Navigation]}
    >
      <SwiperSlide>
        <h4 className="title">냉장보관</h4>
        <InventoryItemGroup
          setItemReload={props.setItemReload}
          index={props.index}
          itemCreateShow={props.itemCreateShow}
          itemList={props.itemList}
          storage="냉장"
        />
      </SwiperSlide>
      <SwiperSlide>
        <h4 className="title">냉동보관</h4>
        <InventoryItemGroup
          setItemReload={props.setItemReload}
          index={props.index}
          itemCreateShow={props.itemCreateShow}
          itemList={props.itemList}
          storage="냉동"
        />
      </SwiperSlide>
      <SwiperSlide>
        <h4 className="title">실온보관</h4>
        <InventoryItemGroup
          setItemReload={props.setItemReload}
          index={props.index}
          itemCreateShow={props.itemCreateShow}
          itemList={props.itemList}
          storage="실온"
        />
      </SwiperSlide>
    </Swiper>
  );
};

export default InventoryCarousel;
