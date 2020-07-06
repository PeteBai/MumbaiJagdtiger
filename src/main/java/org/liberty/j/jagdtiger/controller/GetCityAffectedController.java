package org.liberty.j.jagdtiger.controller;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.GetCityAffectedBean;
import org.liberty.j.jagdtiger.service.GetCityAffectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
public class GetCityAffectedController {
    @Autowired
    private GetCityAffectedService getCityAffectedService;
    @RequestMapping(value = "/corona/getAffected")
    public Result getCityAffectedMsg(@RequestParam String city){
        Result re = new Result();
        try{
        String province = new String();
        Map<String,String> m = new HashMap<String,String>();
        m.put("无锡","江苏"); m.put("长沙","湖南"); m.put("大连","福建");m.put("桂林","广西");m.put("西安","陕西");
        m.put("南京","江苏"); m.put("沈阳","辽宁"); m.put("扬州","江苏");m.put("成都","四川");m.put("杭州","浙江");
        m.put("昆明","云南"); m.put("天津","天津"); m.put("兰州","甘肃");m.put("太原","山西");m.put("郑州","河南");
        m.put("青岛","山东"); m.put("福州","福建"); m.put("厦门","福建");m.put("济南","山东");m.put("泉州","福建");
        m.put("珠海","广东"); m.put("合肥","安徽"); m.put("石家庄","河北");m.put("银川","宁夏");m.put("重庆","重庆");
        m.put("深圳","广东"); m.put("西宁","青海"); m.put("呼和浩特","内蒙古");m.put("三亚","海南");m.put("南昌","江西");
        m.put("温州","浙江"); m.put("拉萨","西藏"); m.put("贵阳","贵州");m.put("哈尔滨","黑龙江");m.put("上海","上海");
        m.put("海口","海南"); m.put("长春","吉林"); m.put("乌鲁木齐","新疆");m.put("南宁","广西");m.put("北京","陕西");
        m.put("广州","广东"); m.put("武汉","湖北");
        province = m.get(city);
        //System.out.println(province);
        re.setSuccess(true);
        re.setCode(200);
        List<GetCityAffectedBean> list = getCityAffectedService.queryCityAffected(province);
        list.get(list.size() - 1).setDateId("2020-6-20");
        re.setData(list);
        }
        catch(Exception e){
            re.setSuccess(false);
            e.printStackTrace();
        }
        return re;
    }
}
