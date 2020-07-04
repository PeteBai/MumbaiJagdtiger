package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompCraftBean;

@Mapper
public interface CompCraftMapper {
    @Select("select * from company_craft, aircraft where company_craft.craftModel = aircraft.craftModel")
    List<CompCraftBean> getAllCCB();
}