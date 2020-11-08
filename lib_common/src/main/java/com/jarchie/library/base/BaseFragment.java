package com.jarchie.library.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 作者: 乔布奇
 * 日期: 2020-11-07 18:23
 * 邮箱: jarchie520@gmail.com
 * 描述: Fragment基类
 */
public abstract class BaseFragment extends Fragment {
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            if (getLayoutId() != 0) {
                mRootView = inflater.inflate(getLayoutId(), container, false);
            }
        }
        initView(mRootView);
        initListener();
        initData();
        return mRootView;
    }

    public abstract int getLayoutId(); //获取布局文件

    protected abstract void initView(View view); //初始化View

    protected abstract void initListener(); //初始化监听事件

    protected abstract void initData(); //初始化数据
}
