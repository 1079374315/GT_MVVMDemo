package com.example.gt_mvvmdemo.all.ui.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.gt_mvvmdemo.R;
import com.example.gt_mvvmdemo.all.view_model.A_FragmentViewModel;
import com.gsls.gt.GT;
import com.gsls.gt_databinding.annotation.GT_DataBinding;

/**
 * @Author PlayfulKing
 * @Date 2022/3/8 21:54
 * @CSDN https://blog.csdn.net/qq_39799899
 * @GitHub https://github.com/1079374315/GT
 * @Description:
 */
@GT_DataBinding(setLayout = "fragment_a", setBindingType = GT_DataBinding.Fragment)
@GT.Annotations.GT_AnnotationFragment(R.layout.fragment_a)
public class FragmentA extends FragmentABinding {

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        bindingViewModel(new A_FragmentViewModel(this));
        GT.logs("viewModel:" + viewModel);
    }

    @Override
    protected boolean onBackPressed() {
        GT.logt("θΏεηε¬ FragmentA");
        return true;
    }
}
