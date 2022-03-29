package com.example.gt_mvvmdemo.demo.model.bean;

import com.gsls.gt.GT;


@GT.Hibernate.GT_Bean//标识扫描
public class DemoBean {

    @GT.Hibernate.GT_Key
    private int ID;//定义主键

    private String time;    //时间
    private String value;   //词条

    public int getID() {
        return ID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DemoBean{" +
                "ID=" + ID +
                ", time='" + time + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
