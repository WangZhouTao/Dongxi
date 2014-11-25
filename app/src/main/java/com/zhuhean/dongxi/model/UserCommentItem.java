package com.zhuhean.dongxi.model;

/**
 * Created by vincent on 14/11/23.
 */
public class UserCommentItem {
    private int userIcon;
    private String userName;
    private String userComment;

    public UserCommentItem(int userIcon,String userName,String userComment){
        this.userIcon=userIcon;
        this.userName=userName;
        this.userComment=userComment;
    }

    public UserCommentItem(){}

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserIcon() {

        return userIcon;
    }

    public void setUserIcon(int userIcon) {
        this.userIcon = userIcon;
    }
}
