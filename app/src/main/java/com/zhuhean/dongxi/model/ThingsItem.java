package com.zhuhean.dongxi.model;

/**
 * Created by vincent on 14/11/22.
 */
public class ThingsItem {
    String mainPicture;
    String thingsName;
    String thingsDetailUrl;
    String price;
    String userIcon;
    String userName;
    String userHomePage;
    String userComment;
    String numberOfLikes;
    String numberOfAddToDouList;
    String numberOfReply;


    public ThingsItem(String mainPicture,String thingsName,String price,String userIcon,String userName,
                      String userComment,String numberOfLikes,String numberOfAddToDouList,String numberOfReply,
                      String userHomePage,String thingsDetailUrl) {
        this.mainPicture = mainPicture;
        this.thingsName=thingsName;
        this.price=price;
        this.userIcon=userIcon;
        this.userName=userName;
        this.userComment=userComment;
        this.numberOfLikes=numberOfLikes;
        this.numberOfAddToDouList=numberOfAddToDouList;
        this.numberOfReply=numberOfReply;
        this.userHomePage=userHomePage;
        this.thingsDetailUrl=thingsDetailUrl;
    }

    public ThingsItem(){}

    public String getUserHomePage() {
        return userHomePage;
    }

    public void setUserHomePage(String userHomePage) {
        this.userHomePage = userHomePage;
    }

    public String getThingsDetailUrl() {

        return thingsDetailUrl;
    }

    public void setThingsDetailUrl(String thingsDetailUrl) {
        this.thingsDetailUrl = thingsDetailUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThingsName() {

        return thingsName;
    }

    public void setThingsName(String thingsName) {
        this.thingsName = thingsName;
    }

    public String  getMainPicture() {

        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

    public String getNumberOfReply() {
        return numberOfReply;
    }

    public void setNumberOfReply(String numberOfReply) {
        this.numberOfReply = numberOfReply;
    }

    public String getNumberOfAddToDouList() {

        return numberOfAddToDouList;
    }

    public void setNumberOfAddToDouList(String numberOfAddToDouList) {
        this.numberOfAddToDouList = numberOfAddToDouList;
    }

    public String getNumberOfLikes() {

        return numberOfLikes;
    }

    public void setNumberOfLikes(String numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserComment() {

        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getUserIcon() {

        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }
}
