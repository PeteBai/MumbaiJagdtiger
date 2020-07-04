package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CompCraftBean;

@Mapper
public interface CompCraftMapper {
    @Select("select * from company_craft, aircraft where company_craft.craftModel = aircraft.craftModel")
    List<CompCraftBean> getAllCCB();
    @Select("select distinct company_craft.num, company_craft.craftFamily, aircraft.craftCompany from company_craft, aircraft where company_craft.craftFamily = aircraft.craftFamily and company_craft.comp_code=#{co} order by aircraft.craftCompany, company_craft.craftFamily")
    List<CompCraftBean> getCompanyCCB(@Param("co") String co);
}