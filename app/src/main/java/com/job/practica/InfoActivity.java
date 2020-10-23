package com.job.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.job.practica.Model.User;

public class InfoActivity extends AppCompatActivity {

    TextView  nombres, apellidos, telefono, correo,id ;
    User user;
    DataBaseCon dataBaseCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        nombres = (TextView) findViewById(R.id.lblUserName);
        apellidos = (TextView) findViewById(R.id.lblUserLastName);
        telefono = (TextView) findViewById(R.id.lblUserTel);
        correo = (TextView) findViewById(R.id.lblUserEmail);
        id = (TextView) findViewById(R.id.lblUserId);

        dataBaseCon = new DataBaseCon(this);
        Bundle extras = getIntent().getExtras();
        user = dataBaseCon.findUser( extras.getInt("idClie"));

        nombres.setText(user.getNames().toString());
        apellidos.setText(user.getLastname().toString());
        telefono.setText(user.getTelephone().toString());
        id.setText(""+user.getId());


    }

    public  void  exit(View view){
        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor obEdit = preferences.edit();
        obEdit.clear();
        obEdit.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();

    }
}
