package Model;

import java.io.Serializable;

public class album implements Serializable {
    int Album_id;
    int Artist_id;
    String Album_name;
    String releaseDate;
    String Artist_Name;
    byte[] Thumb;

    public album(String album_name, String releaseDate, String artist_Name) {
        Album_name = album_name;
        this.releaseDate = releaseDate;
        Artist_Name = artist_Name;
    }

    public String getArtist_Name() {
        return Artist_Name;
    }

    public void setArtist_Name(String artist_Name) {
        Artist_Name = artist_Name;
    }


    public int getAlbum_id() {
        return Album_id;
    }

    public void setAlbum_id(int album_id) {
        Album_id = album_id;
    }

    public int getArtist_id() {
        return Artist_id;
    }

    public void setArtist_id(int artist_id) {
        Artist_id = artist_id;
    }

    public String getAlbum_name() {
        return Album_name;
    }

    public void setAlbum_name(String album_name) {
        Album_name = album_name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public byte[] getThumb() {
        return Thumb;
    }

    public void setThumb(byte[] thumb) {
        Thumb = thumb;
    }
}
