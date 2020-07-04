package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CompFlightBean;
import org.liberty.j.jagdtiger.mapper.CompFlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompFlightService {
    @Autowired
    private CompFlightMapper cfm;
    public List<CompFlightBean> queryAllCF() throws Exception
    {
        return cfm.getAllCF();
    }
    public List<CompFlightBean> queryCityByCompany(String co) throws Exception
    {
        return cfm.getQueryCity(co);
    }
}