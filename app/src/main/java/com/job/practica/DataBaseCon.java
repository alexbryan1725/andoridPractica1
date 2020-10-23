package com.job.practica;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        sqLiteDatabase.execSQL("Create table if not exists usuario(idUser integer primary key autoincrement, nameUser text,lastnameUser text,emailUser text,pswdUser text, telephoneUser text)");
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


    public  int finder(String email,String pswd){

         int  id = 0;


        Cursor cursor=sqLiteDatabase.rawQuery("select * from usuario",null);

        if(cursor!=null && cursor.moveToFirst()){
            do{
                if(cursor.getString(3).equals(email) && cursor.getString(4).equals(pswd)){
                    id = cursor.getInt(0);
                }
            }while (cursor.moveToNext());
        }

        return id;
    }


    private ArrayList<User> listUser(){
        ArrayList<User> list= new ArrayList<User>();
        list.clear();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from usuario",null);
        if(cursor!=null && cursor.moveToFirst()){
            do{
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setNames(cursor.getString(1));
                user.setLastname(cursor.getString(2));
                user.setEmail(cursor.getString(3));
                user.setPswd(cursor.getString(4));
                user.setTelephone(cursor.getString(5));
                list.add(user);

            }while (cursor.moveToNext());

        }
    return list;
    }

    public  User findUser(int id){
        lista = listUser();

        for (User user:lista){
            if(user.getId() == id){
                return user;
            }
        }

      return null;
    }


}
