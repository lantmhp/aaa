package music;

public class album {
    private  int resourceId;
    private  String nameAlbum;

    public album(int resourceId, String nameAlbum) {
        this.resourceId = resourceId;
        this.nameAlbum = nameAlbum;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }
}
