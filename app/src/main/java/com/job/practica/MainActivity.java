package com.job.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO agregar librería ButterKnife y usar par agregar referencia de componentes del Layout.
    // Se trabaja con butterknife para el mejor manejo de los ids de los views.
    // ej: @BindView(R.id.name)       View name;

    EditText name,tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Mejorar ordenamiento y tabulación de la maquetación del layout (activity_main)
        // También usar ConstraintLayout para maquetar la vista.
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.txtName);
        tel=(EditText)findViewById(R.id.txtTel);

        // TODO mover inicialización de variables a un método privado. ej: init()
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        name.setText(preferences.getString("name",""));
        tel.setText(preferences.getString("telephone",""));
    }
    // Entre cada método debe de haber un espacio. El orden es importante cuando programamos entre
    // varias personas una misma app.
    public void save(View view) { // Siempre debe haber un espacio entre el método y las llaves.
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor obEdit = preferences.edit();

        // Cuando usas una constante en diferentes scopes inicializala como global.
        // ej: private String name = "name"
        obEdit.putString("name",name.getText().toString()); // Después de una coma siempre hay un espacio.
        obEdit.putString("telephone",tel.getText().toString());
        obEdit.commit(); //Siempre lee los warnings que te brinda el IDE

    }



}



