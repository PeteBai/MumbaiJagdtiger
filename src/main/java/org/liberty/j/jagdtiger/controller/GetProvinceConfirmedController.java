package org.liberty.j.jagdtiger.controller;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.GetProvinceConfirmedBean;
import org.liberty.j.jagdtiger.service.GetProvinceConfirmedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.liberty.j.jagdtiger.ListSplit.ListSplit;
import java.util.List;
@CrossOrigin
@RestController
public class GetProvinceConfirmedController {
    @Autowired
    private GetProvinceConfirmedService getProvinceConfirmedService;
    @RequestMapping(value = "/wdnmd")
    public Result getProvinceConfirmedMsg(){
        Result re = new Result();
        try
        {
            List<List<GetProvinceConfirmedBean>> list = ListSplit.splitList(getProvinceConfirmedService.queryProvinceConfirmed());
            re.setSuccess(true);
            re.setCode(200);
            re.setData(list);
        }catch (Exception e)
        {
            re.setSuccess(false);
            e.printStackTrace();
        }
        return re;
    }
}

