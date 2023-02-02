package com.example.demo.dto.response;

import java.util.List;

import com.example.demo.entity.Freezer;
import com.example.demo.entity.InventoryItem;

import lombok.Builder;
import lombok.Getter;

@Getter
public class InventoryRespDto {

    private Long id;
  
    private Freezer freezer;
  
    private List<InventoryItem> inventoryItem;

    @Builder
    public InventoryRespDto(Long id, Freezer freezer, List<InventoryItem> inventoryItem) {
        this.id = id;
        this.freezer = freezer;
        this.inventoryItem = inventoryItem;
    }
  
  
    
}
