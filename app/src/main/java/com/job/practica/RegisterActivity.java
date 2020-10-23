package com.job.practica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.job.practica.Model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText   nombres, apellidos, telefono, correo, pswd,pswd2 ;
    DataBaseCon dataBaseCon;

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

        dataBaseCon = new DataBaseCon(this);

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

            User user = new User();
            user.setNames(nombresGet);
            user.setLastname(apellidosGet);
            user.setEmail(correoGet);
            user.setPswd(pswdGet);
            user.setTelephone(telefonoGet);

            if( dataBaseCon.insertUser(user) ){
                Toast.makeText(this,"Se agrego el usuario",Toast.LENGTH_SHORT).show();
               int log = dataBaseCon.finder(correoGet,pswdGet);
               if(log>0){
                   Bundle extras = new Bundle();
                   extras.putInt("idClie", log);
                   Intent intent = new Intent(this, InfoActivity.class);
                   intent.putExtras(extras);
                   startActivity(intent);
                   this.finish();
               }

            }else {
                Toast.makeText(this,"Se ha producido un error",Toast.LENGTH_SHORT).show();
            }


        }else {
            return;
        }





    }
}
