package com.calmkin.pojo;

public class User {
    private Integer id;
    private String cardID;
    private String tele;
    private String userName;
    private String addr;

    public User() {
    }

    public User(Integer id, String cardID, String tele, String userName, String addr) {
        this.id = id;
        this.cardID = cardID;
        this.tele = tele;
        this.userName = userName;
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
