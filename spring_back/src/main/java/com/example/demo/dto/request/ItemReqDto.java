package com.example.demo.dto.request;

import com.example.demo.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.StringBuilderFormattable;

@Getter
@Setter
public class ItemReqDto {

  private Long id;

  private String name;

  private String img;

  private String per;

  private int kcal;

  private int fat;

  private int chol;

  private int sodium;

  private int potassium;

  private int carb;

  private int protein;

  public Item toEntity() {
    return Item
      .builder()
      .id(id)
      .name(name)
      .img(img)
      .per(per)
      .kcal(kcal)
      .fat(fat)
      .chol(chol)
      .sodium(sodium)
      .potassium(potassium)
      .carb(carb)
      .protein(protein)
      .build();
  }
}
