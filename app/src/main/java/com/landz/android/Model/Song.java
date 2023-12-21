package com.landz.android.Model;

import java.io.File;
import java.io.Serializable;

public class Song implements Serializable {
    int Song_Id;
    String Song_Title;
    String Song_Artsit;
    String Duration;
    byte[] Song_Image;
    String path;
    public Song() {

    }

    public Song(String song_Title, String song_Artsit, String duration, String path) {
        Song_Title = song_Title;
        Song_Artsit = song_Artsit;
        Duration = duration;
        this.path = path;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSong_Id() {
        return Song_Id;
    }

    public String getSong_Artsit() {
        return Song_Artsit;
    }

    public void setSong_Artsit(String song_Artsit) {
        Song_Artsit = song_Artsit;
    }

    public void setSong_Id(int song_Id) {
        Song_Id = song_Id;
    }

    public String getSong_Title() {
        return Song_Title;
    }

    public void setSong_Title(String song_Title) {
        Song_Title = song_Title;
    }


    public byte[] getSong_Image() {
        return Song_Image;
    }

    public void setSong_Image(byte[] song_Image) {
        Song_Image = song_Image;
    }
}
