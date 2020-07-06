package org.liberty.j.jagdtiger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CompTimeBean;
import org.liberty.j.jagdtiger.service.CompTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompTimeController {
    @Autowired
    private CompTimeService cts;
    @RequestMapping(value = "/company/getCompanyTime", method = RequestMethod.POST)
    public Result getCompanyTime(@RequestBody Map companyList) throws Exception
    {
        //System.out.println(companyList);
        List<String> x = (List<String>)companyList.get("companyList");
        //System.out.println(x);
        //List<CompDescBean> allCD = cds.queryAllCD();
        List<CompTimeBean> ctbs_arr = new ArrayList<>();
        List<CompTimeBean> ctbs_dep = new ArrayList<>();
        for (String xs : x) {
            ctbs_arr.addAll(cts.getCompanyArrTime(xs));
            ctbs_dep.addAll(cts.getCompanyDepTime(xs));
        }
        Map<String, List<CompTimeBean>> m = new HashMap<String, List<CompTimeBean>>();
        m.put("arr", ctbs_arr);
        m.put("dep", ctbs_dep);
        Result r = new Result<>(true, 200, "", m);
        return r;
    }
}