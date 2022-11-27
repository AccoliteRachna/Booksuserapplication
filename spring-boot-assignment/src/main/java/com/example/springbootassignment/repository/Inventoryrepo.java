package com.example.springbootassignment.repository;

import com.example.springbootassignment.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Inventoryrepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findBybooknameEquals(String bookname);

}
