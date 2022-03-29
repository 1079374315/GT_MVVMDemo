package com.example.gt_mvvmdemo.all.ui.popupwindow;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

import com.example.gt_mvvmdemo.R;
import com.example.gt_mvvmdemo.all.view_model.DemoPop_ViewModel;
import com.gsls.gt.GT;
import com.gsls.gt_databinding.annotation.GT_DataBinding;

/**
 * @Author PlayfulKing
 * @Date 2022/3/17 21:04
 * @CSDN https://blog.csdn.net/qq_39799899
 * @GitHub https://github.com/1079374315/GT
 * @Description:
 */
@GT_DataBinding(setLayout = "item_pop",setBindingType = GT_DataBinding.PopupWindow)
@GT.Annotations.GT_AnnotationPopupWindow(R.layout.item_pop)
public class DemoPopupWindow extends DemoPopupWindowBinding<DemoPop_ViewModel> {

    public DemoPopupWindow(Context context) {
        super(context);
    }

    @Override
    protected void initView(View view, PopupWindow popWindow) {
        super.initView(view, popWindow);
        GT.logs("viewModel:" + viewModel);
    }
}
