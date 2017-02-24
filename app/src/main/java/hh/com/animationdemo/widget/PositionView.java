package hh.com.animationdemo.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import hh.com.animationdemo.animation.evaluator.PositionEvaluator;
import hh.com.animationdemo.animation.interpolator.DeceAcceInterpolator;

/**
 * Copyright 2017-2018 Nextev Developments.
 * All rights reserved.
 * <p>
 * Description :
 * History :
 * v1.0, 2017-02-21,  herb.he, create
 */
public class PositionView extends View {

    public static final float RADIUS = 20f;
    private PositionPoint currentPoint;
    private Paint mPaint;

    public PositionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (currentPoint == null) {
            currentPoint = new PositionPoint(RADIUS, RADIUS);
            drawCircle(canvas);
            startPropertyAni();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    /**
     * 启动动画
     */
    private void startPropertyAni() {
        ValueAnimator animator = ValueAnimator.ofObject(
                new PositionEvaluator(),
                createPoint(RADIUS, RADIUS),
                createPoint(getWidth() - RADIUS, getHeight() - RADIUS));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PositionPoint) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setInterpolator(new DeceAcceInterpolator());
        animator.setDuration(10 * 1000).start();
    }

    /**
     * 创建PositionPointView对象
     * @param x
     * @param y
     * @return
     */
    public PositionPoint createPoint(float x, float y) {
        return new PositionPoint(x, y);
    }

    /**
     * 小圆点内部类
     */
    public class PositionPoint {
        private float x;
        private float y;

        public PositionPoint(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }
    }
}
