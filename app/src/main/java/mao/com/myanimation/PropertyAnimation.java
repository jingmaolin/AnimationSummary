package mao.com.myanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Description: 属性动画
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/7/26.
 */
public class PropertyAnimation extends Activity {
    private ImageView imageView;
    private RelativeLayout relativeLayout;
    private static final String TAG = "maoTest";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        imageView = findViewById(R.id.imageView);
        relativeLayout = findViewById(R.id.relativeLayout);
    }

    private void setViewLocation(View v, int width, int height) {
        int left = width - v.getWidth() / 2;
        int right = width + v.getWidth() / 2;
        int top = height - v.getHeight() / 2;
        int bottom = height + v.getHeight() / 2;
        v.layout(left, top, right, bottom);
    }

    public void upAndDown(View v) {
        int height = relativeLayout.getHeight();
        final int width = relativeLayout.getWidth();

        ValueAnimator animator = ValueAnimator.ofFloat(0, height, height / 2);
        animator.setInterpolator(new OvershootInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float y = (float) animation.getAnimatedValue();
                setViewLocation(imageView, width / 2, (int) y);
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    public void zoomInOut(View v) {
        ValueAnimator animator = ValueAnimator.ofFloat(1f, 0.5f, 2f, 3f, 1f);
        animator.setDuration(2000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float scale = (float) animation.getAnimatedValue();
                imageView.setScaleX(scale);
                imageView.setScaleY(scale);
            }
        });
        animator.start();
    }

    public void rotate(View v) {
        final int radius = relativeLayout.getWidth() / 4;
        ValueAnimator animator = ValueAnimator.ofFloat(0, 360);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float t = (float) animation.getAnimatedValue();
                double x = (radius * Math.cos(Math.toRadians(t))) + relativeLayout.getWidth() / 2;
                double y = radius * Math.sin(Math.toRadians(t)) + relativeLayout.getHeight() / 2;
                Log.d(TAG, "onAnimationUpdate: " + "t= " + t + " ;" + "sint=" + Math.sin(Math.toRadians(t)) + " ;x= " + x + " ;y= " + y);
                setViewLocation(imageView, (int) x, (int) y);
            }
        });
        animator.start();
    }

    public void alpha(View v) {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator animator = ValueAnimator.ofFloat(0.5f, 1);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView.setAlpha((Float) animation.getAnimatedValue());
            }
        });
        ValueAnimator animator1 = ValueAnimator.ofFloat(1, 2);
        animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView.setScaleX((Float) animation.getAnimatedValue());
                imageView.setScaleY((Float) animation.getAnimatedValue());
            }
        });
        animatorSet.setDuration(2000).playTogether(animator, animator1);
        animatorSet.start();
    }

    public void upAndDown_o(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY",
                relativeLayout.getHeight() / 2, -relativeLayout.getHeight() / 4);
        animator.setDuration(2500);
        animator.start();
    }

    public void zoomInOut_o(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "scaleX",
                1, 2, 1);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "scaleY", 1, 2, 1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator1);
        animatorSet.setDuration(2500);
        animator.start();
    }

    public void rotate_o(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation",
                0, 360);
        animator.setDuration(2500);
        animator.start();
    }

    public void alpha_o(View v) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha",
                0.5f, 1, 0.5f, 1);
        animator.setDuration(2500);
        animator.start();
    }
}
