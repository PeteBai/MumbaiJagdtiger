package org.liberty.j.jagdtiger.ListSplit;

import org.liberty.j.jagdtiger.entity.GetProvinceConfirmedBean;

import java.util.ArrayList;
import java.util.List;

public class ListSplit {
    public static List<List<GetProvinceConfirmedBean>> splitList(List<GetProvinceConfirmedBean> oldList){
        List<List<GetProvinceConfirmedBean>> newList = new ArrayList<List<GetProvinceConfirmedBean>>();
        String date = new String();
        List<List<GetProvinceConfirmedBean>> tempList = new ArrayList<List<GetProvinceConfirmedBean>>();
        int i = 0;
        for(GetProvinceConfirmedBean item : oldList){
            //是同一天的数据
            if(tempList.isEmpty()){
                date = item.getDateId();
                tempList.add(new ArrayList<GetProvinceConfirmedBean>());
                tempList.get(i).add(item);
            }
            else if(date.equals(item.getDateId())){
                tempList.get(i).add(item);
                System.out.println(item.getDateId());
            }
            //遍历到了新一天的数据
            else{
                newList.add(tempList.get(i));
                i +=1;
                //tempList.clear();
                tempList.add(new ArrayList<GetProvinceConfirmedBean>());
                tempList.get(i).add(item);
                date = item.getDateId();
            }
        }
        return newList;
    }
    public static void main(String args[]){
        GetProvinceConfirmedBean t1 = new GetProvinceConfirmedBean("2020-01-30",5555,"北京");
        GetProvinceConfirmedBean t2 = new GetProvinceConfirmedBean("2020-01-30",5555,"上海");
        GetProvinceConfirmedBean t3 = new GetProvinceConfirmedBean("2020-01-30",5555,"四川");
        GetProvinceConfirmedBean t4 = new GetProvinceConfirmedBean("2020-01-31",6666,"北京");
        GetProvinceConfirmedBean t5 = new GetProvinceConfirmedBean("2020-01-31",6666,"上海");
        GetProvinceConfirmedBean t6 = new GetProvinceConfirmedBean("2020-01-31",6666,"四川");
        List<GetProvinceConfirmedBean> oldList = new ArrayList<GetProvinceConfirmedBean>();
        oldList.add(t1);
        oldList.add(t2);
        oldList.add(t3);
        oldList.add(t4);
        oldList.add(t5);
        oldList.add(t6);
        List<List<GetProvinceConfirmedBean>> newList = splitList(oldList);
        System.out.println(newList);
    }
}
