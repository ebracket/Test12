package com.example.test1.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    private int id ;

    @ColumnInfo(name = "user")
    private String username ;

    @ColumnInfo(name = "email")
    private String mail ;

    @ColumnInfo(name = "phone")
    private String mobile ;

    @ColumnInfo(name = "password")
    private String pwd ;

    public User(int id, String username, String mail, String mobile, String pwd) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.mobile = mobile;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPwd() {
        return pwd;
    }
}
