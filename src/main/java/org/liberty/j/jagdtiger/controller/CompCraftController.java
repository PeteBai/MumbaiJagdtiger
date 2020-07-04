package org.liberty.j.jagdtiger.controller;

import java.util.ArrayList;
import java.util.List;

import org.liberty.j.jagdtiger.Exception.Result;
import org.liberty.j.jagdtiger.entity.CompCraftBean;
import org.liberty.j.jagdtiger.entity.CraftBean;
import org.liberty.j.jagdtiger.service.CompCraftService;
import org.liberty.j.jagdtiger.service.CraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CompCraftController {
    @Autowired
    private CompCraftService ccs;
    @Autowired
    private CraftService cs;
    @RequestMapping(value = "/company/getCompanyCraftInfo")
    public Result getCCMsg() throws Exception
    {
        List<CompCraftBean> t = ccs.queryAllCC();
        Result r = new Result<>(true, 200, "", t);
        return r;
    }
    @RequestMapping(value="/planes/getPlaneCompanyAndTypesInfo", method=RequestMethod.GET)
    public Result getCompCraftInfo(@RequestParam String companyName) throws Exception
    {
        List<CompCraftBean> tc = ccs.queryCompanyCC(companyName);
        //System.out.println(companyName);
        DataProcess dp = new DataProcess();
        List<byCompany> t = dp.CompCraftProcess(tc);
        Result r = new Result<>(true, 200, "", t);
        return r;
    }
    @RequestMapping(value = "/plane/getPlanesIntroductions")
    public Result getCMsg() throws Exception
    {
        List<CraftBean> t = cs.queryAllC();
        Result r = new Result<>(true, 200, "", t);
        return r;
    }
}

class DataProcess
{
    public List<byCompany> CompCraftProcess(List<CompCraftBean> l)
    {
        //未知机型 空中客机公司 中国商用飞机有限责任公司 加拿大庞巴迪宇航集团 巴西航空工业公司 波音公司 西安飞机工业（集团）有限责任公司
        List<CompCraftBean> Boeing = new ArrayList<>();
        List<CompCraftBean> Airbus = new ArrayList<>();
        List<CompCraftBean> Brazil = new ArrayList<>();
        List<CompCraftBean> Canada = new ArrayList<>();
        List<CompCraftBean> China = new ArrayList<>();
        List<CompCraftBean> Xian = new ArrayList<>();
        List<CompCraftBean> Jet = new ArrayList<>();
        for (CompCraftBean c : l) {
            String comp = c.getCraftCompany();
            switch (comp) {
                case "波音公司":
                    Boeing.add(c);
                    break;
                case "空中客机公司":
                    Airbus.add(c);
                    break;
                case "加拿大庞巴迪宇航集团":
                    Canada.add(c);
                    break;
                case "巴西航空工业公司":
                    Brazil.add(c);
                    break;
                case "中国商用飞机有限责任公司":
                    China.add(c);
                    break;
                case "西安飞机工业（集团）有限责任公司":
                    Xian.add(c);
                    break;
                case "未知机型":
                    Jet.add(c);
                    break;
            
                default:
                    System.out.println("problem of craft occured.");
                    break;
            }
        }
        Integer allTotal = 0;
        for (CompCraftBean c : l) {
            allTotal += c.getNum();
        }
        List<byCompany> ret = new ArrayList<>();
        if(!Boeing.isEmpty())
        {
            Integer total = 0;
            List<byModel> b = new ArrayList<>();
            for (CompCraftBean c : Boeing) {
                total += c.getNum();
            }
            for (CompCraftBean c : Boeing){
                if((double)c.getNum()/total < 0.01)
                    continue;
                b.add(new byModel(c.getCraftFamily(), c.getNum(), Double.parseDouble(String.format("%.2f", (double)c.getNum()/total))));
            }
            if((double)total/allTotal > 0.01)
                ret.add(new byCompany(Boeing.get(0).getCraftCompany(), total, Double.parseDouble(String.format("%.2f", (double)total/allTotal)), b));
        }
        if(!Airbus.isEmpty())
        {
            Integer total = 0;
            List<byModel> b = new ArrayList<>();
            for (CompCraftBean c : Airbus) {
                total += c.getNum();
            }
            for (CompCraftBean c : Airbus){
                if((double)c.getNum()/total < 0.01)
                    continue;
                b.add(new byModel(c.getCraftFamily(), c.getNum(), Double.parseDouble(String.format("%.2f", (double)c.getNum()/total))));
            }
            if((double)total/allTotal > 0.01)
                ret.add(new byCompany(Airbus.get(0).getCraftCompany(), total, Double.parseDouble(String.format("%.2f", (double)total/allTotal)), b));
        }
        if(!Canada.isEmpty())
        {
            Integer total = 0;
            List<byModel> b = new ArrayList<>();
            for (CompCraftBean c : Canada) {
                total += c.getNum();
            }
            for (CompCraftBean c : Canada){
                if((double)c.getNum()/total < 0.01)
                    continue;
                b.add(new byModel(c.getCraftFamily(), c.getNum(), Double.parseDouble(String.format("%.2f", (double)c.getNum()/total))));
            }
            if((double)total/allTotal > 0.01)
                ret.add(new byCompany(Canada.get(0).getCraftCompany(), total, Double.parseDouble(String.format("%.2f", (double)total/allTotal)), b));
        }
        if(!Brazil.isEmpty())
        {
            Integer total = 0;
            List<byModel> b = new ArrayList<>();
            for (CompCraftBean c : Brazil) {
                total += c.getNum();
            }
            for (CompCraftBean c : Brazil){
                if((double)c.getNum()/total < 0.01)
                    continue;
                b.add(new byModel(c.getCraftFamily(), c.getNum(), Double.parseDouble(String.format("%.2f", (double)c.getNum()/total))));
            }
            if((double)total/allTotal > 0.01)
                ret.add(new byCompany(Brazil.get(0).getCraftCompany(), total, Double.parseDouble(String.format("%.2f", (double)total/allTotal)), b));
        }
        if(!China.isEmpty())
        {
            Integer total = 0;
            List<byModel> b = new ArrayList<>();
            for (CompCraftBean c : China) {
                total += c.getNum();
            }
            for (CompCraftBean c : China){
                if((double)c.getNum()/total < 0.01)
                    continue;
                b.add(new byModel(c.getCraftFamily(), c.getNum(), Double.parseDouble(String.format("%.2f", (double)c.getNum()/total))));
            }
            if((double)total/allTotal > 0.01)
                ret.add(new byCompany(China.get(0).getCraftCompany(), total, Double.parseDouble(String.format("%.2f", (double)total/allTotal)), b));
        }
        if(!Xian.isEmpty())
        {
            Integer total = 0;
            List<byModel> b = new ArrayList<>();
            for (CompCraftBean c : Xian) {
                total += c.getNum();
            }
            for (CompCraftBean c : Xian){
                if((double)c.getNum()/total < 0.01)
                    continue;
                b.add(new byModel(c.getCraftFamily(), c.getNum(), Double.parseDouble(String.format("%.2f", (double)c.getNum()/total))));
            }
            if((double)total/allTotal > 0.01)
                ret.add(new byCompany(Xian.get(0).getCraftCompany(), total, Double.parseDouble(String.format("%.2f", (double)total/allTotal)), b));
        }
        if(!Jet.isEmpty())
        {
            Integer total = 0;
            List<byModel> b = new ArrayList<>();
            for (CompCraftBean c : Jet) {
                total += c.getNum();
            }
            for (CompCraftBean c : Jet){
                if((double)c.getNum()/total < 0.01)
                    break;
                b.add(new byModel(c.getCraftFamily(), c.getNum(), Double.parseDouble(String.format("%.2f", (double)c.getNum()/total))));
            }
            if((double)total/allTotal > 0.01)
                ret.add(new byCompany(Jet.get(0).getCraftCompany(), total, Double.parseDouble(String.format("%.2f", (double)total/allTotal)), b));
        }
        return ret;
    }
}

class byModel
{
   String item;
   Integer count;
   Double percent;
   public byModel(){}
   public byModel(String item, Integer count, Double percent)
   {
        this.item = item;
        this.count = count;
        this.percent = percent;
   }
   public String getItem() {
       return item;
   }

   public void setItem(String item) {
       this.item = item;
   }

   public Integer getCount() {
       return count;
   }

   public void setCount(Integer count) {
       this.count = count;
   }

   public Double getPercent() {
       return percent;
   }

   public void setPercent(Double percent) {
       this.percent = percent;
   }
}

class byCompany
{
    String item;
    Integer count;
    Double percent;
    List<byModel> planes;
    public byCompany(){}
    public byCompany(String item, Integer count, Double percent, List<byModel> l)
    {
        this.item = item;
        this.count = count;
        this.percent = percent;
        this.planes = l;
    }
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public List<byModel> getPlanes() {
        return planes;
    }

    public void setPlanes(List<byModel> planes) {
        this.planes = planes;
    }
}