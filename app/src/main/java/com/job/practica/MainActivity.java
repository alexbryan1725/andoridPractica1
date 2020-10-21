package com.job.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.txtName);
        tel=(EditText)findViewById(R.id.txtTel);
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        name.setText(preferences.getString("name",""));
        tel.setText(preferences.getString("telephone",""));
    }
    public void save(View view){
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor obEdit = preferences.edit();
        obEdit.putString("name",name.getText().toString());
        obEdit.putString("telephone",tel.getText().toString());
        obEdit.commit();

    }



}



