package com.zhuhean.dongxi.model;

/**
 * Created by vincent on 14/11/24.
 */
public class GuessUserLikesItem {
    private int image;
    private String price;
    private String name;
    private String comment;

    public GuessUserLikesItem(int image,String price,String name,String comment){
        this.image=image;
        this.price=price;
        this.name=name;
        this.comment=comment;
    }

    public GuessUserLikesItem(int image,String price,String name){
        this.image=image;
        this.price=price;
        this.name=name;
    }

    public GuessUserLikesItem(){}

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
