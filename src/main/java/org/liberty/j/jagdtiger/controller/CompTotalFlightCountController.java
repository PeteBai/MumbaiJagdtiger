package org.liberty.j.jagdtiger.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.liberty.j.jagdtiger.entity.CompDescBean;
import org.liberty.j.jagdtiger.service.CompDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompTotalFlightCountController {
    @Autowired
    private CompDescService cds;
    @RequestMapping(value = "/company/getCompanyTotalFlightCount")
    public List<CompDescBean> getCDMsg() throws Exception
    {
        return cds.queryAllCD();
    }
    @RequestMapping(value = "/dashboard/getCompanyFlightCount")
    public List<CompCount> getCompCount() throws Exception
    {
        List<CompDescBean> cdbs = cds.queryAllCD();
        List<CompCount> ret = new ArrayList<>();
        for (CompDescBean cdb : cdbs) {
            ret.add(new CompCount(cdb.getComp_name(), cdb.getNum()));
        }
        Collections.sort(ret);
        ret = ret.subList(0, 6);
        return ret;
    }
}

class CompCount implements Comparable<CompCount>
{
    String Company;
    Integer AirlinesCount;
    public CompCount(String co, Integer ac)
    {
        this.Company = co;
        this.AirlinesCount = ac;
        //System.out.println(this.Company);
    }
    public Integer getAirlinesCount() {
        return AirlinesCount.intValue();
    }
    public void setAirlinesCount(Integer i)
    {
        this.AirlinesCount = i;
    } 
    @Override
    public int compareTo(CompCount cc)
    {
        if(this.AirlinesCount >= cc.getAirlinesCount())
        {
            return -1;
        }
        return 1;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }
}