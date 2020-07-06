package org.liberty.j.jagdtiger.controller;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CityFlightNumBean;
import org.liberty.j.jagdtiger.service.CityFlightNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin
public class CityFlightNumController {

    @Autowired
    private CityFlightNumService clns;


    @RequestMapping(value = "/city/getCityFlightNum", method = RequestMethod.GET)
    public Result getCityAvgPrices(@RequestParam String month) throws Exception {
        String q_month = month.substring(5,7);
        //System.out.println(q_month);

        int mx = clns.getMaxLineNum(q_month);
        int mn = clns.getMinLineNum(q_month);

        List<CityFlightNumBean> l = clns.query_CLNM(q_month);
        Result r = new Result<>(true, 200, "", l);
        return r;
    }
}
