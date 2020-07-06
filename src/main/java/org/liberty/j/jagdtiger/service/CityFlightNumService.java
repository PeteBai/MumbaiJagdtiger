package org.liberty.j.jagdtiger.service;


import org.liberty.j.jagdtiger.entity.CityFlightNumBean;
import org.liberty.j.jagdtiger.mapper.CityFlightNumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityFlightNumService {

    @Autowired
    CityFlightNumMapper clnm;


    public List<CityFlightNumBean> query_CLNM(String mth) throws Exception{
        return clnm.getCLN(mth);

    }


    public int getMaxLineNum(String mth) throws Exception{
        return clnm.getMaxLineNum(mth);
    }


    public int getMinLineNum(String mth) throws Exception{
        return clnm.getMinLineNum(mth);

    }


}
