package com.example.gt_mvvmdemo.demo.model;

import com.example.gt_mvvmdemo.demo.model.bean.DemoBean;
import com.gsls.gt.GT;

import java.util.List;

/**
 * @Description:负责数据(网络请求/数据库)逻辑处理
 */
public class Model<T> extends GT.Frame.GT_Model<T> {

    //数据库管理对象
    private GT.Hibernate hibernate;

    public void setHibernate(GT.Hibernate hibernate) {
        this.hibernate = hibernate;
    }

    //添加一条数据
    public boolean add(String value) {
        DemoBean demoBean = new DemoBean();
        demoBean.setValue(value.length() == 0 ? "空白" : value);
        demoBean.setTime(GT.GT_Date.getDateTime_CH());
        return hibernate.save(demoBean)//保存该实体类
                .isStatus();//返回本次操作状态
    }

    //删除一条数据
    public boolean delete(int id) {
        return hibernate.delete(DemoBean.class, id)//删除单条数据
                .isStatus();//返回本次操作状态
    }

    //清空所有数据
    public boolean clearAll() {
        return hibernate.deleteAll(DemoBean.class)//删除所有数据
                .isStatus();//返回本次操作状态
    }

    //查询所有数据
    public List<DemoBean> queryAll() {
        return hibernate.flashback("ID")//按照ID倒序
                .queryAll(DemoBean.class);//查询返回
    }

    public void show(){
        GT.logt("调用了 Model 里的show");
    }

}
