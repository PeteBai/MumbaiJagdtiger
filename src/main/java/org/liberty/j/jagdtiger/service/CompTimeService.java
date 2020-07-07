package org.liberty.j.jagdtiger.service;

import java.util.ArrayList;
import java.util.List;

import org.liberty.j.jagdtiger.entity.CompTimeBean;
import org.liberty.j.jagdtiger.mapper.CompTimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompTimeService {
    @Autowired
    private CompTimeMapper ctm;

    public List<CompTimeBean> getCompanyArrTime(String c) throws Exception {
        List<CompTimeBean> x = ctm.getCompanyArrTime(c);
        String comp = x.get(0).getCompany();
        for (int j = 0; j < 24; j++) {
            // Integer hr = Integer.parseInt(ctb.getClock().replaceFirst("^0*", ""));
            Integer sz = x.size();
            CompTimeBean ctb = new CompTimeBean();
            if (j < x.size()) {
                ctb = x.get(j);
                //System.out.println("j: " + j + ", clk: " + ctb.getClock() + ", size: " + sz.toString(sz));
                Integer hr = 0;
                if (ctb.getClock().charAt(0) == '0') {
                    hr = Integer.parseInt(ctb.getClock().substring(1));
                } else {
                    hr = Integer.parseInt(ctb.getClock());
                }
                // System.out.println(hr.toString(hr));
                if (j != hr) {
                    CompTimeBean temp = new CompTimeBean();
                    if (j < 10) {
                        temp.setClock("0" + Integer.toString(j));
                    } else {
                        temp.setClock(Integer.toString(j));
                    }
                    temp.setCompany(ctb.getCompany());
                    temp.setLineNum(0);
                    x.add(j, temp);
                    j = j - 1;
                }
                // for (CompTimeBean ctbcc : x) {
                //     System.out.println(ctbcc.getCompany() + " : " + ctbcc.getClock() + " - " + ctbcc.getLineNum());
                // }
            } else {
                //System.out.println("j: " + j + ", clk: " + ctb.getClock() + ", size: " + sz.toString(sz));
                CompTimeBean temp = new CompTimeBean();
                if (j < 10) {
                    temp.setClock("0" + Integer.toString(j));
                } else {
                    temp.setClock(Integer.toString(j));
                }
                temp.setCompany(comp);
                temp.setLineNum(0);
                x.add(j, temp);
            }
        }
        return x;
    }

    public List<CompTimeBean> getCompanyDepTime(String c) throws Exception {
        List<CompTimeBean> x = ctm.getCompanyDepTime(c);
        String comp = x.get(0).getCompany();
        for (int j = 0; j < 24; j++) {
            // Integer hr = Integer.parseInt(ctb.getClock().replaceFirst("^0*", ""));
            Integer sz = x.size();
            CompTimeBean ctb = new CompTimeBean();
            if (j < x.size()) {
                ctb = x.get(j);
                //System.out.println("j: " + j + ", clk: " + ctb.getClock() + ", size: " + sz.toString(sz));
                Integer hr = 0;
                if (ctb.getClock().charAt(0) == '0') {
                    hr = Integer.parseInt(ctb.getClock().substring(1));
                } else {
                    hr = Integer.parseInt(ctb.getClock());
                }
                // System.out.println(hr.toString(hr));
                if (j != hr) {
                    CompTimeBean temp = new CompTimeBean();
                    if (j < 10) {
                        temp.setClock("0" + Integer.toString(j));
                    } else {
                        temp.setClock(Integer.toString(j));
                    }
                    temp.setCompany(ctb.getCompany());
                    temp.setLineNum(0);
                    x.add(j, temp);
                    j = j - 1;
                }
                for (CompTimeBean ctbcc : x) {
                    System.out.println(ctbcc.getCompany() + " : " + ctbcc.getClock() + " - " + ctbcc.getLineNum());
                }
            } else {
                //System.out.println("j: " + j + ", clk: " + ctb.getClock() + ", size: " + sz.toString(sz));
                CompTimeBean temp = new CompTimeBean();
                if (j < 10) {
                    temp.setClock("0" + Integer.toString(j));
                } else {
                    temp.setClock(Integer.toString(j));
                }
                temp.setCompany(comp);
                temp.setLineNum(0);
                x.add(j, temp);
            }
        }
        return x;
    }
}