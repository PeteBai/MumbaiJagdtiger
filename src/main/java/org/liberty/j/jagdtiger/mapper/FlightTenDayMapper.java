package org.liberty.j.jagdtiger.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.FlightBean;
import org.liberty.j.jagdtiger.entity.FlightTenDayBean;

import java.util.List;

@Mapper
public interface FlightTenDayMapper {

    @Select("select min_price_list from flight_tenday_data where city = #{ct}")
    FlightTenDayBean getTenday(@Param("ct") String ct);

}
