package com.example.springbootassignment.service;

import com.example.springbootassignment.model.Books;
import com.example.springbootassignment.model.Users;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service

public interface Services {
    void addbalance(Long id,int bal);
    Books createbook(Books newbook);
    Users createuser(Users newuser);
    Users updateuser(Users user);
    void suspenduser(Long userid);

    List<Users> getalluser();
    List<Books> getallbook();

    Optional<Books> getbookbyID(Long bookid);

    List<Books> getsortbydatee();

    List<Books> getsortbylikes();
}
