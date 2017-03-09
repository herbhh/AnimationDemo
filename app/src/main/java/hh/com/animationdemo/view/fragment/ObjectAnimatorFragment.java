package hh.com.animationdemo.view.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import hh.com.animationdemo.R;

public class ObjectAnimatorFragment extends BaseFragment implements View.OnClickListener {

    private TextView mTxtContent;
    private Button mBtnObjectAnimatorWithXml;
    private Button mBtnObjectAnimatorSetWithXml;
    private Button mBtnObjectAnimatorWithCode;
    private Button mBtnObjectAnimatorSetWithCode;
    private Button mBtnObjectAnimatorSetWithPVHCode;

    private Animator mAnimator;
    private Animator mAnimatorSetWithXml;
    private ObjectAnimator mObjectAnimator;
    private AnimatorSet mAnimatorSet;
    private ObjectAnimator mObjectAnimatorPropertyValuesHolder;

    private static volatile ObjectAnimatorFragment instance;

    public static ObjectAnimatorFragment getInstance() {
        if (instance == null) {
            synchronized (ObjectAnimatorFragment.class) {
                if (instance == null) {
                    instance = new ObjectAnimatorFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_object_animator, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mTxtContent = (TextView) view.findViewById(R.id.txt_object);
        mBtnObjectAnimatorWithXml = (Button) view.findViewById(R.id.btn_object_animator_with_xml);
        mBtnObjectAnimatorSetWithXml = (Button) view.findViewById(R.id.btn_object_animator_set_with_xml);
        mBtnObjectAnimatorWithCode = (Button) view.findViewById(R.id.btn_object_animator_with_code);
        mBtnObjectAnimatorSetWithCode = (Button) view.findViewById(R.id.btn_object_animator_set_with_code);
        mBtnObjectAnimatorSetWithPVHCode = (Button) view.findViewById(R.id.btn_object_animator_set_with_pvh_code);
        mBtnObjectAnimatorWithXml.setOnClickListener(this);
        mBtnObjectAnimatorSetWithXml.setOnClickListener(this);
        mBtnObjectAnimatorWithCode.setOnClickListener(this);
        mBtnObjectAnimatorSetWithCode.setOnClickListener(this);
        mBtnObjectAnimatorSetWithPVHCode.setOnClickListener(this);

        // with xml
        mAnimator = AnimatorInflater.loadAnimator(mContext, R.animator.object_animator);
        mAnimator.setTarget(mTxtContent);

        // animator set with xml
        mAnimatorSetWithXml = AnimatorInflater.loadAnimator(mContext, R.animator.object_animator_set);
        mAnimatorSetWithXml.setTarget(mTxtContent);

        // with code
        mObjectAnimator = ObjectAnimator.ofFloat(mTxtContent, "alpha", 1.0f, 0.3f, 1.0f);
        mObjectAnimator.setDuration(2000);  //动画时间
        mObjectAnimator.setInterpolator(new BounceInterpolator());//动画插值
        mObjectAnimator.setRepeatCount(-1);//设置动画重复次数
        mObjectAnimator.setRepeatMode(ValueAnimator.RESTART);//动画重复模式
        mObjectAnimator.setStartDelay(1000);//动画延时执行

        // animator set with code
        ObjectAnimator animator = ObjectAnimator.ofInt(mTxtContent, "backgroundColor", 0xFFFF0000, 0xFFFF00FF);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mTxtContent, "translationX", 0.0f, 200.0f, 0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mTxtContent, "scaleX", 1.0f, 2.0f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mTxtContent, "rotationX", 0.0f, 90.0f, 0.0F);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mTxtContent, "alpha", 1.0f, 0.2f, 1.0F);
        mAnimatorSet = new AnimatorSet();
        mAnimatorSet.play(animator).with(animator1).before(animator2).before(animator3).after(animator4);
        mAnimatorSet.setDuration(5000);

        // PropertyValuesHolder set with code
        PropertyValuesHolder valuesHolder = PropertyValuesHolder.ofFloat("translationX", 0.0f, 300.0f);
        PropertyValuesHolder valuesHolder1 = PropertyValuesHolder.ofFloat("rotationX", 0.0f, 90.0f, 0.0f);
        PropertyValuesHolder valuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.5f);
        PropertyValuesHolder valuesHolder3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.3f, 1.0f);
        mObjectAnimatorPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(mTxtContent,
                valuesHolder, valuesHolder1, valuesHolder2,valuesHolder3);
        mObjectAnimatorPropertyValuesHolder.setDuration(2000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_object_animator_with_xml:
                mTxtContent.setText(R.string.btn_object_animator_with_xml);
                mAnimator.start();
                break;
            case R.id.btn_object_animator_set_with_xml:
                mTxtContent.setText(R.string.btn_object_animator_set_with_xml);
                mAnimatorSetWithXml.start();
                break;
            case R.id.btn_object_animator_with_code:
                mTxtContent.setText(R.string.btn_object_animator_with_code);
                mObjectAnimator.start();
                break;
            case R.id.btn_object_animator_set_with_code:
                mTxtContent.setText(R.string.btn_object_animator_set_with_code);
                mAnimatorSet.start();
                break;
            case R.id.btn_object_animator_set_with_pvh_code:
                mTxtContent.setText(R.string.btn_object_animator_set_with_pvh_code);
                mObjectAnimatorPropertyValuesHolder.start();
                break;
            default:
                break;
        }
    }
}
