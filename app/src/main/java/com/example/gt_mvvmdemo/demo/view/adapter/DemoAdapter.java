package com.example.gt_mvvmdemo.demo.view.adapter;

import android.content.Context;
import android.view.View;

import com.example.gt_mvvmdemo.R;
import com.example.gt_mvvmdemo.demo.model.bean.DemoBean;
import com.gsls.gt.GT;
import com.gsls.gt_databinding.annotation.GT_DataBinding;

/**
 * @Description: 继承使用GT生成的 AdapterBinding ,也可使用其他方式生成的适配器进行搭配
 */

@GT_DataBinding(setLayout = "item_demo", setBindingType = GT_DataBinding.Adapter)
@GT.Annotations.GT_AnnotationAdapter(R.layout.item_demo)
public class DemoAdapter extends DemoAdapterBinding<DemoBean> {

    public OnAdapterClick onAdapterClick;

    public DemoAdapter(Context context, OnAdapterClick onAdapterClick) {
        super(context);
        this.onAdapterClick = onAdapterClick;
    }

    @Override
    protected void initView(DemoAdapterViewHolder holder, View itemView, int position, DemoBean demoBean) {
        super.initView(holder, itemView, position, demoBean);
        holder.tv_1.setText(demoBean.getID() + " 号");
        holder.tv_2.setText(demoBean.getValue());
        holder.tv_3.setText(demoBean.getTime());

        //单击加载
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAdapterClick.onClick(demoBean);
            }
        });

        //长按操作
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onAdapterClick.onLongClick(demoBean);
                return true;
            }
        });

    }

    //添加一个单击与长按后 传递实体类 给 ViewModel处理 的演示
    public interface OnAdapterClick {
        void onClick(DemoBean demoBean);
        void onLongClick(DemoBean demoBean);
    }

}
