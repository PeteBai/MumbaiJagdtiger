package org.liberty.j.jagdtiger.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CityMinPriListBean;

@Mapper
public interface CityMinPriListMapper {

    @Select("select min_price_list from ctoc_min_price where dep_ct = #{depct} and arr_ct = #{arrct}" )
    CityMinPriListBean getCMPL(@Param("depct") String depct, @Param("arrct") String arrct);


}
