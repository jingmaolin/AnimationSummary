package mao.com.myanimation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Description: 补间动画
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/7/25.
 * 参考资料：http://wiki.jikexueyuan.com/project/android-animation/1.html
 */
public class TweenAniActivity extends Activity {
    private static final String TAG = "maoTest";
    private TextView textView;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void scale(View v) {
        animation = AnimationUtils.loadAnimation(this, R.anim.scale);
        textView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d(TAG, "onAnimationRepeat: ");
            }
        });
    }

    public void alpha(View v) {
        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        textView.startAnimation(animation);
    }

    public void rotate(View v) {
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        textView.startAnimation(animation);
    }

    public void translate(View v) {
        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        textView.startAnimation(animation);
    }

    public void showAll(View v) {
        animation = AnimationUtils.loadAnimation(this, R.anim.tween_all_type);
        textView.startAnimation(animation);
    }
}
