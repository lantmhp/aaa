package music;

public class library {
    private int imgLib;
    private String nameLib;
    private String nameCat;

    public library(int imgLib, String nameLib, String nameCat) {
        this.imgLib = imgLib;
        this.nameLib = nameLib;
        this.nameCat = nameCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public int getImgLib() {
        return imgLib;
    }

    public void setImgLib(int imgLib) {
        this.imgLib = imgLib;
    }

    public String getNameLib() {
        return nameLib;
    }

    public void setNameLib(String nameLib) {
        this.nameLib = nameLib;
    }
}
