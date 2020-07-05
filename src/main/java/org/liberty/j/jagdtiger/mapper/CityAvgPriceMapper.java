package org.liberty.j.jagdtiger.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CityAvgPriceBean;
import org.liberty.j.jagdtiger.entity.CompCraftBean;

import java.util.List;

@Mapper
public interface CityAvgPriceMapper {
    @Select("select month,city,avg_dep_price,avg_arr_price from city_avg_data")
    List<CityAvgPriceBean> getCAPM();

    @Select("select city,avg_dep_price,avg_arr_price from city_avg_data where month = #{mth}")
    List<CityAvgPriceBean> getCA_DP(@Param("mth") String mth);

}
