package com.example.springbootassignment.controller;

import com.example.springbootassignment.model.Books;
import com.example.springbootassignment.model.Inventory;
import com.example.springbootassignment.model.Users;

import com.example.springbootassignment.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Booksmanagementcontroller {

    @Autowired
    private Services services;
    @PostMapping("/Users")
    private ResponseEntity<Users> saveuser(@RequestBody Users newuser) {
        return ResponseEntity.ok().body(this.services.createuser(newuser));
    }

    @PostMapping("/book")
    private ResponseEntity<Books> addbook(@RequestBody Books newbook){
        return ResponseEntity.ok().body(this.services.createbook(newbook));
    }

    @GetMapping("/Userslist")
    private List<Users> getallusers(){
        return this.services.getalluser();
    }

    @GetMapping("/Bookslist")
    private List<Books> getallbooks(){
        return this.services.getallbook();
    }

    @GetMapping("/Books/{bookid}")
    private Optional<Books> getbookbyid(@PathVariable Long bookid){
        return this.services.getbookbyID(bookid);
    }

    @GetMapping("/sortedbydate")
        private List<Books> getsortedbydate(){
            return this.services.getsortbydatee();
        }

    @GetMapping("/sortedbylikes")
    private List<Books> getsortedbylike(){
        return this.services.getsortbylikes();
    }

    @PutMapping("/Users/{userid}")
    private ResponseEntity<Users> updateuser(@PathVariable Long userid, @RequestBody Users user) {
        user.setUserid(userid);
        return ResponseEntity.ok().body(this.services.updateuser(user));
    }


    @PutMapping("/suspenduser/{userid}")
    private HttpStatus suspenduser(@PathVariable Long userid) {
        this.services.suspenduser(userid);
        return HttpStatus.OK;
    }

    @PutMapping("/Wallet/{userid}/{balance}")
    private HttpStatus updatebalance(@PathVariable Long userid,@PathVariable int balance) {
        this.services.addbalance(userid,balance);
        return HttpStatus.OK;
    }

}
