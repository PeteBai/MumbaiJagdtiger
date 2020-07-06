package org.liberty.j.jagdtiger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompPriceBean;
import org.liberty.j.jagdtiger.entity.FlightBean;

import java.util.List;

@Mapper
public interface FlightMapper {
    @Select("select line from ctoc_flight_price where dep_ct = #{depct} and arr_ct = #{arrct}")
    List<FlightBean> getFlight(@Param("depct") String depct, @Param("arrct") String arrct);
}
