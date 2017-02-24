package hh.com.animationdemo.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import hh.com.animationdemo.R;

public class FrameAnimationWithCodeFragment extends BaseFragment implements View.OnClickListener {

    private ImageView mImgLoading;
    private Button mBtnStart;
    private Button mBtnStop;

    private AnimationDrawable mAnimationDrawable;

    private static volatile FrameAnimationWithCodeFragment instance;

    public static FrameAnimationWithCodeFragment getInstance() {
        if (instance == null) {
            synchronized (FrameAnimationWithCodeFragment.class) {
                if (instance == null) {
                    instance = new FrameAnimationWithCodeFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame_animation_with_code, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mImgLoading = (ImageView) view.findViewById(R.id.img_loading);
        mBtnStart = (Button) view.findViewById(R.id.btn_start_with_code);
        mBtnStop = (Button) view.findViewById(R.id.btn_stop_with_code);

        mAnimationDrawable = getAnimationDrawable(mImgLoading);

        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    /**
     * 定义一个AnimationDrawable
     *
     * @return
     */
    private AnimationDrawable getAnimationDrawable(ImageView imageView) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for (int i = 0; i <= 7; i++) {
            // 根据资源名称和目录获取R.java中对应的资源ID
            int id = getResources().getIdentifier("loading_" + i,
                    "drawable", mContext.getPackageName());
            // 根据资源ID获取Drawable对象
            Drawable drawable = getResources().getDrawable(id, null);
            // 将此帧drawable添加到AnimationDrawable中
            animationDrawable.addFrame(drawable, 150);
        }
        // 设置循环播放此动画
        animationDrawable.setOneShot(false);
        imageView.setBackground(animationDrawable);
        return animationDrawable;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_with_code:
                mAnimationDrawable.start();
                break;
            case R.id.btn_stop_with_code:
                mAnimationDrawable.stop();
                break;
            default:
                break;
        }
    }
}
