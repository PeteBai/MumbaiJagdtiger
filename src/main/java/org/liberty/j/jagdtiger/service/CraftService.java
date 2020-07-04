package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CraftBean;
import org.liberty.j.jagdtiger.mapper.CraftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CraftService {
    @Autowired
    private CraftMapper cm;
    public List<CraftBean> queryAllC()
    {
        return cm.getAllCB();
    }
}