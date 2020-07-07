package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.FlightByDateBean;

@Mapper
public interface FlightByDateMapper {
    @Select("select * from flight_totalnum_byday")
    List<FlightByDateBean> getTotalNumByday();
}