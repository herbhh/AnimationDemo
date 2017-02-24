package hh.com.animationdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hh.com.animationdemo.R;


public class FrameAnimationFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnFrameAnimationWithXml;
    private Button mBtnFrameAnimationWithCode;

    private static volatile FrameAnimationFragment instance;

    public static FrameAnimationFragment getInstance() {
        if (instance == null) {
            synchronized (FrameAnimationFragment.class) {
                if (instance == null) {
                    instance = new FrameAnimationFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frame_animation, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mBtnFrameAnimationWithXml = (Button) view.findViewById(R.id.btn_frame_animation_with_xml);
        mBtnFrameAnimationWithCode = (Button) view.findViewById(R.id.btn_frame_animation_with_code);
        mBtnFrameAnimationWithXml.setOnClickListener(this);
        mBtnFrameAnimationWithCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_frame_animation_with_xml:
                mContext.startFragment(FrameAnimationWithXmlFragment.getInstance(), getInstance());
                break;
            case R.id.btn_frame_animation_with_code:
                mContext.startFragment(FrameAnimationWithCodeFragment.getInstance(), getInstance());
                break;
            default:
                break;
        }
    }
}
