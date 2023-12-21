package com.landz.android.Model;

public class Artist {
    int artist_id;
    String artist_name;
    byte[] artist_image;

    public Artist(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public byte[] getArtist_image() {
        return artist_image;
    }

    public void setArtist_image(byte[] artist_image) {
        this.artist_image = artist_image;
    }
}
