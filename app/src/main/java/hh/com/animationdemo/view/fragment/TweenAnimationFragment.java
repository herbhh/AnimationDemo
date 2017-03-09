package hh.com.animationdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import hh.com.animationdemo.R;

public class TweenAnimationFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnViewAnimationWithXml;
    private Button mBtnViewAnimationWithCode;

    private static volatile TweenAnimationFragment instance;

    public static TweenAnimationFragment getInstance() {
        if (instance == null) {
            synchronized (TweenAnimationFragment.class) {
                if (instance == null) {
                    instance = new TweenAnimationFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tween_animation, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mBtnViewAnimationWithXml = (Button) view.findViewById(R.id.btn_view_animation_with_xml);
        mBtnViewAnimationWithCode = (Button) view.findViewById(R.id.btn_view_animation_with_code);
        mBtnViewAnimationWithXml.setOnClickListener(this);
        mBtnViewAnimationWithCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_view_animation_with_xml:
                mContext.startFragment(TweenAnimationWithXmlFragment.getInstance(), getInstance());
                break;
            case R.id.btn_view_animation_with_code:
                mContext.startFragment(TweenAnimationWithCodeFragment.getInstance(), getInstance());
                break;
            default:
                break;
        }
    }
}
