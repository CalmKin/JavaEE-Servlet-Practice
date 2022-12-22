package com.calmkin.pojo;

public class Place {
    private Integer id;

    private String placeName;


    private Integer subsNum;
//    该地点是否提供预约服务
     private Integer status;

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", subsNum=" + subsNum +
                ", status=" + status +
                '}';
    }

    public Place() {
    }
//    将整数型状态和字符串进行绑定
    public String getStatusStr(){
        if (status == null){
            return "未知";
        }
        return status == 0 ? "禁用":"启用";
    }

    public Place(Integer id, String placeName, Integer subsNum, Integer status) {
        this.id = id;
        this.placeName = placeName;
        this.subsNum = subsNum;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Integer getSubsNum() {
        return subsNum;
    }

    public void setSubsNum(Integer subsNum) {
        this.subsNum = subsNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
