package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompDescBean;

@Mapper
public interface CompDescMapper {
    @Select("select * from flight_company")
    List<CompDescBean> getAllCDB();
}