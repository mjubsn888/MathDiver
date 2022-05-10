package model;

import java.net.URL;

public class ImageReference {

    private String imageName;
    private String strUrl;

    public ImageReference(String strUrl, String imageName){
        this.imageName=imageName;
        this.strUrl=strUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public String getStrUrl() {
        return strUrl;
    }
}
