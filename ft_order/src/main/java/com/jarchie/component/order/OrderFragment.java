package com.jarchie.component.order;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jarchie.library.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 乔布奇
 * 日期: 2020-11-07 20:29
 * 邮箱: jarchie520@gmail.com
 * 描述: 订单模块
 */
public class OrderFragment extends BaseFragment {
    private RecyclerView mRecycler;
    private List<Integer> mList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_layout;
    }

    @Override
    protected void initView(View view) {
        mRecycler = view.findViewById(R.id.mRecycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mList.add(R.drawable.order1);
        mList.add(R.drawable.order2);
        mList.add(R.drawable.order3);
        mList.add(R.drawable.order4);
        mList.add(R.drawable.order2);
        mList.add(R.drawable.order3);
        mList.add(R.drawable.order1);
        mList.add(R.drawable.order4);
        mList.add(R.drawable.order3);
        mList.add(R.drawable.order2);
        mRecycler.setAdapter(new OrderAdapter(getContext(),mList));
    }
}
