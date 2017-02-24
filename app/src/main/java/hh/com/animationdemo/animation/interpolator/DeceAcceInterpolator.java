package hh.com.animationdemo.animation.interpolator;

import android.animation.TimeInterpolator;

/**
 * Copyright 2017-2018 Nextev Developments.
 * All rights reserved.
 * <p>
 * Description : 自定义interpolator-先减速再加速
 * History :
 * v1.0, 2017-02-20,  herb.he, create
 */
public class DeceAcceInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return ((4*input-2)*(4*input-2)*(4*input-2))/16f + 0.5f;
    }
}
