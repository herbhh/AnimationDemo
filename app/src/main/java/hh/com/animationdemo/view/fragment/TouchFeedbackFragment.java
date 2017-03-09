package hh.com.animationdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hh.com.animationdemo.R;

public class TouchFeedbackFragment extends BaseFragment {

    private static volatile TouchFeedbackFragment instance;

    public static TouchFeedbackFragment getInstance() {
        if (instance == null) {
            synchronized (TouchFeedbackFragment.class) {
                if (instance == null) {
                    instance = new TouchFeedbackFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_touch_feedback, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
