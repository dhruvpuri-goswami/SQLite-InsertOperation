package com.example.login.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.login.MainActivity;
import com.example.login.Model.Users;
import com.example.login.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {

    public MyDbHandler(Context context){
        super(context, Params.DB_NAME,null,Params.DB_VERSION);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            String create = "CREATE TABLE " + Params.TABLE_NAME +"("
                    + Params.KEY_ID + " INTEGER PRIMARY KEY, " +
                    Params.KEY_NAME + " TEXT, " +
                    Params.KEY_EMAIL + " TEXT, " +
                    Params.KEY_PASS + " TEXT " + ")";
        Log.d("db","Query being run is : " +create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void adduser(Users users){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_NAME,users.getName());
        values.put(Params.KEY_EMAIL,users.getEmail());
        values.put(Params.KEY_PASS,users.getPass());
        db.insert(Params.TABLE_NAME,null,values);
        db.close();
    }

    public List<Users> getAllUsers(){
        List<Users> usersList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + Params.TABLE_NAME;
        Cursor cursor=db.rawQuery(select,null);

        if(cursor.moveToFirst()){
            do {
                Users users = new Users();
                users.setId(Integer.parseInt(cursor.getString(0)));
                users.setName(cursor.getString(1));
                users.setEmail(cursor.getString(2));
                users.setPass(cursor.getString(3));
                usersList.add(users);
            }while (cursor.moveToNext());
        }
        return usersList;
    }
}
