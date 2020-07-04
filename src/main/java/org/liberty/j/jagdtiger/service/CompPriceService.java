package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CompPriceBean;
import org.liberty.j.jagdtiger.mapper.CompPriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompPriceService {
    @Autowired
    private CompPriceMapper cpm;
    public List<CompPriceBean> queryAllCP()
    {
        return cpm.getAllCAP();
    }
}