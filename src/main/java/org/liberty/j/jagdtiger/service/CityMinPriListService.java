package org.liberty.j.jagdtiger.service;


import org.apache.ibatis.annotations.Param;
import org.liberty.j.jagdtiger.entity.CityAvgPriceBean;
import org.liberty.j.jagdtiger.entity.CityMinPriListBean;
import org.liberty.j.jagdtiger.mapper.CityLineNumMapper;
import org.liberty.j.jagdtiger.mapper.CityMinPriListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityMinPriListService {


    @Autowired
    CityMinPriListMapper cmplm;


    public CityMinPriListBean getCMPLM(String depct,String arrct){
        return cmplm.getCMPL(depct,arrct);
    }




}
