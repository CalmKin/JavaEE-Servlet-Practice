package com.calmkin.mapper;

import com.calmkin.pojo.PageBean;
import com.calmkin.pojo.Result;
import com.calmkin.pojo.Subsc;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SubsMapper {
//    条件分页查询
    @ResultMap("SubsResultMap")
    @Select("select * from subscribe limit #{begin},#{pageSize}")
    List<Subsc> selectAllSubs(@Param("begin") int begin,@Param("pageSize") int pageSize);

    @Select("select count(*) from subscribe")
    int selectTotalCount();

//    插入预约记录
    void addSubscription(@Param("subsc") Subsc subsc);

}
