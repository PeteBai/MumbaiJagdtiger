package org.liberty.j.jagdtiger.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CityLineNumBean;

@Mapper
public interface CityLineNumMapper {
    @Select("select date,linumlist from city_flightnum_byday order by date")
    List<CityLineNumBean> getCityAffectedNum();
}
