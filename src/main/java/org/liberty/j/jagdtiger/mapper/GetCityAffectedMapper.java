package org.liberty.j.jagdtiger.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.GetCityAffectedBean;

@Mapper
public interface GetCityAffectedMapper {
    @Select("select dateId,confirmedCount from coviddata where (dateId = \"2020-01-30\" or " +
            "dateId = \"2020-02-10\" or dateId = \"2020-02-20\" or dateId = \"2020-02-29\" or " +
            "dateId = \"2020-03-10\" or dateId = \"2020-03-20\" or dateId = \"2020-03-30\" or " +
            "dateId = \"2020-04-10\" or dateId = \"2020-04-20\" or dateId = \"2020-04-30\" or " +
            "dateId = \"2020-05-10\" or dateId = \"2020-05-20\" or dateId = \"2020-05-30\" or " +
            "dateId = \"2020-06-10\" or dateId = \"2020-06-17\") and provinceShortName = #{province}")
    List<GetCityAffectedBean> getCityAffectedNum(@Param("province") String province);
}
