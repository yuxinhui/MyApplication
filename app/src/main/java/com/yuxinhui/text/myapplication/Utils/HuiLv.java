package com.yuxinhui.text.myapplication.Utils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/21.
 * 汇率实体类包含序号，时间以及汇率转、转换信息集合。
 */

public class HuiLv {
    private int status;

    private String date;

    private ArrayList<HuiLvData> data ;

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }
    public void setData(ArrayList<HuiLvData> data){
        this.data = data;
    }
    public ArrayList<HuiLvData> getData(){
        return this.data;
    }

    @Override
    public String toString() {
        return "HuiLv{" +
                "status=" + status +
                ", date='" + date + '\'' +
                '}';
    }
}
