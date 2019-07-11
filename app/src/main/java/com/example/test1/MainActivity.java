package com.example.test1;

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

public class MainActivity extends AppCompatActivity {
    EditText username, phone, email, password, pwd_confirm;
    Button button;


    public static final String MyPREFERENCES = "User_details";
    public static final String Username = "user_name_key";
    public static final String Phone =  "phone_key";
    public static final String Email = "email_key";
    public static final String Pwd = "password_key";
    public static final String Pwd_confirm = "Pwd_conf_key";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        phone = (EditText)findViewById(R.id.tel);
        email = (EditText)findViewById(R.id.Email);
        password = (EditText)findViewById(R.id.password);
        pwd_confirm = (EditText)findViewById(R.id.pwd_confirm);

        button =(Button)findViewById(R.id.button);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(!sharedpreferences.getString(Username,"").equals("")){

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


                 if(pa.equals(pdc)){
                     SharedPreferences.Editor editor = sharedpreferences.edit();
                     editor.putString(Username, u);
                     editor.putString(Phone, ph);
                     editor.putString(Email, e);
                     editor.putString(Pwd, pa);
                     editor.putString(Pwd_confirm, pdc);
                     editor.apply();

                     Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();

                     Intent in = new Intent(MainActivity.this, Home.class);
                     startActivity(in);

                     finish();

                 }else{
                     Toast.makeText(MainActivity.this, "Password do not Match", Toast.LENGTH_LONG).show();
                 }
















            }


        });












    }
}
