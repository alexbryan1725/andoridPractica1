package com.job.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email, pswd;
    Switch aSwitch;
    DataBaseCon dataBaseCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseCon = new DataBaseCon(this);

        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        String u = preferences.getString("email", "");
        String p = preferences.getString("pswd", "");

        int idUser = dataBaseCon.finder( u, p );
        if (idUser > 0) {

            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            Bundle extras = new Bundle();
            extras.putInt("idClie", idUser);
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
            this.finish();

        } else {
            SharedPreferences.Editor obEdit = preferences.edit();
            obEdit.clear();
            obEdit.commit();
        }



        email = (EditText) findViewById(R.id.txtEmail);
        pswd = (EditText) findViewById(R.id.txtPswd);
        aSwitch = (Switch) findViewById(R.id.switchLogin);


        email.setText(preferences.getString("email", ""));
        pswd.setText(preferences.getString("pswd", ""));

    }


    public void login(View view) {
        int id = dataBaseCon.finder(email.getText().toString(), pswd.getText().toString());
        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor obEdit = preferences.edit();
        if (id > 0) {


            if (aSwitch.isChecked()) {


                obEdit.putString("email", email.getText().toString());
                obEdit.putString("pswd", pswd.getText().toString());

                obEdit.commit();

            }

            Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();
            Bundle extras = new Bundle();
            extras.putInt("idClie", id);
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
            this.finish();
        } else {
            Toast.makeText(this, "No existe registro..!", Toast.LENGTH_SHORT).show();
            obEdit.clear();
            obEdit.commit();
        }
    }


    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }


}



