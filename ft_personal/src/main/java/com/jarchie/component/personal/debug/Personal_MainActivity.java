package com.jarchie.component.personal.debug;

import com.jarchie.component.personal.PersonalFragment;
import com.jarchie.component.personal.R;
import com.jarchie.library.base.BaseActivity;

/**
 * 作者: 乔布奇
 * 日期: 2020-09-07 20:31
 * 邮箱: jarchie520@gmail.com
 * 描述: 个人中心测试主页
 */
public class Personal_MainActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.personal_activity_main;
    }

    @Override
    protected void initView() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mContent,new PersonalFragment())
                .commit();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
