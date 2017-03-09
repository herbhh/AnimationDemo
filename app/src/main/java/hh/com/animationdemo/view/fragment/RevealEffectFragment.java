package hh.com.animationdemo.view.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import hh.com.animationdemo.R;


public class RevealEffectFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnRevealShow;
    private Button mBtnRevealHide;
    private ImageView mImgReveal;

    private static volatile RevealEffectFragment instance;

    public static RevealEffectFragment getInstance() {
        if (instance == null) {
            synchronized (RevealEffectFragment.class) {
                if (instance == null) {
                    instance = new RevealEffectFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reveal_effect, container, false);
        initView(view);
        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    protected void initView(View view) {
        mImgReveal = (ImageView) view.findViewById(R.id.img_reveal);
        mBtnRevealShow = (Button) view.findViewById(R.id.btn_reveal_show);
        mBtnRevealHide = (Button) view.findViewById(R.id.btn_reveal_hide);
        mBtnRevealShow.setOnClickListener(this);
        mBtnRevealHide.setOnClickListener(this);
    }

    private void showView(View view) {
        // get the center for the clipping circle
        int cx = (view.getLeft() + view.getRight()) / 2;
        int cy = (view.getTop() + view.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(view.getWidth(), view.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(2000);

        // make the view visible and start the animation
        view.setVisibility(View.VISIBLE);
        anim.start();
    }

    private void hideView(final View view) {
        // get the center for the clipping circle
        int cx = (view.getLeft() + view.getRight()) / 2;
        int cy = (view.getTop() + view.getBottom()) / 2;

        // get the initial radius for the clipping circle
        int initialRadius = view.getWidth();

        // create the animation (the final radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(2000);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });

        // start the animation
        anim.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reveal_show:
                if (mImgReveal != null)
                    showView(mImgReveal);
                break;
            case R.id.btn_reveal_hide:
                if (mImgReveal != null)
                    hideView(mImgReveal);
                break;
            default:
                break;
        }
    }
}
