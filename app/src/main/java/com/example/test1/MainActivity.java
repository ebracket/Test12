package com.example.test1;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.test1.api.Config;
import com.example.test1.dbstore.DbManager;
import com.example.test1.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText username, phone, email, password, pwd_confirm;
    Button button;
    SharedPreferences sharedpreferences;
    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView test = findViewById(R.id.test) ;

        List<Student> students = new ArrayList<>() ;
        students.add(new Student("02","Emmanuel",56)) ;
        students.add(new Student("03","Felix",23)) ;
        students.add(new Student("04","Andrew",30)) ;


        StringBuilder stringBuilder = new StringBuilder() ;
        for(Student student:students){
            stringBuilder.append(student.getId()).append(" ").append(student.getName()).append(" ").append(student.getAge()).append("\n") ;
        }
        test.setText(stringBuilder.toString());



        /*StringBuilder s = new StringBuilder() ;
        for(int i=0;i<=50;i++){
            s.append(i).append("\n") ;
        }
        test.setText(s.toString());*/














        /*ImageView img = findViewById(R.id.image) ;
        Glide.with(this)
                .load("https://avatars3.githubusercontent.com/u/378279?s=400&v=4")
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(img) ;


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
















            }


        });*/












    }
}
