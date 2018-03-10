package com.example.bsproperty.ui;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bsproperty.R;
import com.example.bsproperty.fragment.BaseFragment;
import com.example.bsproperty.fragment.Fragment01;
import com.example.bsproperty.fragment.Fragment02;
import com.example.bsproperty.fragment.Fragment03;
import com.example.bsproperty.view.VideoPlayerStandard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class PlayActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.videoplayer)
    VideoPlayerStandard videoplayer;
    @BindView(R.id.tb_lay)
    TabLayout tbLay;
    @BindView(R.id.vp_list)
    ViewPager vpList;

    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private ArrayList<BaseFragment> fragments;
    private MyFragmentPagerAdapter adapter;
    private String[] tabs;

    @Override
    protected void initView(Bundle savedInstanceState) {

        tabs = new String[]{
                getString(R.string.tb01), getString(R.string.tb02), getString(R.string.tb03)
        };

        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();
        fragments = new ArrayList<>();
        fragments.add(fragment01);
        fragments.add(fragment02);
        fragments.add(fragment03);

        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpList.setAdapter(adapter);

        for (int i = 0; i < fragments.size(); i++) {
            if (i == 1) {
                tbLay.addTab(tbLay.newTab().setText(tabs[i]), true);
            } else {
                tbLay.addTab(tbLay.newTab().setText(tabs[i]), false);
            }
        }
        vpList.setCurrentItem(1);
        tbLay.setupWithViewPager(vpList);

    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_play;
    }

    @Override
    protected void loadData() {

        tvTitle.setText(getIntent().getStringExtra("title"));

        videoplayer.setUp(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera/showMp.mp4"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        videoplayer.thumbImageView.setImageResource(R.mipmap.sample_01);

        videoplayer.setOnPlayListener(new VideoPlayerStandard.OnPlayListener() {
            @Override
            public void onPosition(long position) {
                fragment02.updateTime(position);
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_right:
                break;
        }
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
