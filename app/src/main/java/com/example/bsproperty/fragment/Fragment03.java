package com.example.bsproperty.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bsproperty.R;
import com.example.bsproperty.adapter.BaseAdapter;
import com.example.bsproperty.bean.CommentBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wdxc1 on 2018/3/9.
 */

public class Fragment03 extends BaseFragment {
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private ArrayList<CommentBean> mData;


    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        rvList.setLayoutManager(new LinearLayoutManager(mContext));

        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CommentBean bean = new CommentBean();
            bean.setT1("火星网友("+i+")：2017-12-02");
            bean.setT2("这个讲Hive很清楚，我面试用上了，祝我好运吧"+i);
            mData.add(bean);
        }


        MyAdapter adapter = new MyAdapter(mContext,R.layout.item_comment,mData);
        rvList.setAdapter(adapter);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_03;
    }

    private class MyAdapter extends BaseAdapter<CommentBean>{

        public MyAdapter(Context context, int layoutId, ArrayList<CommentBean> data) {
            super(context, layoutId, data);
        }

        @Override
        public void initItemView(BaseViewHolder holder, CommentBean commentBean, int position) {
            holder.setText(R.id.tv_1,commentBean.getT1());
            holder.setText(R.id.tv_2,commentBean.getT2());
        }
    }
}
