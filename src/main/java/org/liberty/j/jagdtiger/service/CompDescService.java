package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CompDescBean;
import org.liberty.j.jagdtiger.mapper.CompDescMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompDescService {
    @Autowired
    private CompDescMapper cdm;
    public List<CompDescBean> queryAllCD() throws Exception
    {
        return cdm.getAllCDB();
    }
}