package hh.com.animationdemo.animation.evaluator;

import android.animation.TypeEvaluator;

import hh.com.animationdemo.view.acitivty.MainActivity;
import hh.com.animationdemo.widget.PositionView;

/**
 * Copyright 2017-2018 Nextev Developments.
 * All rights reserved.
 * <p>
 * Description :
 * History :
 * v1.0, 2017-02-21,  herb.he, create
 */
public class PositionEvaluator implements TypeEvaluator {
    // 创建PositionView对象，用来调用createPoint()方法创建当前PositionPoint对象
    PositionView positionView = new PositionView(MainActivity.context, null);

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        // 将startValue, endValue强转成PositionView.PositionPoint对象
        PositionView.PositionPoint point = (PositionView.PositionPoint) startValue;
        // 获取起始点Y坐标
        float startY = point.getY();
        // 计算当前x,y坐标
        float currentX = getCurrentX(fraction);
        float currentY = getCurrentY(fraction, startY);
        return positionView.createPoint(currentX, currentY);
    }

    private float getCurrentX(float fraction) {
        float range = 120f; //振幅
        float currentX = 160f + (float)Math.sin((6*fraction) * Math.PI) * range;  //周期为3，因此是6fraction
        return currentX;
    }

    private float getCurrentY(float fraction, float startY) {
        float currentY = startY;
        if (fraction != 0f) {
            currentY = fraction * 400f + 20f;
        }
        return currentY;
    }
}
