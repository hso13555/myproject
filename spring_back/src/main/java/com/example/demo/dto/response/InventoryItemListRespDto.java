package com.example.demo.dto.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class InventoryItemListRespDto {

  List<InventoryItemRespDto> inventoryItem;

  @Builder
  public InventoryItemListRespDto(
    List<InventoryItemRespDto> inventoryItemList
  ) {
    this.inventoryItem = inventoryItemList;
  }
}
