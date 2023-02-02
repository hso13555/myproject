package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TimeMenu;

public interface AiFdRepository extends JpaRepository<TimeMenu, Long> {

    //아침
    List<TimeMenu> findByTimefd_morning(String timefd_morning);

    //점심
    List<TimeMenu> findByTimefd_lunch(String timefd_lunch);

    //저녁
    List<TimeMenu> findByTimefd_dinner(String timefd_dinner);
}
