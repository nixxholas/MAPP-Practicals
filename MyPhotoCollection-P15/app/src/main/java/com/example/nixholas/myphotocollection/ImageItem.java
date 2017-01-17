package com.example.nixholas.myphotocollection;

/**
 * Created by nixholas on 17/1/17.
 */

public class ImageItem {

    private int imageID;
    private String desc;

    public ImageItem(int imageID, String desc) {
        this.imageID = imageID;
        this.desc = desc;
    }

    public int getImageResource() {
        return imageID;
    }

    public String getDesc() {
        return desc;
    }

    public void setImageResource(int imageID){
        this.imageID = imageID;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

}