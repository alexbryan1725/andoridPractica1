package com.job.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText email,pswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=(EditText)findViewById(R.id.txtEmail);
        pswd=(EditText)findViewById(R.id.txtPswd);
        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        email.setText(preferences.getString("email",""));
        pswd.setText(preferences.getString("pswd",""));
    }
    public void save(View view){


        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor obEdit = preferences.edit();
        obEdit.putString("email",email.getText().toString());
        obEdit.putString("pswd",pswd.getText().toString());
        obEdit.commit();


    }



}



