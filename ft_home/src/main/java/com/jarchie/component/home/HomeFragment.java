package com.jarchie.component.home;


import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.jarchie.library.base.BaseDelegeteAdapter;
import com.jarchie.library.base.BaseFragment;
import com.jarchie.library.base.BaseViewHolder;
import com.jarchie.library.constants.PathUrl;
import com.jarchie.library.glide.GlideImageLoader;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 乔布奇
 * 日期: 2020-11-07 17:02
 * 邮箱: jarchie520@gmail.com
 * 描述: 首页模块
 */
public class HomeFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    //应用
    private String[] ITEM_NAMES = {"天猫", "聚划算", "天猫国际", "外卖", "天猫超市", "充值中心", "飞猪旅行", "领金币", "拍卖", "新品"};
    private int[] IMG_URLS = {R.drawable.ic_tian_mao, R.drawable.ic_ju_hua_suan, R.drawable.ic_tian_mao_guoji,
            R.drawable.ic_waimai, R.drawable.ic_chaoshi, R.drawable.ic_voucher_center, R.drawable.ic_travel,
            R.drawable.ic_tao_gold, R.drawable.ic_auction, R.drawable.ic_classify};

    //高颜值商品位
    private int[] ITEM_URL = {R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4, R.drawable.item5};
    private int[] GRID_URL = {R.drawable.flashsale1, R.drawable.flashsale2, R.drawable.flashsale3, R.drawable.flashsale4};


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    protected void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getContext());
        mRecyclerView.setLayoutManager(virtualLayoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        BaseDelegeteAdapter bannerAdapter = new BaseDelegeteAdapter(getActivity()
                , new LinearLayoutHelper(), R.layout.vlayout_banner, 1) {
            @SuppressLint("ResourceType")
            @Override
            public void onBindViewHolder(BaseViewHolder holder, int i) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(R.drawable.banner1);
                arrayList.add(R.drawable.banner2);
                arrayList.add(R.drawable.banner3);
                arrayList.add(R.drawable.banner4);
                arrayList.add(R.drawable.banner5);
                // 绑定数据
                Banner mBanner = holder.getView(R.id.banner);
                //设置banner样式
                mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                //设置图片加载器
                mBanner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                mBanner.setImages(arrayList);
                //设置banner动画效果
                mBanner.setBannerAnimation(Transformer.DepthPage);
                //设置标题集合（当banner样式有显示title时）
                //        mBanner.setBannerTitles(titles);
                //设置自动轮播，默认为true
                mBanner.isAutoPlay(true);
                //设置轮播时间
                mBanner.setDelayTime(3000);
                //设置指示器位置（当banner模式中有指示器时）
                mBanner.setIndicatorGravity(BannerConfig.CENTER);
                //banner设置方法全部调用完毕时最后调用
                mBanner.start();

                mBanner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(getActivity(), "banner点击了" + position, Toast.LENGTH_SHORT).show();
                    }
                });

                super.onBindViewHolder(holder, i);
            }
        };
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setPadding(0, 16, 0, 0);
        gridLayoutHelper.setVGap(10);
        gridLayoutHelper.setHGap(0);//// 控制子元素之间的水平间距

        BaseDelegeteAdapter menuAdapter = new BaseDelegeteAdapter(getActivity(), gridLayoutHelper, R.layout.vlayout_menu, 10) {
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
                holder.setText(R.id.tv_menu_title_home, ITEM_NAMES[position] + "");
                holder.setImageResource(R.id.iv_menu_home, IMG_URLS[position]);
                holder.getView(R.id.ll_menu_home).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (BuildConfig.isRelease) {
                            if (position == ITEM_NAMES.length - 1) {
                                ARouter.getInstance().build(PathUrl.PATH_NEW_PRODUCT)
                                        .withString("title", ITEM_NAMES[position])
                                        .navigation();
                            } else {
                                Toast.makeText(getActivity(), ITEM_NAMES[position], Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), ITEM_NAMES[position], Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        };

        BaseDelegeteAdapter newsAdapter = new BaseDelegeteAdapter(getActivity(), new LinearLayoutHelper(),
                R.layout.vlayout_news, 1) {
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, int i) {
                MarqueeView marqueeView1 = holder.getView(R.id.marqueeView1);
                MarqueeView marqueeView2 = holder.getView(R.id.marqueeView2);

                List<String> info1 = new ArrayList<>();
                info1.add("淘宝某宝万能宝");
                info1.add("马云爸爸送优惠啦，蚂蚁金服快上市啦！");

                List<String> info2 = new ArrayList<>();
                info2.add("又到一年双11啦啦啦啦啦！");
                info2.add("男人女人买买买，小手动起来喽！");

                marqueeView1.startWithList(info1);
                marqueeView2.startWithList(info2);
                // 在代码里设置自己的动画
                marqueeView1.startWithList(info1, com.sunfusheng.marqueeview.R.anim.anim_bottom_in, com.sunfusheng.marqueeview.R.anim.anim_bottom_out);
                marqueeView2.startWithList(info2, com.sunfusheng.marqueeview.R.anim.anim_bottom_in, com.sunfusheng.marqueeview.R.anim.anim_bottom_out);

                marqueeView1.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                marqueeView2.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position, TextView textView) {
                        Toast.makeText(getActivity(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(menuAdapter);
        delegateAdapter.addAdapter(newsAdapter);
        for (int i = 0; i < ITEM_URL.length; i++) {
            final int finalI = i;
            BaseDelegeteAdapter titleAdapter = new BaseDelegeteAdapter(getActivity(),
                    new LinearLayoutHelper(), R.layout.vlayout_title, 1) {
                @Override
                public void onBindViewHolder(BaseViewHolder holder, int position) {
                    super.onBindViewHolder(holder, position);
                    holder.setImageResource(R.id.iv, ITEM_URL[finalI]);
                }
            };
            GridLayoutHelper gridHelper = new GridLayoutHelper(2);
            BaseDelegeteAdapter gridAdapter = new BaseDelegeteAdapter(getActivity(), gridHelper,
                    R.layout.vlayout_grid, 4) {

                @Override
                public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
                    int item = GRID_URL[position];
                    ImageView iv = holder.getView(R.id.iv);
                    Glide.with(getActivity()).load(item).into(iv);

                    iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getActivity(), "item" + position, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            };
            delegateAdapter.addAdapter(titleAdapter);
            delegateAdapter.addAdapter(gridAdapter);
        }
        mRecyclerView.setAdapter(delegateAdapter);
    }
}
