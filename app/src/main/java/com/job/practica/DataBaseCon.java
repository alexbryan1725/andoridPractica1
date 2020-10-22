package com.job.practica;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.job.practica.Model.User;

import java.util.ArrayList;

public class DataBaseCon {
    Context context;
    User user;
    ArrayList<User> lista;
    SQLiteDatabase sqLiteDatabase;
    String dbName="practica";


    public  DataBaseCon(Context context){

        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase(dbName,context.MODE_PRIVATE,null);
        sqLiteDatabase.execSQL("Create table if not exists usuario(idUser primary key autoincrement, nameUser text,lastnameUser text,emailUser text,pswdUser text, telephoneUser text)");
        user = new User();

    }

    public  boolean insertUser(User user ){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nameUser",user.getNames());
        contentValues.put("lastnameUser",user.getLastname());
        contentValues.put("emailUser",user.getEmail());
        contentValues.put("pswdUser",user.getPswd());
        contentValues.put("telephoneUser",user.getTelephone());

        return  (sqLiteDatabase.insert("usuario",null,contentValues)>0);

    }


}
