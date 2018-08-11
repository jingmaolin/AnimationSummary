package mao.com.myanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/**
 * Description:帧动画 (注意在onCreate中直接调用动画的话不会起作用，view可能未初始化完毕)
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/7/25.
 */
public class FrameAniActivity extends Activity {
    private AnimationDrawable anim;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView imageView = findViewById(R.id.imageView);
                anim = (AnimationDrawable) imageView.getBackground();
                anim.start();
            }
        }, 100);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        anim.stop();
        anim = null;
    }
}
