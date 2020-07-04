package org.liberty.j.jagdtiger.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.liberty.j.jagdtiger.entity.CompDescBean;
import org.liberty.j.jagdtiger.entity.CompPriceBean;
import org.liberty.j.jagdtiger.service.CompDescService;
import org.liberty.j.jagdtiger.service.CompPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompPriceController {
    @Autowired
    private CompPriceService cps;
    @RequestMapping(value="/flight/getTotalPrice")
    public List<CompPriceBean> getCAPMsg() throws Exception
    {
        List<CompPriceBean> cpbs = cps.queryAllCP();
        return cpbs;
    }
    @RequestMapping(value = "/dashboard/getCompanyAvgPrice")
    public List<CompPriceBean> getTopCompPrice() throws Exception
    {
        List<CompPriceBean> cpbs = cps.queryAllCP();
        List<CompPriceBean> temp = cpbs.subList(cpbs.size()-15, cpbs.size());
        Collections.reverse(temp);
        return temp;
    }
}