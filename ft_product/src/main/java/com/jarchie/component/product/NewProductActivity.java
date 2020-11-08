package com.jarchie.component.product;

import android.os.Bundle;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jarchie.library.base.BaseActivity;
import com.jarchie.library.constants.PathUrl;

/**
 * 作者: 乔布奇
 * 日期: 2020-11-08 11:32
 * 邮箱: jarchie520@gmail.com
 * 描述: 新品页面
 */
@Route(path = PathUrl.PATH_NEW_PRODUCT)
public class NewProductActivity extends BaseActivity {
    @Autowired
    public String title;

    private ProductFragment mFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_new_product_layout;
    }

    @Override
    protected void initView() {
        ARouter.getInstance().inject(this);
        mFragment = new ProductFragment();
        if (!TextUtils.isEmpty(title)) {
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            mFragment.setArguments(bundle);
        }
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mContent, new ProductFragment())
                .commit();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
