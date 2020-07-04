package org.liberty.j.jagdtiger.service;

import java.util.List;

import org.liberty.j.jagdtiger.entity.CompCraftBean;
import org.liberty.j.jagdtiger.mapper.CompCraftMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompCraftService {
    @Autowired
    private CompCraftMapper ccm;
    public List<CompCraftBean> queryAllCC() throws Exception
    {
        return ccm.getAllCCB();
    }
}