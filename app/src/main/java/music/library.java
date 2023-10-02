package music;

public class library {
    private  int imgLib;
    private  String nameLib;

    public library(int imgLib, String nameLib) {
        this.imgLib = imgLib;
        this.nameLib = nameLib;
    }

    public int getImgLib() {
        return imgLib;
    }

    public void getImgLib(int imgLib) {
        this.imgLib = imgLib;
    }

    public String getNameLib() {
        return nameLib;
    }

    public void getNameLib(String nameLib) {
        this.nameLib = nameLib;
    }
}
