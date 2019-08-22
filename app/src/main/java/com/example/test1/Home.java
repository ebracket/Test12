package com.example.test1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.test1.api.Config;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView v = findViewById(R.id.user_details);

        SharedPreferences sharedPreferences = getSharedPreferences(Config.MyPREFERENCES, Context.MODE_PRIVATE);
        String uname = sharedPreferences.getString(Config.Username, "");
        String phone = sharedPreferences.getString(Config.Phone, "");
        String email = sharedPreferences.getString(Config.Email, "");
        String pwd = sharedPreferences.getString(Config.Pwd, "");
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

            SharedPreferences sp = getSharedPreferences(Config.MyPREFERENCES,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.remove(Config.Username);
            editor.remove(Config.Phone);
            editor.remove(Config.Email);
            editor.remove(Config.Pwd);
            editor.remove(Config.Pwd_confirm);
            editor.apply();

            Intent in = new Intent(Home.this, MainActivity.class);
            startActivity(in);
            finish();
        }
        return super.onOptionsItemSelected(item);



    }
}
