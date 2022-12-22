package com.calmkin.pojo;

public class Result {
    // 检测结果id
    private Integer resId;
    // 用户id
    private Integer userId;

    private String userName;



    // 检测时间
    private String checkTime;
    // 检测地点
    private String place;
    private String affected;

    @Override
    public String toString() {
        return "Result{" +
                "resId=" + resId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", checkTime='" + checkTime + '\'' +
                ", place='" + place + '\'' +
                ", affected='" + affected + '\'' +
                '}';
    }

    public Result(Integer resId, Integer userId, String userName, String checkTime, String place, String affected) {
        this.resId = resId;
        this.userId = userId;
        this.userName = userName;
        this.checkTime = checkTime;
        this.place = place;
        this.affected = affected;
    }

    public Result() {
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAffected() {
        return affected;
    }

    public void setAffected(String affected) {
        this.affected = affected;
    }
}
