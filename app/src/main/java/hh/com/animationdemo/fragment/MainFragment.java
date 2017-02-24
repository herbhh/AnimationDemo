package hh.com.animationdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hh.com.animationdemo.R;

public class MainFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnTweenAnimation;
    private Button mBtnFrameAnimation;
    private Button mBtnPropertyAnimation;

    private static volatile MainFragment instance;

    public static MainFragment getInstance() {
        if (instance == null) {
            synchronized (MainFragment.class) {
                if (instance == null) {
                    instance = new MainFragment();
                }
            }
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mBtnTweenAnimation = (Button) view.findViewById(R.id.btn_tween_animation);
        mBtnFrameAnimation = (Button) view.findViewById(R.id.btn_frame_animation);
        mBtnPropertyAnimation = (Button) view.findViewById(R.id.btn_property_animation);
        mBtnTweenAnimation.setOnClickListener(this);
        mBtnFrameAnimation.setOnClickListener(this);
        mBtnPropertyAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tween_animation:
                mContext.startFragment(TweenAnimationFragment.getInstance(), getInstance());
                break;
            case R.id.btn_frame_animation:
                mContext.startFragment(FrameAnimationFragment.getInstance(), getInstance());
                break;
            case R.id.btn_property_animation:
                mContext.startFragment(PropertyAnimationFragment.getInstance(), getInstance());
                break;
            default:
                break;
        }
    }

}
