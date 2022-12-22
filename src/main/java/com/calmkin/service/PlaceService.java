package com.calmkin.service;

import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Place;

import java.util.List;

public interface PlaceService {
//    查询所有地点
    public PageBean<Place> selectByPage(int currPage,int pageSize);
//    添加新的地点
    public void addPlace(Place place);
//    修改地点信息
    public void changeSingle(Place place);
//    批量删除地点
    public void deleteByIds(int[] ids);

//    获取所有可以使用的核酸检测点
    public List<String> accessiblePlace();
}
