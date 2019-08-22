package com.example.test1.dbstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper {
    public static final String UserDetails = "UserDetails";
    public DbManager(Context context){
      super(context,"MyDb",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ UserDetails +" (\n" +
                "\t\"_id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "\t\"Username\"\tVARCHAR(50) NOT NULL,\n" +
                "\t\"Phone\"\tVARCHAR(15) NOT NULL,\n" +
                "\t\"Email\"\tVARCHAR(100) NOT NULL\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insertData(SQLiteDatabase sqLiteDatabase,ContentValues contentValues){
        return sqLiteDatabase.insert(UserDetails,null,contentValues);

    }
}
