package com.job.practica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText   nombres, apellidos, telefono, correo, pswd,pswd2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        nombres = (EditText) findViewById(R.id.TxtAddNombres);
        apellidos = (EditText) findViewById(R.id.TxtAddClieApellidos);
        telefono = (EditText) findViewById(R.id.TxtAddClieTelefono);
        correo = (EditText) findViewById(R.id.TxtAddClieCorreo);
        pswd = (EditText) findViewById(R.id.TxtAddCliePswd);
        pswd2 = (EditText) findViewById(R.id.TxtAddCliePswd2);


    }

    public void reg(View view){

        String  nombresGet = nombres.getText().toString(),
                apellidosGet = apellidos.getText().toString(),
                telefonoGet = telefono.getText().toString(),
                correoGet = correo.getText().toString(),
                pswdGet = pswd.getText().toString(),
                pswdGet2 = pswd2.getText().toString();

        boolean isOk = true;


        if (nombresGet.isEmpty()) {
            nombres.setError("Este campo es Obligatorio");
            isOk = false;
        }

        if (telefonoGet.isEmpty()) {
            telefono.setError("Este campo es Obligatorio");
            isOk = false;
        }
        if (correoGet.isEmpty()) {
            correo.setError("Este campo es Obligatorio");
            isOk = false;
        }
        if (apellidosGet.isEmpty()) {
            apellidos.setError("Este campo es Obligatorio");
            isOk = false;
        }
        if (pswdGet.isEmpty()) {
            pswd.setError("Este campo es Obligatorio");
            isOk = false;
        }


        if (pswdGet.isEmpty()) {
            pswd.setError("Este campo es Obligatorio");
            isOk = false;
        }

        if (pswdGet2.isEmpty()) {
            pswd2.setError("Este campo es Obligatorio");
            isOk = false;
        }

        if (pswdGet.equals(pswdGet2.toString()) && pswdGet2.equals(pswdGet.toString())) {

        }else {
            pswd.setError("No coincide las contraseñas");
            pswd2.setError("No coincide las contraseñas");
            isOk = false;
        }



        if(isOk) {

        }else {
            return;
        }





    }
}
