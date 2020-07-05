package org.liberty.j.jagdtiger.controller;
import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.GetCityAffectedBean;
import org.liberty.j.jagdtiger.service.GetTotalAffectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class GetTotalAffectedController {
    @Autowired
    private GetTotalAffectedService getTotalAffectedService;
    @RequestMapping(value = "/corona/getTotalAffected")
    public Result getTotalAffectedMsg(){
        Result re = new Result();
        try{
            re.setSuccess(true);
            re.setCode(200);
            List<GetCityAffectedBean> list = getTotalAffectedService.queryTotalAffected();
            for(GetCityAffectedBean item : list){
                String date = item.getDateId();
                item.setDateId(date.substring(0,7));
            }
            re.setData(list);
        }
        catch(Exception e) {
            re.setSuccess(false);
            e.printStackTrace();
        }
        return re;
    }
}
