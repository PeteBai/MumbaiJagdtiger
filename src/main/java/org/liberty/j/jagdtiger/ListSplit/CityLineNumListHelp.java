package org.liberty.j.jagdtiger.ListSplit;

import com.google.gson.JsonObject;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;
import org.liberty.j.jagdtiger.entity.CityLineNumBean;
import org.liberty.j.jagdtiger.entity.CityLineNumSizeBean;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CityLineNumListHelp {
    public static List<List<CityLineNumSizeBean>> lineSplit( List<CityLineNumBean> oldList ){
        List<List<CityLineNumSizeBean>> newList = new ArrayList<List<CityLineNumSizeBean>>();
        CityLineNumSizeBean cityLineNumSize;
        //一次循环遍历同一天的数据
        for (CityLineNumBean item:oldList){
            //CityLineNumSizeBean cityLineNumSizeBean = new CityLineNumSizeBean();
            String line = item.getJsonStr();
            String[] city_linenumList = line.split(",");
            //city_linenum为city：linenum形式
            //同一天中的多组数据,先不计算size
            Integer max = 0;
            Integer min = 1000000;
            List<CityLineNumSizeBean> CityLineNumSizePerDay = new ArrayList<CityLineNumSizeBean>();
            for(String city_linenum : city_linenumList){
                //System.out.println("一组：");
                //System.out.println(city_linenum);
                CityLineNumSizeBean cityLineNumSizeBean = new CityLineNumSizeBean();
                String[] temp = city_linenum.split("\'");

                cityLineNumSizeBean.setName(temp[1]);
                Integer linenum = Integer.valueOf(temp[2].split(":")[1].split("}")[0].substring(1));
                cityLineNumSizeBean.setLinenum(linenum);
                //System.out.println(temp[1]);
                //System.out.println(temp[2].split(":")[1]);
                CityLineNumSizePerDay.add(cityLineNumSizeBean);
                if(linenum > max){
                    max = linenum;
                }
                if(linenum < min){
                    min = linenum;
                }
            }
            //对同一天中的数据计算size
            for(CityLineNumSizeBean item2:CityLineNumSizePerDay){
                item2.setSize(20 * (item2.getLinenum() - min)/(max - min) + 10);
            }
            newList.add(CityLineNumSizePerDay);
        }
        return newList;
    }

    public static void main(String args[]){

    }
}
