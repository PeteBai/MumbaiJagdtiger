package org.liberty.j.jagdtiger.controller;


import com.google.gson.JsonObject;
import net.sf.json.JSONObject;
import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CityAvgPriceBean;
import org.liberty.j.jagdtiger.service.CityAvgPriceService;
import org.liberty.j.jagdtiger.service.CompCraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;




@RestController
@CrossOrigin
public class CityAvgPriceController {

    @Autowired
    private CityAvgPriceService caps;

    @RequestMapping(value = "/city/getCityAvgPrice_tsts")
    public List<CityAvgPriceBean> getCAPMsg() throws Exception{
        return caps.queryCAPM();
    }


    @RequestMapping(value = "/city/getCityAvgPrices", method = RequestMethod.GET)
    public Result getCityAvgPrices(@RequestParam String month) throws Exception{
        String q_month = month.substring(5,7);
        //System.out.println(q_month);


        List<CityAvgPriceBean> l = caps.queryCA_DPM(q_month);
        List<JSONObject> arr = new ArrayList<JSONObject>();
        for(int i = 0; i < l.size() ; i ++){
            CityAvgPriceBean t = l.get(i);
            JSONObject tarr = new JSONObject();
            tarr.put("city",t.getCity());
            tarr.put("price",t.getAvg_arr_price());
            arr.add(tarr);
        }

        List<JSONObject> dep = new ArrayList<JSONObject>();
        for(int i = 0; i < l.size() ; i ++){
            CityAvgPriceBean t = l.get(i);
            JSONObject tdep = new JSONObject();
            tdep.put("city",t.getCity());
            tdep.put("price",t.getAvg_dep_price());
            dep.add(tdep);
        }
        JSONObject ret = new JSONObject();
        ret.put("dep",dep);
        ret.put("arr",arr);
        //System.out.println(ret);
        Result r = new Result<>(true, 200, "", ret);
        return r;
    }


}
