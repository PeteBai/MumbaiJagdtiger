package org.liberty.j.jagdtiger.service;


import java.util.List;

import org.liberty.j.jagdtiger.mapper.CityAvgPriceMapper;
import org.liberty.j.jagdtiger.entity.CityAvgPriceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityAvgPriceService {

    @Autowired
    CityAvgPriceMapper capm;

    public List<CityAvgPriceBean> queryCAPM() throws Exception
    {
        return capm.getCAPM();
    }

    public  List<CityAvgPriceBean> queryCA_DPM(String mth) throws Exception
    {
        return capm.getCA_DP(mth);
    }


}
