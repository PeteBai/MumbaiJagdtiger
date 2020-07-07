package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.FlightByDateBean;
import org.liberty.j.jagdtiger.mapper.FlightByDateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightByDateService {
    @Autowired
    private FlightByDateMapper fbdm;
    public List<FlightByDateBean> getFlightTotalNumByDay()
    {
        return fbdm.getTotalNumByday();
    }
}