package com.example.springbootassignment.service;

import com.example.springbootassignment.exception.Bsexception;
import com.example.springbootassignment.model.Books;
import com.example.springbootassignment.model.Inventory;
import com.example.springbootassignment.model.Users;
import com.example.springbootassignment.model.Wallet;
import com.example.springbootassignment.repository.Booksrepo;
import com.example.springbootassignment.repository.Inventoryrepo;
import com.example.springbootassignment.repository.Usersrepo;
import com.example.springbootassignment.repository.Walletrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ServiceIMPL implements Services {
    @Autowired
    private Booksrepo booksrepository;

    @Autowired
    private Usersrepo usersrepository;

    @Autowired
    private Walletrepo walletrepository;

    @Autowired
    private Inventoryrepo inventoryrepository;

    @Override
    public void addbalance(Long userid,int balance) {
        Optional<Users> usero = usersrepository.findById(userid);
        Optional<Wallet> walletUser = walletrepository.findById(userid);
        if (walletUser.isPresent()) {
            if (balance % 500 == 0) {

                Wallet user = walletUser.get();

                if (walletUser.isPresent()) {
                    user.setBalance(user.getBalance() + balance);
                }
                else{
                        throw new Bsexception("User didn't found with ID: " + userid);
                    }

                } else {
                    throw new Bsexception("Amount enter should be in multiple of 500");
                }
            } else {
                throw new Bsexception("Wallet didn't found with ID: " + userid);
            }
        }


    @Override
    public Books createbook(Books newbook) {
        Books book = booksrepository.save(newbook);
        String bookn = book.getBookname();
        Optional<Inventory> invobj = this.inventoryrepository.findBybooknameEquals(bookn);
        if(invobj.isPresent())
        {
            Inventory inv = invobj.get();
            inv.setTotalcount(inv.getTotalcount()+1);
            inv.setAvailable(inv.getAvailable()+1);
            this.inventoryrepository.save(inv);
        }
        else {
            this.inventoryrepository.save(new Inventory(bookn));
        }
        return book;
    }

    @Override
    public Users createuser(Users newuser) {
        Users newUser = usersrepository.save(newuser);
        Wallet wallet = new Wallet(newUser.getUserid(),0);
        walletrepository.save(wallet);
        return newUser;
    }

    @Override
    public Users updateuser(Users user) {
        Optional<Users> userobj = this.usersrepository.findById(user.getUserid());
        Users userUpdate = userobj.get();
        userUpdate.setUserid(user.getUserid());
        userUpdate.setEmaild(user.getEmaild());
        userUpdate.setPhonenumber(user.getPhonenumber());
        userUpdate.setUsername(user.getUsername());
        return this.usersrepository.save(userUpdate);
    }

    @Override
    public void suspenduser(Long userid) {
        Optional<Users> userobj = this.usersrepository.findById(userid);
        if (userobj.isPresent()) {
            userobj.get().setUserstatus(false);;
        }
        throw new Bsexception("User didn't found with ID: " + userid);
    }

    @Override
    public List<Users> getalluser() {
        return this.usersrepository.findAll();
    }

    @Override
    public List<Books> getallbook() {
        return this.booksrepository.findAll();
    }

    @Override
    public Optional<Books> getbookbyID(Long bookid) {
        Optional<Books> bookobj = this.booksrepository.findById(bookid);
        if (bookobj.isPresent()) {
            return bookobj;
        }
        else{
            throw new Bsexception("BOok didn't found with ID: " + bookid);
        }
    }

    @Override
    public List<Books> getsortbydatee() {
        List<Books> bookitems = booksrepository.findAll();
        bookitems.sort(Comparator.comparing(Books::getTimestamp));
        return bookitems;
    }

    @Override
    public List<Books> getsortbylikes() {
        List<Books> bookitems = booksrepository.findAll();
        bookitems.sort(Comparator.comparing(Books::getLikes));
        return bookitems;
    }
}