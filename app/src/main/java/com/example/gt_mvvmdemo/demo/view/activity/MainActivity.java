package com.example.gt_mvvmdemo.demo.view.activity;

import android.os.Bundle;
import android.view.View;

import com.example.gt_mvvmdemo.R;
import com.example.gt_mvvmdemo.demo.view_model.MainViewModel;
import com.gsls.gt.GT;
import com.gsls.gt_databinding.annotation.GT_DataBinding;

@GT_DataBinding(setLayout = "activity_main", setBindingType = GT_DataBinding.Activity)
@GT.Annotations.GT_AnnotationActivity(R.layout.activity_main)
public class MainActivity extends MainActivityBinding<MainViewModel> {

    @GT.Hibernate.Build
    private GT.Hibernate hibernate;//构建数据库对象

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        viewModel.setHibernate(hibernate);//将数据库对象给到 ViewModel 处理
    }

    //注册 单击事件
    @GT.Annotations.GT_Click({R.id.btn_add, R.id.btn_clear, R.id.btn_start2,})
    public void onClick(View view) {
        viewModel.onClick(view);//将单击事件交给 ViewModel处理
    }

}