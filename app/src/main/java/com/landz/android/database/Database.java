package com.landz.android.database;
import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import com.landz.android.Model.Song;
import com.landz.android.Model.album;


import java.util.ArrayList;


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


    public ArrayList<album> getAllAlbum() {

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT album.*, artist.artist_Name FROM album INNER JOIN artist ON album.artist_Id = artist.artist_Id";
        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        if (cursor == null) {
            return null;
        } else {
            ArrayList<album> albums = new ArrayList<>();
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String albumName = cursor.getString(2);
                String release = cursor.getString(3);
                byte[] imageContent = cursor.getBlob(4);
                String artistName = cursor.getString(5);

                album s = new album( albumName, release,artistName);
                s.setThumb(imageContent);
                s.setAlbum_id(id);
                albums.add(s);
            }
            return albums;
        }
    }
    public ArrayList<Song> getAllSong(){

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT song.*, artist.artist_Name FROM song INNER JOIN artist ON song.artist_Id = artist.artist_Id";
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        if (cursor == null){
            return null;
        }
        else {
            ArrayList<Song> songs = new ArrayList<>();
            while (cursor.moveToNext()){
                int Song_id = cursor.getInt(0);
                String title = cursor.getString(3);
                String duration = cursor.getString(4);
                byte[] imageContent = cursor.getBlob(5);
                String path = cursor.getString(6);
                String art = cursor.getString(7);
                Song s = new Song(title,art,duration,path);
                s.setSong_Image(imageContent);
                s.setSong_Id(Song_id);
                songs.add(s);
            }
            return songs;
        }
    }

    public ArrayList<Song> getSongsForAlbum(int albumId) {
        ArrayList<Song> songList = new ArrayList<>();
        String selectQuery = "SELECT song.*, artist.artist_Name FROM song INNER JOIN artist ON song.artist_Id = artist.artist_Id " + " WHERE " + "album_Id" + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(albumId)});
        try {
            if (cursor.moveToFirst()) {
                do {

                    int Song_id = cursor.getInt(0);
                    String title = cursor.getString(3);
                    String duration = cursor.getString(4);
                    byte[] imageContent = cursor.getBlob(5);
                    String path = cursor.getString(6);
                    String art = cursor.getString(7);
                    Song s = new Song(title,art,duration,path);
                    s.setSong_Image(imageContent);
                    s.setSong_Id(Song_id);
                    songList.add(s);
                } while (cursor.moveToNext());
            }
        }
        finally {
            cursor.close();
            db.close();
        }

        return songList;
    }

    public Song getsongbyId(int songid){
        String selectQuery = "SELECT * FROM song "+" WHERE " + "song_Id" + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(songid)});
        Song s = new Song();
        try {
            if (cursor.moveToFirst()) {
                do {

                    int Song_id = cursor.getInt(0);
                    String title = cursor.getString(3);
                    byte[] imageContent = cursor.getBlob(5);
                    String path = cursor.getString(6);
                    s.setSong_Title(title);
                    s.setSong_Image(imageContent);
                    s.setPath(path);
                    s.setSong_Id(Song_id);

                } while (cursor.moveToNext());
            }

        }
        finally {
            cursor.close();
            db.close();
        }
        return s;

    }
//    public ArrayList<Song> getAllSongbyID(int songid) {
//        ArrayList<Song> songList = new ArrayList<>();
//        String selectQuery = "SELECT song.*, artist.artist_Name FROM song INNER JOIN artist ON song.artist_Id = artist.artist_Id " + " WHERE " + "song_Id" + " = ?";
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(songid)});
//        try {
//            if (cursor.moveToFirst()) {
//                do {
//
//                    int Song_id = cursor.getInt(0);
//                    String title = cursor.getString(3);
//                    String duration = cursor.getString(4);
//                    byte[] imageContent = cursor.getBlob(5);
//                    String path = cursor.getString(6);
//                    String art = cursor.getString(7);
//                    Song s = new Song(title,art,duration,path);
//                    s.setSong_Image(imageContent);
//                    s.setSong_Id(Song_id);
//                    songList.add(s);
//                } while (cursor.moveToNext());
//            }
//        }
//        finally {
//            cursor.close();
//            db.close();
//        }
//
//        return songList;
//    }

}
