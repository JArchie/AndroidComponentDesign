package com.jarchie.component;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jarchie.component.home.HomeFragment;
import com.jarchie.component.order.OrderFragment;
import com.jarchie.component.personal.PersonalFragment;
import com.jarchie.component.product.ProductFragment;
import com.jarchie.library.base.BaseActivity;

/**
 * 作者：created by Jarchie
 * 时间：2020/9/9 10:16:25
 * 邮箱：jarchie520@gmail.com
 * 说明：应用主Activity
 */
public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mNavigationView;
    private Fragment mHomeFgt, mProductFgt, mOrderFgt, mPersonalFgt;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mNavigationView = findViewById(R.id.main_navigation);
        setSelect(0);
    }

    @Override
    protected void initListener() {
        mNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.tab1:
                setSelect(0);
                return true;
            case R.id.tab2:
                setSelect(1);
                return true;
            case R.id.tab3:
                setSelect(2);
                return true;
            case R.id.tab4:
                setSelect(3);
                return true;

        }
        return false;
    }

    //切换Fragment选项
    private void setSelect(int pos) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideFragment(transaction);
        switch (pos) {
            case 0: //首页
                if (mHomeFgt == null) {
                    mHomeFgt = new HomeFragment();
                    transaction.add(R.id.id_content, mHomeFgt);
                } else {
                    transaction.show(mHomeFgt);
                }
                break;
            case 1: //产品
                if (mProductFgt == null) {
                    mProductFgt = new ProductFragment();
                    transaction.add(R.id.id_content, mProductFgt);
                } else {
                    transaction.show(mProductFgt);
                }
                break;
            case 2: //订单
                if (mOrderFgt == null) {
                    mOrderFgt = new OrderFragment();
                    transaction.add(R.id.id_content, mOrderFgt);
                } else {
                    transaction.show(mOrderFgt);
                }
                break;
            case 3: //我的
                if (mPersonalFgt == null) {
                    mPersonalFgt = new PersonalFragment();
                    transaction.add(R.id.id_content, mPersonalFgt);
                } else {
                    transaction.show(mPersonalFgt);
                }
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    //隐藏Fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (mHomeFgt != null) {
            transaction.hide(mHomeFgt);
        }
        if (mProductFgt != null) {
            transaction.hide(mProductFgt);
        }
        if (mOrderFgt != null) {
            transaction.hide(mOrderFgt);
        }
        if (mPersonalFgt != null) {
            transaction.hide(mPersonalFgt);
        }
    }

}
