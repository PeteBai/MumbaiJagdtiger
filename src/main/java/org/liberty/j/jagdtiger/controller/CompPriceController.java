package org.liberty.j.jagdtiger.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CompDescBean;
import org.liberty.j.jagdtiger.entity.CompPriceBean;
import org.liberty.j.jagdtiger.service.CompDescService;
import org.liberty.j.jagdtiger.service.CompPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompPriceController {
    @Autowired
    private CompPriceService cps;
    @RequestMapping(value="/flight/getTotalPriceXZ")
    public List<CompPriceBean> getCAPMsg() throws Exception
    {
        List<CompPriceBean> cpbs = cps.queryAllCP();
        return cpbs;
    }
    @RequestMapping(value = "/dashboard/getCompanyAvgPrice")
    public Result getTopCompPrice() throws Exception
    {
        List<CompPriceBean> cpbs = cps.queryAllCP();
        List<CompPriceBean> temp = cpbs.subList(cpbs.size()-15, cpbs.size());
        Collections.reverse(temp);
        Result r = new Result<>(true, 200, "", temp);
        return r;
    }
}