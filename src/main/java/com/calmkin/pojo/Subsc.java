package com.calmkin.pojo;

//用户的预约信息展示，和数据库里面的预约信息不完全相同，用于
public class Subsc {
     private  String userName;
     private  String tele;
     private  String cardID;
     private  String home;
     private  String subPlace;
     private  String subTime;

    @Override
    public String toString() {
        return "Subsc{" +
                "userName='" + userName + '\'' +
                ", tele='" + tele + '\'' +
                ", cardID='" + cardID + '\'' +
                ", home='" + home + '\'' +
                ", subPlace='" + subPlace + '\'' +
                ", subTime='" + subTime + '\'' +
                '}';
    }

    public Subsc() {
    }

    public Subsc(String userName, String tele, String cardID, String home, String subPlace, String subTime) {
        this.userName = userName;
        this.tele = tele;
        this.cardID = cardID;
        this.home = home;
        this.subPlace = subPlace;
        this.subTime = subTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getSubPlace() {
        return subPlace;
    }

    public void setSubPlace(String subPlace) {
        this.subPlace = subPlace;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }
}
