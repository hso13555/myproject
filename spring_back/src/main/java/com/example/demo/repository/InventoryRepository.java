package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
  Inventory findByFreezerId(Long freezerid);
  // List<Inventory> findAllByFreezer(String ??);
}
