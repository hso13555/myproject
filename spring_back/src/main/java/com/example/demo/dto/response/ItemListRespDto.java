package com.example.demo.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemListRespDto {

  List<ItemRespDto> item;

  @Builder
  public ItemListRespDto(List<ItemRespDto> itemList) {
    this.item = itemList;
  }
}
