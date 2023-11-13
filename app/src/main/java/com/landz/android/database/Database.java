package com.landz.android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class Database extends SQLiteOpenHelper {

    Context context;
    private static final String DBNAME = "music.db";
    private static final String createTableQuery = "Create table LoginUser(userName TEXT" +
            ",email TEXT" +
            ",phone TEXT" +
            ",password TEXT" +
            ",image BLOB)";
    private static final int VER = 1;

    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageInBytes;

    public Database(Context context) {
        super(context, DBNAME, null, VER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableQuery);
        Toast.makeText(context.getApplicationContext(), "table created successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void storeData(ModelClass modelClass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Bitmap imageToStoreBitmap = modelClass.getProfileImage();

        byteArrayOutputStream = new ByteArrayOutputStream();
        imageToStoreBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        imageInBytes = byteArrayOutputStream.toByteArray();
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", modelClass.getUserName());
        contentValues.put("email", modelClass.getEmail());
        contentValues.put("phone", modelClass.getPhone());
        contentValues.put("password", modelClass.getPassword());
        contentValues.put("image", imageInBytes);

        long checkIfQueryRun = db.insert("LoginUser", null, contentValues);
        
    }

}
