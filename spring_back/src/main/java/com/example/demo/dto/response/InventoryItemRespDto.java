package com.example.demo.dto.response;

import com.example.demo.entity.Item;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class InventoryItemRespDto {

  private Long id;

  private Item item;

  private int count;

  private String storage;

  private Date regDate;

  private Date expDate;

  @Builder
  public InventoryItemRespDto(
    Long id,
    Item item,
    int count,
    String storage,
    Date regDate,
    Date expDate
  ) {
    this.id = id;
    this.item = item;
    this.count = count;
    this.storage = storage;
    this.regDate = regDate;
    this.expDate = expDate;
  }
}
