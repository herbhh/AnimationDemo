package hh.com.animationdemo.view.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import hh.com.animationdemo.R;
import hh.com.animationdemo.animation.evaluator.ColorEvaluator;

public class CustomEvaluatorFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnCustomEvaluator;
    private TextView mTxtCustom;

    private ValueAnimator mAnimator;

    private static volatile CustomEvaluatorFragment instance;

    public static CustomEvaluatorFragment getInstance() {
        if (instance == null) {
            synchronized (CustomEvaluatorFragment.class) {
                if (instance == null) {
                    instance = new CustomEvaluatorFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_type_evaluator, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mBtnCustomEvaluator = (Button) view.findViewById(R.id.btn_custom_type_evaluator);
        mTxtCustom = (TextView) view.findViewById(R.id.txt_custom);
        mBtnCustomEvaluator.setOnClickListener(this);

        // animator set with code
        mAnimator = ObjectAnimator.ofObject(new ColorEvaluator(), "#0000FF", "#FF0000");
        mAnimator.setDuration(5000);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color = (int) animation.getAnimatedValue();
                mTxtCustom.setTextColor(color);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_custom_type_evaluator:
                mAnimator.start();
                break;
            default:
                break;
        }
    }
}
