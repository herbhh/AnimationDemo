package hh.com.animationdemo.view.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hh.com.animationdemo.R;
import hh.com.animationdemo.animation.interpolator.DeceAcceInterpolator;

public class CustomInterpolatorFragment extends BaseFragment implements View.OnClickListener {

    private TextView mTxtContent;
    private Button mBtnAccDecInterpolator;

    private AnimatorSet mAnimatorSet;

    private static volatile CustomInterpolatorFragment instance;

    public static CustomInterpolatorFragment getInstance() {
        if (instance == null) {
            synchronized (CustomInterpolatorFragment.class) {
                if (instance == null) {
                    instance = new CustomInterpolatorFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interpolator, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mTxtContent = (TextView) view.findViewById(R.id.txt_object);
        mBtnAccDecInterpolator = (Button) view.findViewById(R.id.btn_custom_interpolator);
        mBtnAccDecInterpolator.setOnClickListener(this);

        // animator set use code
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mTxtContent, "translationY", -800.0f, 800.0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mTxtContent, "alpha", 1.0f, 0.2f, 1.0F);
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.playTogether(animator1, animator2);
        mAnimatorSet.setInterpolator(new DeceAcceInterpolator());
        mAnimatorSet.setDuration(5000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_custom_interpolator:
                mTxtContent.setText(R.string.btn_custom_interpolator);
                mAnimatorSet.start();
                break;
            default:
                break;
        }
    }
}
