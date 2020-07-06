package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CompTimeBean;
import org.liberty.j.jagdtiger.mapper.CompTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompTimeService {
    @Autowired
    private CompTimeMapper ctm;
    public List<CompTimeBean> getCompanyArrTime(String c) throws Exception
    {
        List<CompTimeBean> x = ctm.getCompanyArrTime(c);
        Integer i  = 0;
        for(int j=0;j<24;j++){
            //Integer hr = Integer.parseInt(ctb.getClock().replaceFirst("^0*", ""));
            CompTimeBean ctb = x.get(i);
            Integer hr = 0;
            if(ctb.getClock().charAt(0) == '0'){
                hr = Integer.parseInt(ctb.getClock().substring(1));
            }
            else{
                hr = Integer.parseInt(ctb.getClock());
            }
            //System.out.println(hr.toString(hr));
            if(i != hr){
                CompTimeBean temp = new CompTimeBean();
                if(i < 10){
                    temp.setClock("0"+Integer.toString(i));
                }
                temp.setCompany(ctb.getCompany());
                temp.setLineNum(0);
                x.add(i, temp);
                i = i - 1;
            }
            i = i + 1;
        }
        // for (CompTimeBean ctb : x) {
        //     System.out.println(ctb.getCompany()+" : "+ctb.getClock()+" - "+ctb.getLineNum());
        // }
        return x;
    }
    public List<CompTimeBean> getCompanyDepTime(String c) throws Exception
    {
        List<CompTimeBean> x = ctm.getCompanyDepTime(c);
        Integer i  = 0;
        for(int j=0;j<24;j++){
            //Integer hr = Integer.parseInt(ctb.getClock().replaceFirst("^0*", ""));
            CompTimeBean ctb = x.get(i);
            Integer hr = 0;
            if(ctb.getClock().charAt(0) == '0'){
                hr = Integer.parseInt(ctb.getClock().substring(1));
            }
            else{
                hr = Integer.parseInt(ctb.getClock());
            }
            //System.out.println(hr.toString(hr));
            if(i != hr){
                CompTimeBean temp = new CompTimeBean();
                if(i < 10){
                    temp.setClock("0"+Integer.toString(i));
                }
                temp.setCompany(ctb.getCompany());
                temp.setLineNum(0);
                x.add(i, temp);
                i = i - 1;
            }
            i = i + 1;
        }
        // for (CompTimeBean ctb : x) {
        //     System.out.println(ctb.getCompany()+" : "+ctb.getClock()+" - "+ctb.getLineNum());
        // }
        return x;
    }
}