package org.liberty.j.jagdtiger.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.liberty.j.jagdtiger.entity.CompDescBean;
import org.liberty.j.jagdtiger.entity.CompFlightBean;
import org.liberty.j.jagdtiger.service.CompDescService;
import org.liberty.j.jagdtiger.service.CompFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompFlightController {
    @Autowired
    private CompFlightService cfs;
    @Autowired
    private CompDescService cds;
    @RequestMapping(value = "/company/getCompanyCityFlightCount")
    public Map getCFMsg() throws Exception
    {
        List<CompFlightBean> cfbs = cfs.queryAllCF();
        List<CompDescBean> cdbs = cds.queryAllCD();
        Map m = new HashMap();
        m.put("CompCityFlightInfo", cfbs);
        m.put("CompDesc", cdbs);
        return m;
    }
}