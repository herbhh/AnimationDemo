package hh.com.animationdemo.fragment;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hh.com.animationdemo.R;

public class ValueAnimatorFragment extends BaseFragment implements View.OnClickListener {

    private static final String TAG = ValueAnimatorFragment.class.getSimpleName();

    private TextView mTxtContent;
    private Button mBtnValueAnimatorWithXml;
    private Button mBtnValueAnimatorSetWithXml;
    private Button mBtnValueAnimatorWithCode;
    private Button mBtnValueAnimatorSetWithCode;
    private Button mBtnValueAnimatorSetWithPVHCode;

    private ValueAnimator mValueAnimatorWithXml;
    private ValueAnimator mValueAnimatorSetWithXml;
    private ValueAnimator mValueAnimatorWithCode;
    private ValueAnimator mValueAnimatorSetWithPVHCode;
    private AnimatorSet mAnimatorSet;

    private static volatile ValueAnimatorFragment instance;

    public static ValueAnimatorFragment getInstance() {
        if (instance == null) {
            synchronized (ValueAnimatorFragment.class) {
                if (instance == null) {
                    instance = new ValueAnimatorFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_value_animator, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mTxtContent = (TextView) view.findViewById(R.id.txt_value);
        mBtnValueAnimatorWithXml = (Button) view.findViewById(R.id.btn_value_animator_with_xml);
        mBtnValueAnimatorSetWithXml = (Button) view.findViewById(R.id.btn_value_animator_set_with_xml);
        mBtnValueAnimatorWithCode = (Button) view.findViewById(R.id.btn_value_animator_with_code);
        mBtnValueAnimatorSetWithCode = (Button) view.findViewById(R.id.btn_value_animator_set_with_code);
        mBtnValueAnimatorSetWithPVHCode = (Button) view.findViewById(R.id.btn_value_animator_set_with_pvh_code);
        mBtnValueAnimatorWithXml.setOnClickListener(this);
        mBtnValueAnimatorSetWithXml.setOnClickListener(this);
        mBtnValueAnimatorWithCode.setOnClickListener(this);
        mBtnValueAnimatorSetWithCode.setOnClickListener(this);
        mBtnValueAnimatorSetWithPVHCode.setOnClickListener(this);

        // with xml
        mValueAnimatorWithXml = (ValueAnimator) AnimatorInflater.loadAnimator(mContext, R.animator.value_animator);
        mValueAnimatorWithXml.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) valueAnimator.getAnimatedValue();
                mTxtContent.setHeight(value);
            }
        });

        // animation set with xml
//        mValueAnimatorSetWithXml = (ValueAnimator) AnimatorInflater.loadAnimator(mContext, R.animator.value_animator_set);
//        mValueAnimatorSetWithXml.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                int value = (int) valueAnimator.getAnimatedValue();
//                mTxtContent.setHeight(value);
//            }
//        });


        // with java code
        mValueAnimatorWithCode = ValueAnimator.ofFloat(1.0f, 0.0f, 1.0f);
        mValueAnimatorWithCode.setDuration(1000);
        mValueAnimatorWithCode.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float curValue = (float) valueAnimator.getAnimatedValue();
                Log.d(TAG, "curValue = " + curValue);
                mTxtContent.setAlpha(curValue);
            }
        });

        // animator set with code
        ValueAnimator animator = ValueAnimator.ofInt(0xFFFF0000, 0xFFFF00FF);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int curValue = (int) valueAnimator.getAnimatedValue();
                mTxtContent.setBackgroundColor(curValue);
            }
        });
        ValueAnimator animator1 = ValueAnimator.ofFloat(100f, 200.0f);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float curValue = (float) valueAnimator.getAnimatedValue();
                mTxtContent.setRotationY(curValue);
            }
        });
        ValueAnimator animator2 = ValueAnimator.ofFloat(1.0f, 2.0f);
        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float curValue = (float) valueAnimator.getAnimatedValue();
                mTxtContent.setScaleX(curValue);
                mTxtContent.setScaleY(curValue);
            }
        });
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(animator).with(animator1).before(animator2);
        mAnimatorSet.setDuration(3000);

        // PropertyValuesHolder set with xml
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.1f);
        PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("rotationX", 0.0f, 90.0f, 0.0f);
        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("translationX", 0.0f, 200.0f);
        mValueAnimatorSetWithPVHCode = ValueAnimator.ofPropertyValuesHolder(
                propertyValuesHolder, propertyValuesHolder1, propertyValuesHolder2);
        mValueAnimatorSetWithPVHCode.setDuration(2000);
        mValueAnimatorSetWithPVHCode.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue("alpha");
                float value1 = (float) valueAnimator.getAnimatedValue("rotationX");
                float value2 = (float) valueAnimator.getAnimatedValue("translationX");
                mTxtContent.setAlpha(value);
                mTxtContent.setRotationX(value1);
                mTxtContent.setTranslationX(value2);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_value_animator_with_xml:
                mTxtContent.setText(R.string.btn_value_animator_with_xml);
                mValueAnimatorWithXml.start();
//                mValueAnimator.start();
                break;
            case R.id.btn_value_animator_set_with_xml:
                mTxtContent.setText(R.string.btn_value_animator_set_with_xml);
                mValueAnimatorSetWithXml.start();
                break;
            case R.id.btn_value_animator_with_code:
                mTxtContent.setText(R.string.btn_value_animator_with_code);
                mValueAnimatorWithCode.start();
                break;
            case R.id.btn_value_animator_set_with_code:
                mTxtContent.setText(R.string.btn_value_animator_set_with_code);
                mAnimatorSet.start();
                break;
            case R.id.btn_value_animator_set_with_pvh_code:
                mTxtContent.setText(R.string.btn_value_animator_set_with_pvh_code);
                mValueAnimatorSetWithPVHCode.start();
                break;
            default:
                break;
        }
    }
}
