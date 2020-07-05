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
            "{'month': '2020-03', 'sum_dep_arr': 312786, 'avg_arr_price': 600.07}",
            "{'month': '2020-04', 'sum_dep_arr': 143446, 'avg_arr_price': 649.98}",
            "{'month': '2020-07', 'sum_dep_arr': 471124, 'avg_arr_price': 1092.76}"
    };

    public String tim[] = {
            " {'tm': '00', 'p': 567.39}" ,
            " {'tm': '01', 'p': 1475.91}" ,
            " {'tm': '02', 'p': 1052.67}" ,
            " {'tm': '03', 'p': 1478.66}" ,
            " {'tm': '04', 'p': 974.83}" ,
            " {'tm': '05', 'p': 942.75}" ,
            " {'tm': '06', 'p': 931.28}" ,
            " {'tm': '07', 'p': 931.74}" ,
            " {'tm': '08', 'p': 888.15}" ,
            " {'tm': '09', 'p': 1002.48}" ,
            " {'tm': '10', 'p': 910.03}" ,
            " {'tm': '11', 'p': 980.44}" ,
            " {'tm': '12', 'p': 978.1}" ,
            " {'tm': '13', 'p': 938.03}" ,
            " {'tm': '14', 'p': 888.76}" ,
            " {'tm': '15', 'p': 950.53}" ,
            " {'tm': '16', 'p': 1032.87}" ,
            " {'tm': '17', 'p': 984.41}" ,
            " {'tm': '18', 'p': 934.72}" ,
            " {'tm': '19', 'p': 896.87}" ,
            " {'tm': '20', 'p': 955.95}" ,
            " {'tm': '21', 'p': 903.94}" ,
            " {'tm': '22', 'p': 769.49}" ,
            " {'tm': '23', 'p': 742.06}"
    };


    public String[] arrPrice ={
            " {'city': '乌鲁木齐', 'price': 1768.76}",
            " {'city': '拉萨', 'price': 1551.22}" ,
            " {'city': '哈尔滨', 'price': 1132.8}" ,
            " {'city': '西宁', 'price': 1021.88}" ,
            " {'city': '北京', 'price': 935.03}" ,
            " {'city': '三亚', 'price': 923.89}" ,
            " {'city': '扬州', 'price': 879.2}" ,
            " {'city': '成都', 'price': 877.26}" ,
            " {'city': '呼和浩特', 'price': 870.94}",
            " {'city': '长春', 'price': 832.69}"
    };


    public String[] depPrice ={
            "{'city': '三亚', 'price': 1257.27}" ,
            " {'city': '拉萨', 'price': 1172.27}" ,
            " {'city': '哈尔滨', 'price': 1159.35}" ,
            " {'city': '武汉', 'price': 1008.49}" ,
            " {'city': '成都', 'price': 938.1}" ,
            " {'city': '北京', 'price': 920.51}" ,
            " {'city': '乌鲁木齐', 'price': 917.05}" ,
            " {'city': '沈阳', 'price': 856.26}" ,
            " {'city': '长春', 'price': 846.0}" ,
            " {'city': '西宁', 'price': 838.18}"
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
