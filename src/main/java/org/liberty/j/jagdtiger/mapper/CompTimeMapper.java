package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompTimeBean;

@Mapper
public interface CompTimeMapper {
    @Select("select * from comp_arr_hour where company = #{c}")
    List<CompTimeBean> getCompanyArrTime(@Param("c") String c);
    @Select("select * from comp_dep_hour where company = #{c}")
    List<CompTimeBean> getCompanyDepTime(@Param("c") String c);
}