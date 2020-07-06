package org.liberty.j.jagdtiger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CityMinPriListBean;
import org.liberty.j.jagdtiger.entity.FlightLinePriceBean;


@Mapper
public interface FlightLinePriceMapper {
    @Select("select price_list from ctoc_flight_price where dep_ct = #{depct} and arr_ct = #{arrct} and line = #{flightid}")
    FlightLinePriceBean getFPL(@Param("depct") String depct, @Param("arrct") String arrct, @Param("flightid") String flightid);


}
