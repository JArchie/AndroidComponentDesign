package com.jarchie.component.product;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.jarchie.library.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 乔布奇
 * 日期: 2020-11-07 20:31
 * 邮箱: jarchie520@gmail.com
 * 描述: 产品模块
 */
public class ProductFragment extends BaseFragment {
    private TextView mTitle;
    private RecyclerView mRecycler;
    private List<Integer> mList = new ArrayList<>();
    private String title;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_product_layout;
    }

    @Override
    protected void initView(View view) {
        title = getActivity().getIntent().getStringExtra("title");
        mTitle = view.findViewById(R.id.mTitle);
        mRecycler = view.findViewById(R.id.mRecycler);
        if (!TextUtils.isEmpty(title)) {
            mTitle.setText("ARouter" + title + "测试页面");
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2,
                        StaggeredGridLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(staggeredGridLayoutManager);
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mList.add(R.drawable.product1);
        mList.add(R.drawable.product2);
        mList.add(R.drawable.product3);
        mList.add(R.drawable.product4);
        mList.add(R.drawable.product1);
        mList.add(R.drawable.product3);
        mList.add(R.drawable.product2);
        mList.add(R.drawable.product4);
        mList.add(R.drawable.product2);
        mList.add(R.drawable.product3);
        mRecycler.setAdapter(new ProductAdapter(getContext(), mList));
    }
}
