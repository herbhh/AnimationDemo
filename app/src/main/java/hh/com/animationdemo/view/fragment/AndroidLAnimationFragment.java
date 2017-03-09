package hh.com.animationdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import hh.com.animationdemo.R;

public class AndroidLAnimationFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnTouchFeedback;
    private Button mBtnRevealEffect;
    private Button mBtnActivityTransitions;
    private Button mBtnCurvedMotion;
    private Button mBtnViewStateChanges;
    private Button mBtnAnimateVectorDrawables;

    private AlphaAnimation mAlphaAnimation;
    private ScaleAnimation mScaleAnimation;
    private TranslateAnimation mTranslateAnimation;
    private RotateAnimation mRotateAnimation;
    private AnimationSet mSetAnimation;

    private static volatile AndroidLAnimationFragment instance;

    public static AndroidLAnimationFragment getInstance() {
        if (instance == null) {
            synchronized (AndroidLAnimationFragment.class) {
                if (instance == null) {
                    instance = new AndroidLAnimationFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android_l_animation, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mBtnTouchFeedback = (Button) view.findViewById(R.id.btn_touch_feedback);
        mBtnRevealEffect = (Button) view.findViewById(R.id.btn_reveal_effect);
        mBtnActivityTransitions = (Button) view.findViewById(R.id.btn_activity_transitions);
        mBtnCurvedMotion = (Button) view.findViewById(R.id.btn_curved_motion);
        mBtnViewStateChanges = (Button) view.findViewById(R.id.btn_view_state_changes);
        mBtnAnimateVectorDrawables = (Button) view.findViewById(R.id.btn_animate_vector_drawables);
        mBtnTouchFeedback.setOnClickListener(this);
        mBtnRevealEffect.setOnClickListener(this);
        mBtnActivityTransitions.setOnClickListener(this);
        mBtnCurvedMotion.setOnClickListener(this);
        mBtnViewStateChanges.setOnClickListener(this);
        mBtnAnimateVectorDrawables.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_touch_feedback:
                mContext.startFragment(TouchFeedbackFragment.getInstance(), getInstance());
                break;
            case R.id.btn_reveal_effect:
                mContext.startFragment(RevealEffectFragment.getInstance(), getInstance());
                break;
            case R.id.btn_activity_transitions:
                mContext.startFragment(ActivityTransitionsFragment.getInstance(), getInstance());
                break;
            case R.id.btn_curved_motion:
                mContext.startFragment(CurvedMotionFragment.getInstance(), getInstance());
                break;
            case R.id.btn_view_state_changes:
                mContext.startFragment(ViewStateChangesFragment.getInstance(), getInstance());
                break;
            case R.id.btn_animate_vector_drawables:
                mContext.startFragment(AnimateVectorDrawablesFragment.getInstance(), getInstance());
                break;
            default:
                break;
        }
    }
}
