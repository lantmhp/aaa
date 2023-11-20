package Model;

public class Song {
    int Song_Id;
    String Song_Title;
    String Song_Artsit;
    int Duration;
    byte[] Song_Image;

    public Song(String song_Title, String song_Artsit) {
        Song_Title = song_Title;
        Song_Artsit = song_Artsit;
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

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int duration) {
        Duration = duration;
    }

    public byte[] getSong_Image() {
        return Song_Image;
    }

    public void setSong_Image(byte[] song_Image) {
        Song_Image = song_Image;
    }
}
