package com.zhuhean.dongxi.model;

/**
 * Created by vincent on 14/11/25.
 */
public class RecommandDouListItem {
    private String douListLink;
    private String douListImage;
    private String douListTitle;

    public RecommandDouListItem(String douListLink,String douListImage,String douListTitle){
        this.douListLink=douListLink;
        this.douListImage=douListImage;
        this.douListTitle=douListTitle;
    }

    public String getDouListTitle() {
        return douListTitle;
    }

    public void setDouListTitle(String douListTitle) {
        this.douListTitle = douListTitle;
    }

    public String getDouListImage() {

        return douListImage;
    }

    public void setDouListImage(String douListImage) {
        this.douListImage = douListImage;
    }

    public String getDouListLink() {

        return douListLink;
    }

    public void setDouListLink(String douListLink) {
        this.douListLink = douListLink;
    }
}
