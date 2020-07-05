package org.liberty.j.jagdtiger.service;

import java.util.List;
import org.liberty.j.jagdtiger.entity.GetCityAffectedBean;
import org.liberty.j.jagdtiger.mapper.GetTotalAffectedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class GetTotalAffectedService {
    @Autowired
    private GetTotalAffectedMapper getTotalAffectedMapper;
    public List<GetCityAffectedBean> queryTotalAffected(){
        return getTotalAffectedMapper.getTotalAffectedNum();
    }
}
