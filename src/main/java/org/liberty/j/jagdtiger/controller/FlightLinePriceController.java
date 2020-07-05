package org.liberty.j.jagdtiger.controller;


import com.alibaba.fastjson.JSONObject;
import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CityMinPriListBean;
import org.liberty.j.jagdtiger.entity.FlightLinePriceBean;
import org.liberty.j.jagdtiger.service.CityAvgPriceService;
import org.liberty.j.jagdtiger.service.FlightLinePriceService;
import org.liberty.j.jagdtiger.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class FlightLinePriceController {

    public String city = new String("{'BJS': '北京', 'CGQ': '长春', 'CKG': '重庆', " +
            "'CSX': '长沙', 'CTU': '成都', 'DLC': '大连', 'FOC': '福州', " +
            "'CAN': '广州', 'KWE': '贵阳', 'KWL': '桂林', 'HAK': '海口', 'HET': " +
            "'呼和浩特', 'HFE': '合肥', 'HGH': '杭州', 'HRB': '哈尔滨', 'TNA': '济南', " +
            "'KMG': '昆明', 'LHW': '兰州', 'LXA': '拉萨', 'KHN': '南昌', 'NKG': '南京'," +
            " 'NNG': '南宁', 'JJN': '泉州', 'TAO': '青岛', 'SHA': '上海', 'SHE': '沈阳'," +
            " 'SJW': '石家庄', 'SYX': '三亚', 'SZX': '深圳', 'TSN': '天津', 'TYN': '太原'," +
            " 'URC': '乌鲁木齐', 'WNZ': '温州', 'WUH': '武汉', 'WUX': '无锡', 'SIA': '西安', " +
            "'XMN': '厦门', 'XNN': '西宁', 'INC': '银川', 'YTY': '扬州', 'CGO': '郑州', 'ZUH': '珠海'}");


    @Autowired
    private FlightLinePriceService flps;

    @RequestMapping(value = "/flight/getFlightHistoryPrice",method = RequestMethod.GET)
    public Result getCityFlightPrice(@RequestParam String dep_city, @RequestParam String arr_city, @RequestParam String flightNum) throws Exception {
        JSONObject to_city = JSONObject.parseObject(city);
        //System.out.println(to_city);

        String dep_ct = to_city.get(dep_city).toString();
        String arr_ct = to_city.get(arr_city).toString();
        System.out.println(dep_ct+' '+arr_ct);

        String q_flight = flightNum;

        FlightLinePriceBean l = flps.getFlightLinePriceList(dep_ct,arr_ct,q_flight);

        String ret = l.getPrice_list();

        int len = ret.length();
        String t =  ret.substring(2,len-2);

        List<JSONObject> Ans = new ArrayList<JSONObject>();
        String [] splt = t.split(",");
        for (int i = 0;i<splt.length ;i ++) {
            int lens = splt[i].length();
            String [] tplt = splt[i].substring(2,lens-1).split("\\|");

            JSONObject ans = new JSONObject();
            ans.put("day",tplt[0]);
            ans.put("price",Integer.valueOf(tplt[1]));
            Ans.add(ans);
        }

        Result r = new Result<>(true, 200, "", Ans);
        return r;
    }


}
