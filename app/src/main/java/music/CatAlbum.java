package music;

import java.util.List;
public class CatAlbum {
    private String nameCat;
    private List<album> albums;

    public CatAlbum(String nameCat, List<album> albums) {
        this.nameCat = nameCat;
        this.albums = albums;
    }

    public String getNameList() {
        return nameCat;
    }

    public void setNameList(String nameCat) {
        this.nameCat = nameCat;
    }

    public List<album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<album> albums) {
        this.albums = albums;
    }
}
