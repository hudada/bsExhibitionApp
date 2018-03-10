package com.example.bsproperty.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.ItemBean;
import com.example.bsproperty.utils.RawUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.tv_01)
    TextView tv01;
    @BindView(R.id.tv_011)
    TextView tv011;
    @BindView(R.id.rl_01)
    RelativeLayout rl01;
    @BindView(R.id.tv_02)
    TextView tv02;
    @BindView(R.id.tv_021)
    TextView tv021;
    @BindView(R.id.rl_02)
    RelativeLayout rl02;
    @BindView(R.id.ll_01)
    LinearLayout ll01;
    @BindView(R.id.ima_arrow)
    ImageView imaArrow;
    @BindView(R.id.tv_03)
    TextView tv03;
    @BindView(R.id.rl_03)
    RelativeLayout rl03;
    @BindView(R.id.ll_action)
    LinearLayout llAction;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.ll_search_select)
    LinearLayout llSearchSelect;
    @BindView(R.id.tv_hot_01)
    TextView tvHot01;
    @BindView(R.id.tv_hot_02)
    TextView tvHot02;
    @BindView(R.id.tv_hot_03)
    TextView tvHot03;
    @BindView(R.id.tv_hot_04)
    TextView tvHot04;
    @BindView(R.id.tv_hot_05)
    TextView tvHot05;
    @BindView(R.id.tv_hot_06)
    TextView tvHot06;
    @BindView(R.id.tv_hot_07)
    TextView tvHot07;
    @BindView(R.id.tv_hot_08)
    TextView tvHot08;
    @BindView(R.id.tv_hot_09)
    TextView tvHot09;
    @BindView(R.id.tv_hot_10)
    TextView tvHot10;
    @BindView(R.id.ll_search_hot)
    LinearLayout llSearchHot;

    @BindView(R.id.tv_type1)
    TextView tvType1;
    @BindView(R.id.tv_type2)
    TextView tvType2;
    @BindView(R.id.tv_type3)
    TextView tvType3;
    @BindView(R.id.tv_type4)
    TextView tvType4;
    @BindView(R.id.tv_type5)
    TextView tvType5;
    @BindView(R.id.tv_type6)
    TextView tvType6;
    @BindView(R.id.tv_type7)
    TextView tvType7;
    @BindView(R.id.tv_type8)
    TextView tvType8;
    @BindView(R.id.tv_type9)
    TextView tvType9;
    @BindView(R.id.tv_type10)
    TextView tvType10;
    @BindView(R.id.tv_type11)
    TextView tvType11;
    @BindView(R.id.tv_type12)
    TextView tvType12;
    @BindView(R.id.tv_type13)
    TextView tvType13;
    @BindView(R.id.tv_type14)
    TextView tvType14;
    @BindView(R.id.tv_type15)
    TextView tvType15;
    @BindView(R.id.tv_type16)
    TextView tvType16;
    @BindView(R.id.tv_type17)
    TextView tvType17;
    @BindView(R.id.tv_type18)
    TextView tvType18;
    @BindView(R.id.tv_type19)
    TextView tvType19;
    @BindView(R.id.tv_type20)
    TextView tvType20;
    @BindView(R.id.tv_type21)
    TextView tvType21;


    private static final int START = 1;
    private static final int TYPE = 2;
    private static final int SEARCH = 3;


    private ArrayList<ItemBean> mData = new ArrayList<>();
    private MyAdapter adapter;
    private int pageStatus = START;
    private ItemBean selectBean;


    @Override
    protected void initView(Bundle savedInstanceState) {





        rvList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this, R.layout.item_app_main_item, mData);
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, Object item, int position) {
                selectBean = mData.get(position);
                PermissionGen.needPermission(MainActivity.this,
                        521,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE}
                );

            }
        });
        adapter.setOnLoadMoreListener(rvList, new BaseAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                initData("More", false);
                                adapter.setLoadComplete(false);
                            }
                        });
                    }
                }).start();
            }
        });
        rvList.setAdapter(adapter);
    }


    private void initData(String name, boolean isclear) {
        if (isclear) {
            mData.clear();
        }
        for (int i = 0; i < 8; i++) {
            ItemBean itemBean = new ItemBean();
            Random random = new Random();
            int r = random.nextInt(3);
            switch (r) {
                case 0:
                    itemBean.setImg(R.mipmap.sample_01);
                    break;
                case 1:
                    itemBean.setImg(R.mipmap.sample_02);
                    break;
                case 2:
                    itemBean.setImg(R.mipmap.sample_03);
                    break;
            }
            itemBean.setTxt1("What is " + name);
            itemBean.setTxt2("Hadoop 大数据 架构 北美音 入门基础 新手学习");
            itemBean.setTxt3("01\\'20\\\" | 1级难度 | 1.2万收藏");
            mData.add(itemBean);
        }
        adapter.notifyDataSetChanged(mData);
    }

    @PermissionSuccess(requestCode = 521)
    private void selectPhoto() {
        String DCIM = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
        String DIRECTORY = DCIM + "/Camera";
        RawUtils.copyFilesFromRaw(this, R.raw.sample, "showMp.mp4",
                DIRECTORY
        );
        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
        intent.putExtra("title",selectBean.getTxt1());
        startActivity(intent);
    }

    @PermissionFail(requestCode = 521)
    private void showTip1() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void loadData() {
        initData("Hadoop", true);
    }

    @OnClick({R.id.iv_back, R.id.ll_search, R.id.et_search, R.id.iv_right, R.id.tv_right, R.id.tv_01, R.id.tv_011, R.id.rl_01, R.id.tv_02, R.id.tv_021, R.id.rl_02, R.id.ll_01, R.id.ima_arrow, R.id.tv_03, R.id.rl_03, R.id.ll_action, R.id.rv_list, R.id.ll_search_select, R.id.tv_hot_01, R.id.tv_hot_02, R.id.tv_hot_03, R.id.tv_hot_04, R.id.tv_hot_05, R.id.tv_hot_06, R.id.tv_hot_07, R.id.tv_hot_08, R.id.tv_hot_09, R.id.tv_hot_10, R.id.ll_search_hot,
            R.id.tv_type1, R.id.tv_type2, R.id.tv_type3, R.id.tv_type4, R.id.tv_type5, R.id.tv_type6, R.id.tv_type7, R.id.tv_type8, R.id.tv_type9, R.id.tv_type10, R.id.tv_type11, R.id.tv_type12, R.id.tv_type13, R.id.tv_type14, R.id.tv_type15, R.id.tv_type16, R.id.tv_type17, R.id.tv_type18, R.id.tv_type19, R.id.tv_type20, R.id.tv_type21})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.ll_search:
                showTypePage(SEARCH);
                break;
            case R.id.et_search:
                break;
            case R.id.iv_right:
                break;
            case R.id.tv_right:
                showTypePage(START);
                break;
            case R.id.tv_01:
                initAction(1);
                break;
            case R.id.tv_011:
                break;
            case R.id.rl_01:  //最新
                initAction(1);
                break;
            case R.id.tv_02:  //最热
                initAction(2);
                break;
            case R.id.tv_021:
                break;
            case R.id.rl_02:
                initAction(2);
                break;
            case R.id.ll_01:
                break;
            case R.id.ima_arrow:  //分类
            case R.id.tv_03:
                if (pageStatus == TYPE) {
                    showTypePage(START);
                } else {
                    showTypePage(TYPE);
                }
                break;
            case R.id.rl_03:
                break;
            case R.id.ll_action:
                break;
            case R.id.rv_list:
                break;
            case R.id.ll_search_select:
                break;
            case R.id.ll_search_hot:
                break;

            case R.id.tv_hot_01:
            case R.id.tv_hot_02:
            case R.id.tv_hot_03:
            case R.id.tv_hot_04:
            case R.id.tv_hot_05:
            case R.id.tv_hot_06:
            case R.id.tv_hot_07:
            case R.id.tv_hot_08:
            case R.id.tv_hot_09:
            case R.id.tv_hot_10:
            case R.id.tv_type1:
            case R.id.tv_type2:
            case R.id.tv_type3:
            case R.id.tv_type4:
            case R.id.tv_type5:
            case R.id.tv_type6:
            case R.id.tv_type7:
            case R.id.tv_type8:
            case R.id.tv_type9:
            case R.id.tv_type10:
            case R.id.tv_type11:
            case R.id.tv_type12:
            case R.id.tv_type13:
            case R.id.tv_type14:
            case R.id.tv_type15:
            case R.id.tv_type16:
            case R.id.tv_type17:
            case R.id.tv_type18:
            case R.id.tv_type19:
            case R.id.tv_type20:
            case R.id.tv_type21:
                TextView textView = (TextView) view;
                initData(textView.getText().toString(), true);
                showTypePage(START);
                tv03.setText(textView.getText().toString());
                break;
        }
    }

    private void showTypePage(int type) {
        pageStatus = type;
        ivBack.setVisibility(View.GONE);
        llSearch.setVisibility(View.GONE);
        ivRight.setVisibility(View.GONE);
        ll01.setVisibility(View.INVISIBLE);
        llAction.setVisibility(View.GONE);
        rvList.setVisibility(View.GONE);
        llSearchSelect.setVisibility(View.GONE);
        etSearch.setVisibility(View.GONE);
        tvRight.setVisibility(View.GONE);
        llSearchHot.setVisibility(View.GONE);
        imaArrow.setImageResource(R.mipmap.a_arrow_down_b);
        switch (type) {
            case START:
                ivBack.setVisibility(View.VISIBLE);
                llSearch.setVisibility(View.VISIBLE);
                ivRight.setVisibility(View.VISIBLE);
                ll01.setVisibility(View.VISIBLE);
                llAction.setVisibility(View.VISIBLE);
                rvList.setVisibility(View.VISIBLE);
                break;
            case TYPE:
                imaArrow.setImageResource(R.mipmap.aa_arrow_upb);
                ivBack.setVisibility(View.VISIBLE);
                llSearch.setVisibility(View.VISIBLE);
                ivRight.setVisibility(View.VISIBLE);
                llAction.setVisibility(View.VISIBLE);
                llSearchSelect.setVisibility(View.VISIBLE);
                initTypePage();
                break;
            case SEARCH:
                etSearch.setVisibility(View.VISIBLE);
                tvRight.setVisibility(View.VISIBLE);
                llSearchHot.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void initTypePage() {

    }

    private void initAction(int flag) {
        tv01.setTextColor(getResources().getColor(R.color.gray));
        tv011.setVisibility(View.GONE);
        tv02.setTextColor(getResources().getColor(R.color.gray));
        tv021.setVisibility(View.GONE);
        switch (flag) {
            case 1:
                tv01.setTextColor(getResources().getColor(R.color.black));
                tv011.setVisibility(View.VISIBLE);
                initData("最新", true);
                break;
            case 2:
                tv02.setTextColor(getResources().getColor(R.color.black));
                tv021.setVisibility(View.VISIBLE);
                initData("最热", true);
                break;
        }

    }

    private class MyAdapter extends BaseAdapter<ItemBean> {

        public MyAdapter(Context context, int layoutId, ArrayList<ItemBean> data) {
            super(context, layoutId, data);
        }

        @Override
        public void initItemView(BaseViewHolder holder, ItemBean itemBean, int position) {
            ImageView imageView = (ImageView) holder.getView(R.id.image_01);
            imageView.setImageResource(itemBean.getImg());
            holder.setText(R.id.text_01, itemBean.getTxt1());
            holder.setText(R.id.text_02, itemBean.getTxt2());
            holder.setText(R.id.text_03, itemBean.getTxt3());
        }
    }
}
