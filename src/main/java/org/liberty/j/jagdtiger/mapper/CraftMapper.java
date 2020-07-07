package org.liberty.j.jagdtiger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.liberty.j.jagdtiger.entity.CraftBean;

@Mapper
public interface CraftMapper {
    @Select("select craftFamily, craftSize, craftLoad, craftDesc from aircraft")
    List<CraftBean> getAllCB();
}