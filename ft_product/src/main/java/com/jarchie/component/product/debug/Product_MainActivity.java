package com.jarchie.component.product.debug;

import com.jarchie.component.product.ProductFragment;
import com.jarchie.component.product.R;
import com.jarchie.library.base.BaseActivity;

/**
 * 作者: 乔布奇
 * 日期: 2020-09-07 20:31
 * 邮箱: jarchie520@gmail.com
 * 描述: 产品模块测试主页
 */
public class Product_MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.product_activity_main;
    }

    @Override
    protected void initView() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mContent,new ProductFragment())
                .commit();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
