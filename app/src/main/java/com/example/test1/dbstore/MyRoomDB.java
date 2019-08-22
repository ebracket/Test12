package com.example.test1.dbstore;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.test1.entities.MyDao;
import com.example.test1.entities.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
abstract public class MyRoomDB extends RoomDatabase {
    public abstract MyDao myDao() ;

    public MyRoomDB getInstance(){
        return this ;
    }
}
