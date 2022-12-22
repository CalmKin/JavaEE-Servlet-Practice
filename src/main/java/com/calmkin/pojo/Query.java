package com.calmkin.pojo;

public class Query {
    private String userName;
    private String cardID;

    public Query() {
    }

    @Override
    public String toString() {
        return "Query{" +
                "userName='" + userName + '\'' +
                ", cardID='" + cardID + '\'' +
                '}';
    }

    public Query(String userName, String cardID) {
        this.userName = userName;
        this.cardID = cardID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }
}
