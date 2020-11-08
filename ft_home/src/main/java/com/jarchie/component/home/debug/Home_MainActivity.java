package com.jarchie.component.home.debug;

import com.jarchie.component.home.HomeFragment;
import com.jarchie.component.home.R;
import com.jarchie.library.base.BaseActivity;

/**
 * 作者: 乔布奇
 * 日期: 2020-09-07 20:31
 * 邮箱: jarchie520@gmail.com
 * 描述: 首页模块测试主页
 */
public class Home_MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.home_activity_main;
    }

    @Override
    protected void initView() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mContent,new HomeFragment())
                .commit();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
