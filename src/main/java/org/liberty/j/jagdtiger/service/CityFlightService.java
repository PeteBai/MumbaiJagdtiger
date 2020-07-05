package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CityFlightBean;
import org.liberty.j.jagdtiger.mapper.CityFlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityFlightService {
    @Autowired
    private CityFlightMapper cfm;
    public CityFlightBean getCityFlightCount(String a, String d) throws Exception
    {
        return cfm.getCityFlightCount(a, d);
    }
}
