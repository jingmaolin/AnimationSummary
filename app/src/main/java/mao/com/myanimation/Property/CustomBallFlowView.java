package mao.com.myanimation.Property;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * Description ：自定义小球滚动动画
 * Created by jingmaolin on 2018/8/8.
 * Job number：600029
 */
public class CustomBallFlowView extends View {
    private Paint mPaint;
    private PointBean mPoint;
    private float mDensity;
    private int mRadius;

    public CustomBallFlowView(Context context) {
        this(context, null);
    }

    public CustomBallFlowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomBallFlowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
        initPaint();
    }

    private void initData() {
        mDensity = getResources().getDisplayMetrics().density;
        mRadius = (int) (mDensity * 15);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint == null) {
            mPoint = new PointBean(mRadius, mRadius);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(mPoint.getPointX(), mPoint.getPointY(), mRadius, mPaint);
    }

    private void startAnimation() {
        PointBean startPoint = new PointBean(mRadius, mRadius);
        PointBean endPoint = new PointBean(getWidth() - mRadius, getHeight() - mRadius);
        ValueAnimator mAnimator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPoint = (PointBean) animation.getAnimatedValue();
                invalidate();
            }
        });

        ValueAnimator valueAnimator = ValueAnimator.ofObject(new ColorEvaluator(), Color.BLUE, Color.GREEN, Color.RED);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color = (int) animation.getAnimatedValue();
                mPaint.setColor(color);
                invalidate();
            }
        });

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(mAnimator, valueAnimator);
        animatorSet.setInterpolator(new DecelerateAccelerateInterpolator());
        animatorSet.setDuration(2000);
        animatorSet.start();
    }
}
