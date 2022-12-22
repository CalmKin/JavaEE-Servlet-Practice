package com.calmkin.pojo;

public class Condition {
    private String userName;
    private String status;

    @Override
    public String toString() {
        return "Condition{" +
                "userName='" + userName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Condition() {
    }

    public Condition(String userName, String status) {
        this.userName = userName;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
