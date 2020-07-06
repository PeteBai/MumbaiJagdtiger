package org.liberty.j.jagdtiger.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.GetCityAffectedBean;

@Mapper
public interface GetCityAffectedMapper {
    @Select("select dateId,confirmedCount from coviddata where (dateId = \"2020-01-25\" or " +
            "dateId = \"2020-02-05\" or dateId = \"2020-02-15\" or dateId = \"2020-02-25\" or " +
            "dateId = \"2020-03-05\" or dateId = \"2020-03-15\" or dateId = \"2020-03-25\" or " +
            "dateId = \"2020-04-05\" or dateId = \"2020-04-15\" or dateId = \"2020-04-25\" or " +
            "dateId = \"2020-05-05\" or dateId = \"2020-05-15\" or dateId = \"2020-05-25\" or " +
            "dateId = \"2020-06-05\" or dateId = \"2020-06-15\") and provinceShortName = #{province}")
    List<GetCityAffectedBean> getCityAffectedNum(@Param("province") String province);
}
