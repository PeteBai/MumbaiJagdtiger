package org.liberty.j.jagdtiger.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CityFlightBean;
import org.liberty.j.jagdtiger.service.CityFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CityFlightController {
    @Autowired
    private CityFlightService cfs;
    @RequestMapping(value = "/dashboard/mainMap")
    public Result getCityPairsCount() throws Exception
    {
        List<String> cities = Arrays.asList("北京","长春","重庆","长沙","成都","石家庄",
        "广州","贵阳","桂林","海口","呼和浩特","三亚",
        "哈尔滨","济南","昆明","兰州","拉萨","武汉",
        "南宁","泉州","青岛","上海","沈阳","郑州",
        "深圳","天津","太原","乌鲁木齐","温州","珠海",
        "西安","厦门","西宁","银川","扬州","无锡",
        "大连","福州","合肥","杭州","南昌","南京");
        Map m = new HashMap<String, byDepCt>();
        for (String dep : cities) {
            Integer total = 0;
            List<CityFlightBean> cfbs = new ArrayList<>();
            for (String arr : cities) {
                if(dep != arr){
                    System.out.println(dep+"-"+arr);
                    CityFlightBean cfb = cfs.getCityFlightCount(arr, dep);
                    if(cfb.getLines() != 0){
                        total += cfb.getLines();
                        cfbs.add(cfb);
                    }
                } 
            }
            m.put(dep, new byDepCt(total, cfbs));
        }
        Result r = new Result<>(true, 200, "", m);
        return r;
    }
}

class byDepCt
{
    Integer total;
    List<CityFlightBean> lines;
    public byDepCt(){}
    public byDepCt(Integer total, List<CityFlightBean> lines)
    {
        this.total = total;
        this.lines = lines;
    }
    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<CityFlightBean> getLines() {
        return lines;
    }

    public void setLines(List<CityFlightBean> lines) {
        this.lines = lines;
    }
}