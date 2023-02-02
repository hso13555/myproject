package com.example.demo.entity;

import com.example.demo.dto.request.ItemReqDto;
import com.example.demo.dto.response.ItemRespDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Item extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, columnDefinition = "LONGTEXT")
  private String img;

  @Column(nullable = false)
  private String per;

  @Column(nullable = false)
  private int kcal;

  @Column(nullable = false)
  private int fat;

  @Column(nullable = false)
  private int chol;

  @Column(nullable = false)
  private int sodium;

  @Column(nullable = false)
  private int potassium;

  @Column(nullable = false)
  private int carb;

  @Column(nullable = false)
  private int protein;

  public void change(ItemReqDto dto) {
    this.name = dto.getName();
    this.img = dto.getImg();
    this.per = dto.getPer();
    this.kcal = dto.getKcal();
    this.fat = dto.getFat();
    this.chol = dto.getChol();
    this.sodium = dto.getSodium();
    this.potassium = dto.getPotassium();
    this.carb = dto.getCarb();
    this.protein = dto.getProtein();
  }

  public ItemRespDto toDto() {
    return ItemRespDto.builder().id(id).name(name).img(img).build();
  }
}
