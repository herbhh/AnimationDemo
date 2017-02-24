package hh.com.animationdemo.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import hh.com.animationdemo.R;

public class FrameAnimationWithXmlFragment extends BaseFragment implements View.OnClickListener {

    private ImageView mImgLoading;
    private Button mBtnStart;
    private Button mBtnStop;

    private AnimationDrawable mAnimationDrawable;

    private static volatile FrameAnimationWithXmlFragment instance;

    public static FrameAnimationWithXmlFragment getInstance() {
        if (instance == null) {
            synchronized (FrameAnimationWithXmlFragment.class) {
                if (instance == null) {
                    instance = new FrameAnimationWithXmlFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame_animation_with_xml, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mImgLoading = (ImageView) view.findViewById(R.id.img_loading);
        mBtnStart = (Button) view.findViewById(R.id.btn_start_with_xml);
        mBtnStop = (Button) view.findViewById(R.id.btn_stop_with_xml);

        mImgLoading.setImageResource(R.drawable.loading_anim);

        // 根据ImageView的drawable定义AnimationDrawable;
        mAnimationDrawable = (AnimationDrawable) mImgLoading.getDrawable();

        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_with_xml:
                mAnimationDrawable.start();
                break;
            case R.id.btn_stop_with_xml:
                mAnimationDrawable.stop();
                break;
            default:
                break;
        }
    }
}
