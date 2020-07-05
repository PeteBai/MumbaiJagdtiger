package org.liberty.j.jagdtiger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CityFlightBean;

@Mapper
public interface CityFlightMapper {
    @Select("select arr_ct as city, count(*) as `lines` from flight_split where arr_ct = #{a} and dep_ct = #{d}")
    CityFlightBean getCityFlightCount(@Param("a") String a, @Param("d") String d);
}