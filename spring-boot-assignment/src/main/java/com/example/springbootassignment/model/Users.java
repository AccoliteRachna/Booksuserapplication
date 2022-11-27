package com.example.springbootassignment.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    //@Column(name="username",nullable = false)
    private String username;

    //@Column(name="emailid",unique = true)
    private String emaild;

    //@Column(name="phonenumber",unique = true)
    private long phonenumber;

    private boolean userstatus = true;

    public boolean isUserstatus() {
        return userstatus;
    }

    public void setUserstatus(boolean userstatus) {
        this.userstatus = userstatus;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmaild() {
        return emaild;
    }

    public void setEmaild(String emaild) {
        this.emaild = emaild;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override

    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", emailid='" + emaild + '\'' +
                ", phonenumber=" + phonenumber +
                '}';
    }
}
