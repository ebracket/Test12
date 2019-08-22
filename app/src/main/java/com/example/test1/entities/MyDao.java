package com.example.test1.entities;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MyDao {
    @Query("SELECT * FROM users")
    public List<User> getAllUsers() ;

    @Insert
    public long insertUser(User user) ;
}
