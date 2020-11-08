package com.jarchie.component.order.debug;

import com.jarchie.component.order.OrderFragment;
import com.jarchie.component.order.R;
import com.jarchie.library.base.BaseActivity;

/**
 * 作者: 乔布奇
 * 日期: 2020-09-07 20:31
 * 邮箱: jarchie520@gmail.com
 * 描述: 订单模块测试主页测试主页
 */
public class Order_MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.order_activity_main;
    }

    @Override
    protected void initView() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mContent,new OrderFragment())
                .commit();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
