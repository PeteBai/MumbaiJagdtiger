package org.liberty.j.jagdtiger.service;

import org.liberty.j.jagdtiger.entity.CityLineNumBean;
import org.liberty.j.jagdtiger.mapper.CityLineNumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityLineNumService {
    @Autowired
    private CityLineNumMapper cityLineNumMapper;
    public List<CityLineNumBean> queryCityLineNum(){
        return cityLineNumMapper.getCityAffectedNum();
    }
}
