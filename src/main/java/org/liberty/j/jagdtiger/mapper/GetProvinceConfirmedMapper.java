package org.liberty.j.jagdtiger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.GetProvinceConfirmedBean;

import java.util.List;

@Mapper
public interface GetProvinceConfirmedMapper {
    @Select("select dateId,confirmedCount,provinceShortName as province from coviddata where dateId >= \"2020-01-30\" order by dateId")
    List<GetProvinceConfirmedBean> getProvinceConfirmed();
}
