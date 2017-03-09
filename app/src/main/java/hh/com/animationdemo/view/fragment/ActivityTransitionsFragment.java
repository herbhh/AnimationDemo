package hh.com.animationdemo.view.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import hh.com.animationdemo.R;
import hh.com.animationdemo.view.acitivty.TransitionTestActivity;

public class ActivityTransitionsFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnCommonTransitionOpen;
    private ImageView mImgTransition;
    private LinearLayout mLayoutSharedTransitionOpen;

    private static volatile ActivityTransitionsFragment instance;

    public static ActivityTransitionsFragment getInstance() {
        if (instance == null) {
            synchronized (ActivityTransitionsFragment.class) {
                if (instance == null) {
                    instance = new ActivityTransitionsFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_transitions, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mBtnCommonTransitionOpen = (Button) view.findViewById(R.id.btn_common_transition_open);
        mLayoutSharedTransitionOpen = (LinearLayout) view.findViewById(R.id.layout_shared_transition_open);
        mImgTransition = (ImageView) view.findViewById(R.id.img_transition);
        mBtnCommonTransitionOpen.setOnClickListener(this);
        mLayoutSharedTransitionOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), TransitionTestActivity.class);
        switch (view.getId()) {
            case R.id.btn_common_transition_open:
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                break;
            case R.id.layout_shared_transition_open:
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(getActivity(), mImgTransition, "shareImage");
                startActivity(intent, options.toBundle());
                break;
            default:
                break;
        }
    }
}
