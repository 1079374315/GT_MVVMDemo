package com.example.gt_mvvmdemo.all.ui.activity;

import android.os.Bundle;

import com.example.gt_mvvmdemo.R;
import com.example.gt_mvvmdemo.all.ui.fragment.FragmentA;
import com.example.gt_mvvmdemo.all.view_model.MainViewModel;
import com.gsls.gt.GT;
import com.gsls.gt_databinding.annotation.GT_DataBinding;

@GT_DataBinding(setLayout = "activity_main2", setBindingType = GT_DataBinding.Activity)
@GT.Annotations.GT_AnnotationActivity(R.layout.activity_main2)
public class MainActivity extends MainActivityBinding<MainViewModel> {

    @GT.GT_Fragment.Build(setClass = FragmentA.class, setLayoutMain = R.id.fl)
    public GT.GT_Fragment gt_fragment;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        GT.logs("viewModel:" + viewModel);
        if(viewModel != null){
            viewModel.show();
        }

    }

}
