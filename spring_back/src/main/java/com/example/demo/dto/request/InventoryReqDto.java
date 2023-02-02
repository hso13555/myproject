package com.example.demo.dto.request;

import java.util.List;

import com.example.demo.entity.Freezer;
import com.example.demo.entity.Inventory;
import com.example.demo.entity.InventoryItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryReqDto {

    private Long id;

    private Freezer freezer;

    private List<InventoryItem> inventoryItem;

    public Inventory toEntity(){
        return Inventory.builder().id(id).freezer(freezer).inventoryItem(inventoryItem).build();
    }
    
}
