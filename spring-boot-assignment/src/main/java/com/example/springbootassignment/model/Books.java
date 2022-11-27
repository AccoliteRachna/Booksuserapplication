package com.example.springbootassignment.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "books")
public class Books  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long book_id;

    //@Column(name = "Bookname",nullable = false)
    private String bookname;

    //@Column(name = "author",nullable = false)
    private String author;

    //@Column(name = "category")
    private String category;

    //@Column(name = "price")
    private int  price;

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @CreatedDate
    private Date date;

    @CreationTimestamp
    private LocalDateTime timestamp;

    private int likes = 0;

    private String reviews = null;

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "book_id=" + book_id +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", timestamp=" + timestamp +
                ", likes=" + likes +
                ", reviews='" + reviews + '\'' +
                '}';
    }
}
