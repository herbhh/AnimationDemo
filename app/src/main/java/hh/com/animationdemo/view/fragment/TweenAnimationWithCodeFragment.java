package hh.com.animationdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import hh.com.animationdemo.R;

public class TweenAnimationWithCodeFragment extends BaseFragment implements View.OnClickListener {

    private TextView mTxtContent;
    private Button mBtnAlphaWithCode;
    private Button mBtnScaleWithCode;
    private Button mBtnTranslateWithCode;
    private Button mBtnRotateWithCode;
    private Button mBtnAnimationSetWithCode;

    private AlphaAnimation mAlphaAnimation;
    private ScaleAnimation mScaleAnimation;
    private TranslateAnimation mTranslateAnimation;
    private RotateAnimation mRotateAnimation;
    private AnimationSet mSetAnimation;
    private static volatile TweenAnimationWithCodeFragment instance;

    public static TweenAnimationWithCodeFragment getInstance() {
        if (instance == null) {
            synchronized (TweenAnimationWithCodeFragment.class) {
                if (instance == null) {
                    instance = new TweenAnimationWithCodeFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tween_animation_with_code, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mTxtContent = (TextView) view.findViewById(R.id.txt_animation_with_code);
        mBtnAlphaWithCode = (Button) view.findViewById(R.id.btn_alpha_with_code);
        mBtnScaleWithCode = (Button) view.findViewById(R.id.btn_scale_with_code);
        mBtnTranslateWithCode = (Button) view.findViewById(R.id.btn_translate_with_code);
        mBtnRotateWithCode = (Button) view.findViewById(R.id.btn_rotate_with_code);
        mBtnAnimationSetWithCode = (Button) view.findViewById(R.id.btn_animation_set_with_code);
        mBtnAlphaWithCode.setOnClickListener(this);
        mBtnScaleWithCode.setOnClickListener(this);
        mBtnTranslateWithCode.setOnClickListener(this);
        mBtnRotateWithCode.setOnClickListener(this);
        mBtnAnimationSetWithCode.setOnClickListener(this);

        // alpha animation
        mAlphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        mAlphaAnimation.setDuration(2000);

        // scale animation
        mScaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 05f, Animation.RELATIVE_TO_SELF, 0.5f);
        mScaleAnimation.setDuration(2000);
        mScaleAnimation.setRepeatCount(2);
        mScaleAnimation.setRepeatMode(Animation.REVERSE);

        // translate animation
        mTranslateAnimation = new TranslateAnimation(0, 0, 0, 250);
        mTranslateAnimation.setDuration(2000);
        mTranslateAnimation.setFillAfter(true);

        // rotate animation
        mRotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 05f);
        mRotateAnimation.setDuration(2000);
        mScaleAnimation.setRepeatCount(2);
        mScaleAnimation.setRepeatMode(Animation.RESTART);

        // animation set
        mSetAnimation = new AnimationSet(false);
        mSetAnimation.addAnimation(mScaleAnimation);
        mSetAnimation.addAnimation(mTranslateAnimation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_alpha_with_code:
                mTxtContent.setText(R.string.btn_alpha_with_code);
                mTxtContent.startAnimation(mAlphaAnimation);
                break;
            case R.id.btn_scale_with_code:
                mTxtContent.setText(R.string.btn_scale_with_code);
                mTxtContent.startAnimation(mScaleAnimation);
                break;
            case R.id.btn_translate_with_code:
                mTxtContent.setText(R.string.btn_translate_with_code);
                mTxtContent.startAnimation(mTranslateAnimation);
                break;
            case R.id.btn_rotate_with_code:
                mTxtContent.setText(R.string.btn_rotate_with_code);
                mTxtContent.startAnimation(mRotateAnimation);
                break;
            case R.id.btn_animation_set_with_code:
                mTxtContent.setText(R.string.btn_animation_set_with_code);
                mTxtContent.startAnimation(mSetAnimation);
                break;
            default:
                break;
        }
    }

    /**
     * Test animation
     */
    public void Test() {
        Animation a = new Animation() {

            private long last = -1;
            private int num = 0;
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                long curr = System.currentTimeMillis();
                long delta = curr - last;
                last = curr;
                Log.i("Animation", "=="+ num+ "==" +delta + "");
                num ++ ;
                t.getMatrix().postTranslate(10,10);
            }
        };
        a.setDuration(2000);
        mTxtContent.startAnimation(a);
    }
}
