package org.liberty.j.jagdtiger.service;

import java.util.List;
import org.liberty.j.jagdtiger.entity.GetCityAffectedBean;
import org.liberty.j.jagdtiger.mapper.GetCityAffectedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCityAffectedService {
    @Autowired
    private GetCityAffectedMapper getCityAffectedMapper;
    public List<GetCityAffectedBean> queryCityAffected(String province)
    {
        //System.out.println(province);
        return getCityAffectedMapper.getCityAffectedNum(province);
    }
}
