package org.liberty.j.jagdtiger.controller;


import com.alibaba.fastjson.JSONObject;
import org.liberty.j.jagdtiger.Exception.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CityMinPriTimeController {

    String[] depl = {
            "    {'city': '乌鲁木齐', 'clock': '22.11', 'price': 895.8}" ,
            "    {'city': '大连', 'clock': '23.16', 'price': 432.71}" ,
            "    {'city': '南京', 'clock': '23.11', 'price': 450.68}" ,
            "    {'city': '海口', 'clock': '23.23', 'price': 578.21}" ,
            "    {'city': '沈阳', 'clock': '22.19', 'price': 410.76}" ,
            "    {'city': '福州', 'clock': '23.15', 'price': 506.17}" ,
            "    {'city': '昆明', 'clock': '23.17', 'price': 510.61}" ,
            "    {'city': '北京', 'clock': '23.14', 'price': 620.02}" ,
            "    {'city': '济南', 'clock': '23.16', 'price': 538.52}" ,
            "    {'city': '拉萨', 'clock': '23.45', 'price': 334.0}" ,
            "    {'city': '温州', 'clock': '23.22', 'price': 436.39}" ,
            "    {'city': '天津', 'clock': '23.18', 'price': 403.49}" ,
            "    {'city': '贵阳', 'clock': '23.19', 'price': 489.67}" ,
            "    {'city': '珠海', 'clock': '23.14', 'price': 570.52}" ,
            "    {'city': '呼和浩特', 'clock': '22.33', 'price': 470.42}" ,
            "    {'city': '长沙', 'clock': '22.22', 'price': 461.14}" ,
            "    {'city': '西安', 'clock': '05.50', 'price': 350.0}" ,
            "    {'city': '桂林', 'clock': '20.25', 'price': 436.45}" ,
            "    {'city': '武汉', 'clock': '06.30', 'price': 375.0}" ,
            "    {'city': '重庆', 'clock': '23.25', 'price': 457.62}" ,
            "    {'city': '长春', 'clock': '06.19', 'price': 492.42}" ,
            "    {'city': '石家庄', 'clock': '23.16', 'price': 459.51}" ,
            "    {'city': '无锡', 'clock': '23.13', 'price': 544.02}" ,
            "    {'city': '深圳', 'clock': '23.28', 'price': 627.0}" ,
            "    {'city': '厦门', 'clock': '22.20', 'price': 439.15}" ,
            "    {'city': '青岛', 'clock': '23.26', 'price': 468.02}" ,
            "    {'city': '扬州', 'clock': '08.26', 'price': 346.96}" ,
            "    {'city': '三亚', 'clock': '05.35', 'price': 615.0}" ,
            "    {'city': '合肥', 'clock': '22.25', 'price': 480.12}" ,
            "    {'city': '太原', 'clock': '01.05', 'price': 525.0}" ,
            "    {'city': '南昌', 'clock': '00.25', 'price': 483.25}" ,
            "    {'city': '杭州', 'clock': '23.18', 'price': 534.71}" ,
            "    {'city': '郑州', 'clock': '01.50', 'price': 415.0}" ,
            "    {'city': '广州', 'clock': '23.19', 'price': 668.46}" ,
            "    {'city': '兰州', 'clock': '21.28', 'price': 592.08}" ,
            "    {'city': '南宁', 'clock': '23.37', 'price': 429.24}" ,
            "    {'city': '银川', 'clock': '23.37', 'price': 517.68}" ,
            "    {'city': '上海', 'clock': '23.11', 'price': 581.39}" ,
            "    {'city': '西宁', 'clock': '06.37', 'price': 557.5}" ,
            "    {'city': '成都', 'clock': '23.21', 'price': 535.58}" ,
            "    {'city': '哈尔滨', 'clock': '23.34', 'price': 579.21}" ,
            "    {'city': '泉州', 'clock': '23.26', 'price': 308.7}"
    };



    String[] arrl = {
            "    {'city': '大连', 'clock': '07.55', 'price': 516.89}" ,
            "    {'city': '南京', 'clock': '08.40', 'price': 512.39}" ,
            "    {'city': '海口', 'clock': '08.29', 'price': 622.22}" ,
            "    {'city': '沈阳', 'clock': '07.55', 'price': 577.1}" ,
            "    {'city': '乌鲁木齐', 'clock': '01.24', 'price': 1179.55}" ,
            "    {'city': '北京', 'clock': '08.46', 'price': 660.4}" ,
            "    {'city': '福州', 'clock': '07.48', 'price': 277.25}" ,
            "    {'city': '昆明', 'clock': '07.34', 'price': 366.38}" ,
            "    {'city': '济南', 'clock': '08.34', 'price': 517.4}" ,
            "    {'city': '拉萨', 'clock': '08.38', 'price': 1079.21}" ,
            "    {'city': '温州', 'clock': '09.37', 'price': 560.9}" ,
            "    {'city': '珠海', 'clock': '07.33', 'price': 412.0}" ,
            "    {'city': '贵阳', 'clock': '08.42', 'price': 584.48}" ,
            "    {'city': '天津', 'clock': '08.35', 'price': 486.55}" ,
            "    {'city': '长沙', 'clock': '08.41', 'price': 409.54}" ,
            "    {'city': '呼和浩特', 'clock': '20.22', 'price': 665.96}" ,
            "    {'city': '西安', 'clock': '07.46', 'price': 388.35}" ,
            "    {'city': '青岛', 'clock': '08.32', 'price': 468.23}" ,
            "    {'city': '武汉', 'clock': '07.54', 'price': 405.24}" ,
            "    {'city': '重庆', 'clock': '07.52', 'price': 400.4}" ,
            "    {'city': '桂林', 'clock': '04.10', 'price': 415.0}" ,
            "    {'city': '长春', 'clock': '07.51', 'price': 506.67}" ,
            "    {'city': '深圳', 'clock': '08.35', 'price': 580.06}" ,
            "    {'city': '厦门', 'clock': '08.42', 'price': 529.5}" ,
            "    {'city': '无锡', 'clock': '08.41', 'price': 593.97}" ,
            "    {'city': '石家庄', 'clock': '08.45', 'price': 486.23}" ,
            "    {'city': '扬州', 'clock': '08.51', 'price': 270.0}" ,
            "    {'city': '三亚', 'clock': '09.23', 'price': 703.46}" ,
            "    {'city': '合肥', 'clock': '08.32', 'price': 529.3}" ,
            "    {'city': '太原', 'clock': '08.38', 'price': 537.63}" ,
            "    {'city': '南昌', 'clock': '09.27', 'price': 518.28}" ,
            "    {'city': '杭州', 'clock': '08.37', 'price': 547.86}" ,
            "    {'city': '兰州', 'clock': '07.35', 'price': 351.6}" ,
            "    {'city': '广州', 'clock': '08.34', 'price': 587.94}" ,
            "    {'city': '郑州', 'clock': '07.55', 'price': 250.0}" ,
            "    {'city': '南宁', 'clock': '07.50', 'price': 257.36}" ,
            "    {'city': '上海', 'clock': '08.42', 'price': 642.98}" ,
            "    {'city': '银川', 'clock': '07.45', 'price': 358.93}" ,
            "    {'city': '西宁', 'clock': '07.38', 'price': 296.43}" ,
            "    {'city': '成都', 'clock': '07.47', 'price': 368.39}" ,
            "    {'city': '哈尔滨', 'clock': '01.34', 'price': 815.68}" ,
            "    {'city': '泉州', 'clock': '09.17', 'price': 524.83}"
    };


    @RequestMapping(value = "/flight/getFliMinPriTime")
    public Result getFliMinPriTime(){
        JSONObject Ans = new JSONObject();

        List<JSONObject> depList = new ArrayList<JSONObject>();

        for(int i=0; i<depl.length ; i++){
            JSONObject cmsg = JSONObject.parseObject(depl[i]);
            JSONObject ret = new JSONObject();
            ret.put("city",cmsg.get("city"));
            ret.put("clock",cmsg.get("clock"));
            ret.put("price",cmsg.get("price"));
            depList.add(ret);
        }


        List<JSONObject> arrList = new ArrayList<JSONObject>();

        for(int i=0; i<arrl.length ; i++){
            JSONObject cmsg = JSONObject.parseObject(arrl[i]);
            JSONObject ret = new JSONObject();
            ret.put("city",cmsg.get("city"));
            ret.put("clock",cmsg.get("clock"));
            ret.put("price",cmsg.get("price"));
            arrList.add(ret);
        }

        Ans.put("dep",depList);
        Ans.put("arr",arrList);

        Result r = new Result<>(true, 200, "", Ans);
        return r;

    }


}
