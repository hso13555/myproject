import React from "react";
// template
import { Autoplay, Navigation, Pagination } from "swiper";
import { Swiper, SwiperSlide } from "swiper/react";
import RecipesGroup from "./RecipesGroup";

const RecipesCarousel = () => {
  return (
    <Swiper
      slidesPerView={1}
      spaceBetween={30}
      pagination={{
        clickable: true,
      }}
      centeredSlides={true}
      autoplay={{
        delay: 2500,
        disableOnInteraction: false,
      }}
      loop={true}
      navigation={true}
      modules={[Pagination, Navigation, Autoplay]}
      className="item-swiper"
    >
      <SwiperSlide>
        <RecipesGroup />
      </SwiperSlide>

      <SwiperSlide>
        <RecipesGroup />
      </SwiperSlide>
    </Swiper>
  );
};

export default RecipesCarousel;
