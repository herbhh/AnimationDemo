package hh.com.animationdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hh.com.animationdemo.R;

public class PropertyAnimationFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnObjectAnimator;
    private Button mBtnValueAnimator;
    private Button mBtnInterpolator;
    private Button mBtnTypeEvaluator;

    private static volatile PropertyAnimationFragment instance;

    public static PropertyAnimationFragment getInstance() {
        if (instance == null) {
            synchronized (PropertyAnimationFragment.class) {
                if (instance == null) {
                    instance = new PropertyAnimationFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property_animation, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mBtnObjectAnimator = (Button) view.findViewById(R.id.btn_object_animator);
        mBtnValueAnimator = (Button) view.findViewById(R.id.btn_value_animator);
        mBtnInterpolator = (Button) view.findViewById(R.id.btn_interpolator);
        mBtnTypeEvaluator = (Button) view.findViewById(R.id.btn_type_evaluator);
        mBtnObjectAnimator.setOnClickListener(this);
        mBtnValueAnimator.setOnClickListener(this);
        mBtnInterpolator.setOnClickListener(this);
        mBtnTypeEvaluator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_object_animator:
                mContext.startFragment(ObjectAnimatorFragment.getInstance(), getInstance());
                break;
            case R.id.btn_value_animator:
                mContext.startFragment(ValueAnimatorFragment.getInstance(), getInstance());
                break;
            case R.id.btn_interpolator:
                mContext.startFragment(CustomInterpolatorFragment.getInstance(), getInstance());
                break;
            case R.id.btn_type_evaluator:
                mContext.startFragment(CustomEvaluatorFragment.getInstance(), getInstance());
                break;
            default:
                break;
        }
    }
}
