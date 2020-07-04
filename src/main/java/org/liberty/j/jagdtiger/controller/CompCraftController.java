package org.liberty.j.jagdtiger.controller;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CompCraftBean;
import org.liberty.j.jagdtiger.service.CompCraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompCraftController {
    @Autowired
    private CompCraftService ccs;
    @RequestMapping(value = "/company/getCompanyCraftInfo")
    public List<CompCraftBean> getCCMsg() throws Exception
    {
        return ccs.queryAllCC();
    }
}