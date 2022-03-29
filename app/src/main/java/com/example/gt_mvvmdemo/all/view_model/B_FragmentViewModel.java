package com.example.gt_mvvmdemo.all.view_model;

import android.view.View;

import com.example.gt_mvvmdemo.all.model.Model;
import com.example.gt_mvvmdemo.all.ui.dialog.DemoFragmentDialog;
import com.example.gt_mvvmdemo.all.ui.fragment.FragmentB;
import com.example.gt_mvvmdemo.all.ui.view.DemoView;
import com.gsls.gt.GT;

/**
 * @Author PlayfulKing
 * @Date 2022/3/8 22:25
 * @CSDN https://blog.csdn.net/qq_39799899
 * @GitHub https://github.com/1079374315/GT
 * @Description:
 */
public class B_FragmentViewModel extends GT.Frame.GT_BindingViewModel<FragmentB, Model<?>> {

    @Override
    protected void initView() {
        super.initView();
        bindingView.tv_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindingModel.show();
                GT.startDialogFragment(DemoFragmentDialog.newInstance("你好"), bindingView.getFragmentManager());
            }
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
        loadView();
    }


    private void loadView() {
        GT.Thread.runJava(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 50; i++) {
                    DemoView demoView = new DemoView(bindingView.activity);
                    demoView.setIndex(i);
                    GT.Thread.runAndroid(new Runnable() {
                        @Override
                        public void run() {
                            bindingView.ll.addView(demoView.getView());
                        }
                    });
                    GT.Thread.sleep(10);
                }

            }
        });
    }

}
