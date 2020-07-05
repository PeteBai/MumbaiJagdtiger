package org.liberty.j.jagdtiger.service;
import org.liberty.j.jagdtiger.entity.GetProvinceConfirmedBean;
import org.liberty.j.jagdtiger.mapper.GetProvinceConfirmedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GetProvinceConfirmedService{
    @Autowired
    private GetProvinceConfirmedMapper getProvinceConfirmedMapper;
    public List<GetProvinceConfirmedBean> queryProvinceConfirmed(){
        return getProvinceConfirmedMapper.getProvinceConfirmed();
    }

}
