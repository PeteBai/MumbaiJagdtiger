package org.liberty.j.jagdtiger.service;


import org.liberty.j.jagdtiger.entity.FlightBean;
import org.liberty.j.jagdtiger.entity.FlightTenDayBean;
import org.liberty.j.jagdtiger.mapper.FlightTenDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightTenDayService {

    @Autowired
    private FlightTenDayMapper ftdm;

    public FlightTenDayBean getTenday(String city)throws Exception{
        return ftdm.getTenday(city);
    }

}
