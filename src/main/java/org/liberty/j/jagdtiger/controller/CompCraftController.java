package org.liberty.j.jagdtiger.controller;

import java.util.List;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CompCraftBean;
import org.liberty.j.jagdtiger.entity.CraftBean;
import org.liberty.j.jagdtiger.service.CompCraftService;
import org.liberty.j.jagdtiger.service.CraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompCraftController {
    @Autowired
    private CompCraftService ccs;
    @Autowired
    private CraftService cs;
    @RequestMapping(value = "/company/getCompanyCraftInfo")
    public Result getCCMsg() throws Exception
    {
        List<CompCraftBean> t = ccs.queryAllCC();
        Result r = new Result<>(true, 200, "", t);
        return r;
    }
    @RequestMapping(value="/company/getAircraftInfos", method=RequestMethod.GET)
    public Result getCompCraftInfo(@RequestParam String companyName) throws Exception
    {
        List<CompCraftBean> t = ccs.queryCompanyCC(companyName);
        //System.out.println(companyName);
        Result r = new Result<>(true, 200, "", t);
        return r;
    }
    @RequestMapping(value = "/plane/getPlanesIntroductions")
    public Result getCMsg() throws Exception
    {
        List<CraftBean> t = cs.queryAllC();
        Result r = new Result<>(true, 200, "", t);
        return r;
    }
}