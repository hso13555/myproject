package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.demo.dto.response.FreezerRespDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Freezer extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "freezer_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "member_id")
  private Member member;

  @Column
  private String name;

  @OneToOne(mappedBy = "freezer", cascade = CascadeType.REMOVE) // 양방향
    private Inventory inventory;

  @Builder
  public Freezer(Long id, Member member, String name) {
    this.id = id;
    this.member = member;
    this.name = name;
  }


  public void changeName(String name) {
    this.name = name;
  }

  public void update(String name){
    this.name = name;
  }

  public FreezerRespDto toDto(){
    return FreezerRespDto.builder().id(id).name(name).build();
  }

}
