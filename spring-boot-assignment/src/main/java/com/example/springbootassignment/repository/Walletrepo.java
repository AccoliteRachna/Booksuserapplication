package com.example.springbootassignment.repository;

import com.example.springbootassignment.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Walletrepo extends JpaRepository<Wallet,Long> {

}
