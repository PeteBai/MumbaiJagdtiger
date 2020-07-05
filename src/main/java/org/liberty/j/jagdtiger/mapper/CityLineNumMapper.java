package org.liberty.j.jagdtiger.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CityLineNumBean;

import java.util.List;

@Mapper
public interface CityLineNumMapper {


    @Select("select city,sum_dep_arr from city_avg_data where month = #{mth}")
    List<CityLineNumBean> getCLN(@Param("mth") String mth);

    @Select("select max(sum_dep_arr) from city_avg_data where month = #{mth}")
    int getMaxLineNum(@Param("mth") String mth);

    @Select("select min(sum_dep_arr) from city_avg_data where month = #{mth}")
    int getMinLineNum(@Param("mth") String mth);

}
