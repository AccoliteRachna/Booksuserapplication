package com.example.springbootassignment.repository;

import com.example.springbootassignment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usersrepo extends JpaRepository<Users, Long> {

}

