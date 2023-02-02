package com.example.demo.repository;

import com.example.demo.entity.Freezer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreezerRepository extends JpaRepository<Freezer, Long> {
  List<Freezer> findByMemberId(Long memberId);
}
