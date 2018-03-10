package com.example.bsproperty.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bsproperty.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.wcy.lrcview.LrcView;

/**
 * Created by wdxc1 on 2018/3/9.
 */

public class Fragment02 extends BaseFragment {
    @BindView(R.id.lv_lrc)
    LrcView lvLrc;

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        lvLrc.loadLrc("[00:00.00]\t(music - welcome to ZeroToProTraining.com.)\t（片头）\n" +
                "[00:05.91]\tIn this video, we'll talk about what is Apache Hive?\t在这个视频中，我们将讨论什么是Apache Hive？\n" +
                "[00:11.01]\tThe Apache Hive is a data warehouse infrastructure.\tApache Hive是一个数据仓库基础设施。\n" +
                "[00:15.90]\tIt is built on top of Hadoop.\t它是建立在Hadoop之上的。\n" +
                "[00:19.44]\tThe purpose is to provide following functions: data summarization, query, analysis.\t其目的是提供以下功能：数据摘要、查询、分析。\n" +
                "[00:28.04]\tThe technology was initially developed by Facebook.\t这项技术最初是由脸书开发的。\n" +
                "[00:32.95]\tHive is now used and developed by other companies as well, such as Netflix.\tHive现在也被其他公司使用和开发，如Netflix。\n" +
                "[00:40.28]\tAmazon maintains a software fork of Apache Hive.\tAmazon维持着一个Apache Hive的软件fork。\n" +
                "[00:45.93]\tIt is included in Amazon Elastic MapReduce on Amazon Web Services.\t它包含在Amazon Web服务的Amazon弹性MapReduce中。\n" +
                "[00:52.19]\tApache Hive supports analysis of large datasets\tApache支持对大型数据集的分析，\n" +
                "[00:56.92]\tstored in Hadoop's file system and compatible file systems.\t存储在Hadoop的文件系统和兼容的文件系统中。\n" +
                "[01:02.53]\tExample of compatible file systems is Amazon S3 filesystem.\t兼容的文件系统的例子是Amazon S3文件系统。\n" +
                "[01:09.27]\tIt provides an SQL like language called HiveQL.\t它提供了一个类似SQL的语言称为HiveQL。\n" +
                "[01:15.55]\tHiveQL maintains full support for map/reduce technology.\tHiveQL保持支持全部的MapReduce技术。\n" +
                "[01:21.70]\tTo accelerate creates, it provides indexes, including bitmap indexes.\t为了加速创建，它提供索引，包括位图索引。\n" +
                "[01:29.53]\tBy default, Hive stores metadata in an embedded Apache Derby database.\t默认情况下，Hive将元数据存储在一个嵌入式Apache数据库中。\n" +
                "[01:36.79]\tOther clients/server databases like MySQL can optionally be used.\t其他的客户机/服务器数据库，如MySQL，可以随意使用。\n" +
                "[01:43.82]\tCurrently, there are four file formats supported in Hive.\t目前，Hive支持四种文件格式。\n" +
                "[01:49.33]\tTheir name are displayed on the screen.\t它们的名字显示在屏幕上。\n" +
                "[01:52.85]\t(music - Thank you for watching. More videos please visit ZeroToProTraining.com.)\t（片尾）\n");
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_02;
    }

    public void updateTime(long time){
        lvLrc.updateTime(time);
    }
}
