package hh.com.animationdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import hh.com.animationdemo.R;

public class TweenAnimationWithXmlFragment extends BaseFragment implements View.OnClickListener {

    private TextView mTxtContent;
    private Button mBtnAlphaWithXml;
    private Button mBtnScaleWithXml;
    private Button mBtnTranslateWithXml;
    private Button mBtnRotateWithXml;
    private Button mBtnAnimationSetWithXml;

    private Animation mAlphaAnimation;
    private Animation mScaleAnimation;
    private Animation mTranslateAnimation;
    private Animation mRotateAnimation;
    private Animation mSetAnimation;

    private static volatile TweenAnimationWithXmlFragment instance;

    public static TweenAnimationWithXmlFragment getInstance() {
        if (instance == null) {
            synchronized (TweenAnimationWithXmlFragment.class) {
                if (instance == null) {
                    instance = new TweenAnimationWithXmlFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tween_animation_with_xml, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mTxtContent = (TextView) view.findViewById(R.id.txt_animation_with_xml);
        mBtnAlphaWithXml = (Button) view.findViewById(R.id.btn_alpha_with_xml);
        mBtnScaleWithXml = (Button) view.findViewById(R.id.btn_scale_with_xml);
        mBtnTranslateWithXml = (Button) view.findViewById(R.id.btn_translate_with_xml);
        mBtnRotateWithXml = (Button) view.findViewById(R.id.btn_rotate_with_xml);
        mBtnAnimationSetWithXml = (Button) view.findViewById(R.id.btn_animation_set_with_xml);
        mBtnAlphaWithXml.setOnClickListener(this);
        mBtnScaleWithXml.setOnClickListener(this);
        mBtnTranslateWithXml.setOnClickListener(this);
        mBtnRotateWithXml.setOnClickListener(this);
        mBtnAnimationSetWithXml.setOnClickListener(this);

        mAlphaAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.alpha);
        mScaleAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.scale);
        mTranslateAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.translate);
        mRotateAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.rotate);
        mSetAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.animation_set);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha_with_xml:
                mTxtContent.setText(R.string.btn_alpha_with_xml);
                mTxtContent.startAnimation(mAlphaAnimation);
                break;
            case R.id.btn_scale_with_xml:
                mTxtContent.setText(R.string.btn_scale_with_xml);
                mTxtContent.startAnimation(mScaleAnimation);
                break;
            case R.id.btn_translate_with_xml:
                mTxtContent.setText(R.string.btn_translate_with_xml);
                mTxtContent.startAnimation(mTranslateAnimation);
                break;
            case R.id.btn_rotate_with_xml:
                mTxtContent.setText(R.string.btn_rotate_with_xml);
                mTxtContent.startAnimation(mRotateAnimation);
                break;
            case R.id.btn_animation_set_with_xml:
                mTxtContent.setText(R.string.btn_animation_set_with_xml);
                mTxtContent.startAnimation(mSetAnimation);
                break;
            default:
                break;
        }
    }
}
