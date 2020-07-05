package org.liberty.j.jagdtiger.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.GetCityAffectedBean;

@Mapper
public interface GetTotalAffectedMapper {
    @Select("select dateId,sum(confirmedCount) as confirmedCount " +
            "from coviddata " +
            "where dateId = \"2020-01-31\" or dateId = \"2020-02-29\" or dateId = \"2020-03-31\" or " +
            "dateId = \"2020-04-30\" or dateId = \"2020-05-31\" or dateId = \"2020-06-17\" " +
            "group by dateId")
    List<GetCityAffectedBean> getTotalAffectedNum();
}
