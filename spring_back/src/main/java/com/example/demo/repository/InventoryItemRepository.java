package com.example.demo.repository;

import com.example.demo.entity.InventoryItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository
  extends JpaRepository<InventoryItem, Long> {
  InventoryItem findByInventoryIdAndItemId(Long inventoryId, Long itemId);
  List<InventoryItem> findByInventoryId(Long inventoryId);

  List<InventoryItem> findByInventory_Freezer_Member_UserEmail(
    String userEmail
  );
}
