package com.example.gt_mvvmdemo.demo.view_model;

import android.content.Intent;
import android.view.View;

import com.example.gt_mvvmdemo.R;
import com.example.gt_mvvmdemo.demo.model.Model;
import com.example.gt_mvvmdemo.demo.model.bean.DemoBean;
import com.example.gt_mvvmdemo.demo.view.activity.MainActivity;
import com.example.gt_mvvmdemo.demo.view.adapter.DemoAdapter;
import com.gsls.gt.GT;

/**
 * @Description:负责业务逻辑处理
 */
public class MainViewModel
        extends GT.Frame.GT_BindingViewModel<MainActivity, Model<?>>
        implements DemoAdapter.OnAdapterClick {

    private DemoAdapter demoAdapter;//适配器

    @Override
    protected void initView() {
        super.initView();
        //初始化并
        demoAdapter = new DemoAdapter(bindingView, this);
        //设置适配器显示为垂直布局
        demoAdapter.setLinearLayoutManager_V(bindingView.rv);
    }

    //处理单击事件
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                //保存数据,若 保存成功 则 刷新数据
                if (bindingModel.add(bindingView.et_data.getText().toString())) {
                    demoAdapter.setBeanList(bindingModel.queryAll());//刷新数据
                    GT.toast_s(bindingView, "添加成功");
                }
                break;
            case R.id.btn_clear:
                //清空数据,若 清空成功 则 刷新数据
                if (bindingModel.clearAll()) {
                    demoAdapter.setBeanList(bindingModel.queryAll());//刷新数据
                    GT.toast_s(bindingView, "清空成功");
                }
                break;

            case R.id.btn_start2:
                //跳转 MainActivity2
                bindingView.startActivity(new Intent(bindingView, com.example.gt_mvvmdemo.all.ui.activity.MainActivity.class));
                break;
        }
    }

    @Override
    public void onClick(DemoBean demoBean) {
        GT.logt("来自适配器 item 的单击:" + demoBean);
    }

    @Override
    public void onLongClick(DemoBean demoBean) {
        GT.logt("来自适配器 item 的长按:" + demoBean);
        //使用GT库自带的 对话框
        new GT.GT_Dialog.GT_AlertDialog(bindingView)
                .dialogTwoButton(R.drawable.ic_launcher_background,
                        "长按提示", "是否删除该条数据?",
                        true, "确定", (dialogInterface, i) -> {
                            if (bindingModel.delete(demoBean.getID())) {
                                demoAdapter.setBeanList(bindingModel.queryAll());//刷新数据
                                GT.toast_s(bindingView, "删除成功");
                            }
                        }, "取消", (dialogInterface, i) -> {

                        }).show();
    }

    //将数据库对象给到 Model 管理
    public void setHibernate(GT.Hibernate hibernate) {
        bindingModel.setHibernate(hibernate);//这里赋值后 Model 里的 hibernate 才能工作
        demoAdapter.setBeanList(bindingModel.queryAll());//加载数据
    }

}
