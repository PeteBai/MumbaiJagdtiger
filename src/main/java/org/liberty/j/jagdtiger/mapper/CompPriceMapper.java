package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompPriceBean;

@Mapper
public interface CompPriceMapper {
    @Select("select * from comp_avg_price order by avg_price")
    List<CompPriceBean> getAllCAP();
}