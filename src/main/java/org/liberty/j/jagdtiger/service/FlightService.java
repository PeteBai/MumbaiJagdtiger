package org.liberty.j.jagdtiger.service;

import org.liberty.j.jagdtiger.entity.FlightBean;
import org.liberty.j.jagdtiger.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {


    @Autowired
    private FlightMapper fm;
    public List<FlightBean> getFlight(String depct,String arrct)throws Exception{
        //System.out.println(depct+"---"+arrct);
        return fm.getFlight(depct,arrct);
    }
}
