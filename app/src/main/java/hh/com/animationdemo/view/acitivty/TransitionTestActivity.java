package hh.com.animationdemo.view.acitivty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import hh.com.animationdemo.R;

/**
 * Copyright 2017-2018 Nextev Developments.
 * All rights reserved.
 * <p>
 * Description :
 * History :
 * v1.0, 2017-02-28,  herb.he, create
 */
public class TransitionTestActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCommonTransitionBack;
    private LinearLayout mLayoutSharedTransitionBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_transitions_test);
        initView();
    }

    private void initView() {
        btnCommonTransitionBack = (Button) findViewById(R.id.btn_common_transition_back);
        mLayoutSharedTransitionBack = (LinearLayout) findViewById(R.id.layout_shared_transition_back);
        btnCommonTransitionBack.setOnClickListener(this);
        mLayoutSharedTransitionBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_common_transition_back:
                finish();
                break;
            case R.id.layout_shared_transition_back:
                finishAfterTransition();
                break;
            default:
                break;
        }
    }
}
