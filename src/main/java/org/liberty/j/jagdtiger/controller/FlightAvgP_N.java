package org.liberty.j.jagdtiger.controller;


import com.alibaba.fastjson.JSONObject;
import org.liberty.j.jagdtiger.Exception.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class FlightAvgP_N {


    public String msg[] = {
            " {'month': '01', 'sum_dep_arr': 516996, 'avg_arr_price': 1148.33}" ,
            " {'month': '02', 'sum_dep_arr': 212844, 'avg_arr_price': 1030.16}" ,
            " {'month': '03', 'sum_dep_arr': 344908, 'avg_arr_price': 651.91}" ,
            " {'month': '04', 'sum_dep_arr': 298806, 'avg_arr_price': 637.33}" ,
            " {'month': '05', 'sum_dep_arr': 331352, 'avg_arr_price': 547.95}" ,
            " {'month': '06', 'sum_dep_arr': 446988, 'avg_arr_price': 512.52}" ,
            " {'month': '07', 'sum_dep_arr': 549283, 'avg_arr_price': 1020.82}" ,
            " {'month': '08', 'sum_dep_arr': 521224, 'avg_arr_price': 1200.85}" ,
            " {'month': '09', 'sum_dep_arr': 682952, 'avg_arr_price': 845.36}" ,
            " {'month': '10', 'sum_dep_arr': 533777, 'avg_arr_price': 909.0}" ,
            " {'month': '11', 'sum_dep_arr': 508787, 'avg_arr_price': 805.0}" ,
            " {'month': '12', 'sum_dep_arr': 523050, 'avg_arr_price': 763.31}"
    };

    public String tim[] = {
            "{'tm': ' 00', 'p': 810.85}" ,
            " {'tm': ' 01', 'p': 903.42}" ,
            " {'tm': ' 02', 'p': 1197.55}" ,
            " {'tm': ' 03', 'p': 1567.35}" ,
            " {'tm': ' 04', 'p': 1058.46}" ,
            " {'tm': ' 05', 'p': 867.94}" ,
            " {'tm': ' 06', 'p': 731.64}" ,
            " {'tm': ' 07', 'p': 767.06}" ,
            " {'tm': ' 08', 'p': 853.19}" ,
            " {'tm': ' 09', 'p': 896.51}" ,
            " {'tm': ' 10', 'p': 865.63}" ,
            " {'tm': ' 11', 'p': 883.03}" ,
            " {'tm': ' 12', 'p': 860.18}" ,
            " {'tm': ' 13', 'p': 861.46}" ,
            " {'tm': ' 14', 'p': 872.27}" ,
            " {'tm': ' 15', 'p': 851.84}" ,
            " {'tm': ' 16', 'p': 849.35}" ,
            " {'tm': ' 17', 'p': 810.46}" ,
            " {'tm': ' 18', 'p': 790.99}" ,
            " {'tm': ' 19', 'p': 769.93}" ,
            " {'tm': ' 20', 'p': 755.95}" ,
            " {'tm': ' 21', 'p': 697.25}" ,
            " {'tm': ' 22', 'p': 597.15}" ,
            " {'tm': ' 23', 'p': 549.28}"
    };


    public String[] arrPrice ={
            "{'city': '乌鲁木齐', 'price': 1367.75}" ,
            " {'city': '拉萨', 'price': 1262.04}" ,
            " {'city': '三亚', 'price': 1109.39}" ,
            " {'city': '北京', 'price': 1092.69}" ,
            " {'city': '深圳', 'price': 993.53}" ,
            " {'city': '哈尔滨', 'price': 991.06}" ,
            " {'city': '广州', 'price': 960.16}" ,
            " {'city': '西宁', 'price': 958.36}" ,
            " {'city': '长春', 'price': 953.88}" ,
            " {'city': '沈阳', 'price': 911.55}"
    };


    public String[] depPrice ={
            "{'city': '乌鲁木齐', 'price': 1395.44}" ,
            " {'city': '拉萨', 'price': 1378.31}" ,
            " {'city': '三亚', 'price': 1074.34}" ,
            " {'city': '北京', 'price': 1071.02}" ,
            " {'city': '深圳', 'price': 929.26}" ,
            " {'city': '哈尔滨', 'price': 989.54}" ,
            " {'city': '广州', 'price': 923.63}" ,
            " {'city': '西宁', 'price': 912.55}" ,
            " {'city': '长春', 'price': 972.69}" ,
            " {'city': '沈阳', 'price': 945.81}"
    };


    @RequestMapping(value = "/flight/getTotalFlightsNum")
    public Result getFlghtAvgNum(){

        List<JSONObject> Ans = new ArrayList<JSONObject>();

        for(int i=0; i<msg.length ; i++){
            JSONObject cmsg = JSONObject.parseObject(msg[i]);
            JSONObject ret = new JSONObject();
            ret.put("时间",cmsg.get("month"));
            ret.put("起降数",cmsg.get("sum_dep_arr"));
            Ans.add(ret);
        }

        Result r = new Result<>(true, 200, "", Ans);
        return r;

    }
    @RequestMapping(value = "/flight/getTotalPrice")
    public Result getFlghtAvgPri(){

        List<JSONObject> Ans = new ArrayList<JSONObject>();

        for(int i=0; i<msg.length ; i++){
            JSONObject cmsg = JSONObject.parseObject(msg[i]);
            JSONObject ret = new JSONObject();
            ret.put("时间",cmsg.get("month"));
            ret.put("价格",cmsg.get("avg_arr_price"));
            Ans.add(ret);
        }

        Result r = new Result<>(true, 200, "", Ans);
        return r;

    }


    @RequestMapping(value = "/flight/getDayTimePrice")
    public Result getFlghtDatPri(){

        List<JSONObject> Ans = new ArrayList<JSONObject>();

        for(int i=0; i<tim.length ; i++){
            JSONObject cmsg = JSONObject.parseObject(tim[i]);
            JSONObject ret = new JSONObject();
            ret.put("时间",cmsg.get("tm"));
            ret.put("价格",cmsg.get("p"));
            Ans.add(ret);
        }

        Result r = new Result<>(true, 200, "", Ans);
        return r;

    }

    @RequestMapping(value = "/flight/getAllyearAvgPrice",method = RequestMethod.GET)
    public Result getAllyearAvgPrice(@RequestParam String type){
        List<JSONObject> Ans = new ArrayList<JSONObject>();
        if(type.compareTo("dep")==0){
            for(int i=0; i<depPrice.length ; i++){
                JSONObject cmsg = JSONObject.parseObject(depPrice[i]);
                JSONObject ret = new JSONObject();
                ret.put("city",cmsg.get("city"));
                ret.put("price",cmsg.get("price"));
                Ans.add(ret);
            }
        }
        else {
            for(int i=0; i<arrPrice.length ; i++){
                JSONObject cmsg = JSONObject.parseObject(arrPrice[i]);
                JSONObject ret = new JSONObject();
                ret.put("city",cmsg.get("city"));
                ret.put("price",cmsg.get("price"));
                Ans.add(ret);
            }
        }

        Result r = new Result<>(true, 200, "", Ans);
        return r;

    }



}
