package com.example.bsproperty.view;

import android.content.Context;
import android.util.AttributeSet;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by wdxc1 on 2018/3/10.
 */

public class VideoPlayerStandard extends JZVideoPlayerStandard {

    private OnPlayListener onPlayListener;

    public VideoPlayerStandard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoPlayerStandard(Context context) {
        this(context, null);
    }


    @Override
    public void setProgressAndText(int progress, long position, long duration) {
        super.setProgressAndText(progress, position, duration);
        if (onPlayListener != null) {
            onPlayListener.onPosition(position);
        }
    }

    public OnPlayListener getOnPlayListener() {
        return onPlayListener;
    }

    public void setOnPlayListener(OnPlayListener onPlayListener) {
        this.onPlayListener = onPlayListener;
    }

    public interface OnPlayListener {
        void onPosition(long position);
    }
}
