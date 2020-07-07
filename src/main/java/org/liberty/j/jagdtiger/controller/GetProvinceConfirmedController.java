package org.liberty.j.jagdtiger.controller;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.ListSplit.CityLineNumListHelp;
import org.liberty.j.jagdtiger.ListSplit.ListSplit;
import org.liberty.j.jagdtiger.entity.CityLineNumBean;
import org.liberty.j.jagdtiger.entity.CityLineNumSizeBean;
import org.liberty.j.jagdtiger.entity.GetProvinceConfirmedBean;
import org.liberty.j.jagdtiger.service.CityLineNumService;
import org.liberty.j.jagdtiger.service.GetProvinceConfirmedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class GetProvinceConfirmedController {
    @Autowired
    private GetProvinceConfirmedService getProvinceConfirmedService;
    @Autowired
    private CityLineNumService cityLineNumService;
    @RequestMapping(value = "/corona/linenum")
    public Result getProvinceConfirmedMsg(){
        Result re = new Result();
        Map response  = new HashMap();
        try
        {
            List<List<GetProvinceConfirmedBean>> list = ListSplit.splitList(getProvinceConfirmedService.queryProvinceConfirmed());
            List<CityLineNumBean> cityLineNumList = cityLineNumService.queryCityLineNum();
            List<List<CityLineNumSizeBean>> cityLineNumSizelist = CityLineNumListHelp.lineSplit(cityLineNumList);
            response.put("cityLineNumData",cityLineNumSizelist);
            response.put("provinceAffectData",list);
            //System.out.println(cityLineNumSizelist.size());
            //System.out.println(list.size());
            re.setSuccess(true);
            re.setCode(200);
            re.setData(response);
        }catch (Exception e)
        {
            re.setSuccess(false);
            e.printStackTrace();
        }
        return re;
    }
}

