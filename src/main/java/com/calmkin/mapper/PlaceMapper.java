package com.calmkin.mapper;

import com.calmkin.pojo.Place;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PlaceMapper {
    /*分页查询功能*/
    @ResultMap("placeResultMap")
    @Select("select * from place limit #{begin},#{pageSize}")
    List<Place> selectAllPlaces(@Param("begin") int begin,@Param("pageSize") int pageSize);

    @Select("select count(*) from place")
    int totalCount();

    /*添加功能*/
    @Insert("insert into place (id,place_name,subs_num,status) values(null,#{place.placeName},#{place.subsNum},#{place.status})")
     void addPlace(@Param("place") Place place);

    /*修改功能*/
    void updatePlace(Place place);

    /*批量删除地点*/
    void deleteByIds(@Param("ids") int[] ids);

//    修改当前地点的预约人数
    @Update("update place set subs_num = subs_num+1 where place_name = #{place}")
    void updateNumOfSubs(String place);

    //选择所有的可以使用的核酸检测点
    @ResultMap("placeResultMap")
    @Select("select place_name,status from place where status=1")
    List<String> accessiblePlace();

}
