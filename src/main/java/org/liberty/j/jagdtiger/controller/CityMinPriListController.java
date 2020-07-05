package org.liberty.j.jagdtiger.controller;


//import net.sf.json.JSONObject;
import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CityMinPriListBean;
import org.liberty.j.jagdtiger.entity.FlightBean;
import org.liberty.j.jagdtiger.service.CityLineNumService;
import org.liberty.j.jagdtiger.service.CityMinPriListService;
import org.liberty.j.jagdtiger.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CityMinPriListController {

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
    private CityMinPriListService cmpls;
    @RequestMapping(value = "/city/getCityMinPriList", method = RequestMethod.GET)
    public Result getCityAvgPrices(@RequestParam String dep,@RequestParam String arr, @RequestParam String start,@RequestParam String end) throws Exception {
        JSONObject to_city = JSONObject.parseObject(city);
        //System.out.println(to_city);

        String dep_ct = to_city.get(dep).toString();
        String arr_ct = to_city.get(arr).toString();
        System.out.println(dep_ct+' '+arr_ct);

        CityMinPriListBean ret = cmpls.getCMPLM(dep_ct,arr_ct);
        String min_price_list = ret.getMin_price_list();

        List<JSONObject> Ans = new ArrayList<JSONObject>();

        int len = min_price_list.length();
        String t =  min_price_list.substring(2,len-2);
        String [] splt = t.split(",");
        for (int i = 0;i<splt.length ;i ++){
            int l = splt[i].length();
            String [] tplt = splt[i].substring(2,l-1).split("\\|");

            if( 0 <= tplt[0].compareTo(start)  && tplt[0].compareTo(end) <= 0 ){
                JSONObject ans = new JSONObject();
                ans.put("date",tplt[0]);
                ans.put("price",Integer.valueOf(tplt[1]));
                ans.put("line",tplt[2]);
                Ans.add(ans);
            }
        }
        Result r = new Result<>(true, 200, "", Ans);
        return r;
    }



}
