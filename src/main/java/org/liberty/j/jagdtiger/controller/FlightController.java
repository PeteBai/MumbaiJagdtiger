package org.liberty.j.jagdtiger.controller;


import com.alibaba.fastjson.JSONObject;
import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.FlightBean;
import org.liberty.j.jagdtiger.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class FlightController {

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
    private FlightService fs;

    @RequestMapping(value = "/flight/getCityToCityFlights",method = RequestMethod.GET)
    public Result getCityFlight(@RequestParam String dep_city, @RequestParam String arr_city) throws Exception {
        JSONObject to_city = JSONObject.parseObject(city);
        //System.out.println(to_city);

        String dep_ct = to_city.get(dep_city).toString();
        String arr_ct = to_city.get(arr_city).toString();
        System.out.println(dep_ct+' '+arr_ct);

        List<FlightBean> l = fs.getFlight(dep_ct,arr_ct);
        List<String> ret = new ArrayList<>();
        System.out.println(l.size());
        for (int i = 0;i < l.size();i++){


            //System.out.println(i);
            //System.out.println(l.get(i).getLine());

            ret.add(l.get(i).getLine());

        }

        Result r = new Result<>(true, 200, "", ret);
        return r;
    }


}
