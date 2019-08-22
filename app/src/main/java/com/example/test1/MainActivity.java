package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.test1.api.Config;
import com.example.test1.dbstore.DbManager;

public class MainActivity extends AppCompatActivity {
    EditText username, phone, email, password, pwd_confirm;
    Button button;

    SharedPreferences sharedpreferences;

    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DbManager(this);

        username = (EditText)findViewById(R.id.username);
        phone = (EditText)findViewById(R.id.tel);
        email = (EditText)findViewById(R.id.Email);
        password = (EditText)findViewById(R.id.password);
        pwd_confirm = (EditText)findViewById(R.id.pwd_confirm);



        button =(Button)findViewById(R.id.button);

        sharedpreferences = getSharedPreferences(Config.MyPREFERENCES, Context.MODE_PRIVATE);
        if(!sharedpreferences.getString(Config.Username,"").equals("")){

            Intent in = new Intent(MainActivity.this, Home.class);
            startActivity(in);
            finish();

        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String u = username.getText().toString();
                String ph = phone.getText().toString();
                String e = email.getText().toString();
                String pa = password.getText().toString();
                String pdc = pwd_confirm.getText().toString();





                 if(u.trim().equals("") || ph.trim().equals("") || e.trim().equals("") || pa.trim().equals("") || pdc.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Fill out all Forms", Toast.LENGTH_LONG).show();

                    return;
                 }
                 if(!Patterns.EMAIL_ADDRESS.matcher(e).matches()){
                     email.setError("Invalid email");

                     return;
                 }

                ContentValues contentValues = new ContentValues();
                 contentValues.put("Username",u);
                 contentValues.put("Phone",ph);
                 contentValues.put("Email",e);
                 long status=dbManager.insertData(dbManager.getWritableDatabase(),contentValues);

                 if(status>-1){
                     Toast.makeText(MainActivity.this,"Data Upload Successful", Toast.LENGTH_LONG).show();
                 }else{
                     Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
                 }


                 /*if(pa.equals(pdc)){
                     SharedPreferences.Editor editor = sharedpreferences.edit();
                     editor.putString(Config.Username, u);
                     editor.putString(Config.Phone, ph);
                     editor.putString(Config.Email, e);
                     editor.putString(Config.Pwd, pa);
                     editor.putString(Config.Pwd_confirm, pdc);
                     editor.apply();

                     Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();

                     Intent in = new Intent(MainActivity.this, Home.class);
                     startActivity(in);

                     finish();

                 }else{
                     Toast.makeText(MainActivity.this, "Password do not Match", Toast.LENGTH_LONG).show();
                 }
*/















            }


        });












    }
}
