package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompCraftBean;

@Mapper
public interface CompCraftMapper {
    @Select("select * from comp_craft, aircraft where comp_craft.craftModel = aircraft.craftModel")
    List<CompCraftBean> getAllCCB();
    @Select("select distinct comp_craft.num, comp_craft.craftFamily, aircraft.craftCompany from comp_craft, aircraft where comp_craft.craftFamily = aircraft.craftFamily and comp_craft.comp_code=#{co} order by aircraft.craftCompany, comp_craft.craftFamily")
    List<CompCraftBean> getCompanyCCB(@Param("co") String co);
}