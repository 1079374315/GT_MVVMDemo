package com.example.gt_mvvmdemo.all.view_model;

import android.view.View;

import com.example.gt_mvvmdemo.all.model.Model;
import com.example.gt_mvvmdemo.all.ui.dialog.DemoFragmentDialog;
import com.example.gt_mvvmdemo.all.ui.floating.DemoFloatingWindow;
import com.gsls.gt.GT;

/**
 * @Author PlayfulKing
 * @Date 2022/3/8 22:25
 * @CSDN https://blog.csdn.net/qq_39799899
 * @GitHub https://github.com/1079374315/GT
 * @Description:
 */
public class DialogFragmentViewModel extends GT.Frame.GT_BindingViewModel<DemoFragmentDialog, Model<?>> {

    @Override
    protected void loadData() {
        super.loadData();
        bindingView.tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingModel.show();
                try{
                    GT.startFloatingWindow(DemoFloatingWindow.class);
                }catch (Exception e){
                    GT.toast_s(bindingView.activity,"没有开启悬浮窗权限,请手动开启.");
                }
            }
        });
        bindingView.tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingView.finish();
            }
        });
    }
}
