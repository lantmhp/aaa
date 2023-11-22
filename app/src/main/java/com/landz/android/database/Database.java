package com.landz.android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.graphics.Bitmap;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "music.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        db.execSQL("PRAGMA cursor_window = 5000000");
    }


    public Boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("USERNAME", username);
        cv.put("PASSWORD", password);

        long result = db.insert("user", null, cv);
        if(result != -1)
        {
            return false;
        }
        else {
            return true;
        }
    }



    public Boolean checkUserName(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE USERNAME = ?", new String[]{username});
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }
    public Boolean checkUserNamePass(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE USERNAME = ? AND PASSWORD = ?", new String[]{username, password});
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

}
