package com.calmkin.mapper;

import com.calmkin.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    /**
     * 修改
//     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    void update(Brand brand);

    /*
    * 根据选择的数据行进行删除
    * */
    void deleteByIds(@Param("ids") int ids[]);

    /*
    * 分页查询
    * */
    @ResultMap("brandResultMap")
    @Select("select * from tb_brand limit #{begin},#{pageSize}")
    List<Brand> selectByPage(@Param("begin") int begin,@Param("pageSize") int pageSize);
    /*
        获取总的条目数量
    * */
    @Select("select count(*) from tb_brand")
    int totalCount();


    /*
    * 分页条件查询
    * */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("pageSize") int pageSize,@Param("brand") Brand brand);

    /*
    * 条件查询条目数量
    * */
    int totalCountByCondition(Brand brand);

    /*修改单条记录,传入要修改的id*/
    void changeSingle(Brand brand);

}
