package com.example.gt_mvvmdemo.all.view_model;

import android.view.View;

import com.example.gt_mvvmdemo.all.model.Model;
import com.example.gt_mvvmdemo.all.ui.popupwindow.DemoPopupWindow;
import com.example.gt_mvvmdemo.all.ui.view.DemoView;
import com.gsls.gt.GT;

/**
 * @Author PlayfulKing
 * @Date 2022/3/8 22:25
 * @CSDN https://blog.csdn.net/qq_39799899
 * @GitHub https://github.com/1079374315/GT
 * @Description:
 */
public class DemoView_ViewModel extends GT.Frame.GT_BindingViewModel<DemoView, Model<?>> {

    @Override
    protected void initView() {
        super.initView();
        bindingView.tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GT.toast_s(bindingView.context, bindingView.tv_1.getText().toString());
                bindingModel.show();
                new DemoPopupWindow(bindingView.context).startPopupWindowBelow(v);
            }
        });
    }
}
