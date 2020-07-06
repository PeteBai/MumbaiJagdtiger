package org.liberty.j.jagdtiger.service;

import org.liberty.j.jagdtiger.entity.FlightLinePriceBean;
import org.liberty.j.jagdtiger.mapper.FlightLinePriceMapper;
import org.liberty.j.jagdtiger.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightLinePriceService {


    @Autowired
    private FlightLinePriceMapper flpm;

    public FlightLinePriceBean getFlightLinePriceList(String depct,String arrct,String line)throws Exception {
        return flpm.getFPL(depct,arrct,line);
    }

}
