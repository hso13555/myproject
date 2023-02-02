package com.example.demo.entity;

import com.example.demo.dto.response.InventoryRespDto;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Inventory extends BaseEntity {

  @Id
  @Column(name = "inventory_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @JoinColumn(name = "freezer_id")
  private Freezer freezer;

  @OneToMany(
    mappedBy = "inventory",
    fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE
  )
  private List<InventoryItem> inventoryItem;

  public InventoryRespDto toDto() {
    return InventoryRespDto
      .builder()
      .freezer(freezer)
      .inventoryItem(inventoryItem)
      .id(id)
      .build();
  }
}
