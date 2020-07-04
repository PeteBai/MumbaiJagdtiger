package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompFlightBean;

@Mapper
public interface CompFlightMapper {
    @Select("select * from comp_ct")
    List<CompFlightBean> getAllCF();
}