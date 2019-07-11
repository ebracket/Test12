package com.example.test1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView v = findViewById(R.id.user_details);

        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        String uname = sharedPreferences.getString(MainActivity.Username, "");
        String phone = sharedPreferences.getString(MainActivity.Phone, "");
        String email = sharedPreferences.getString(MainActivity.Email, "");
        String pwd = sharedPreferences.getString(MainActivity.Pwd, "");
        v.setText(uname + "\n" + phone + "\n" + email + "\n" + pwd);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId() ;
        if(id==R.id.logout){

            SharedPreferences sp = getSharedPreferences(MainActivity.MyPREFERENCES,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.remove(MainActivity.Username);
            editor.remove(MainActivity.Phone);
            editor.remove(MainActivity.Email);
            editor.remove(MainActivity.Pwd);
            editor.remove(MainActivity.Pwd_confirm);
            editor.apply();

            finish();

        }
        return super.onOptionsItemSelected(item);



    }
}
