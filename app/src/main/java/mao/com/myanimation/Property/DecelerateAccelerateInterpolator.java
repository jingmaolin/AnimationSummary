package mao.com.myanimation.Property;

import android.animation.TimeInterpolator;

/**
 * Description:自定义 补间器 （用于控制起点到终点的完成度）
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/8/8.
 */
public class DecelerateAccelerateInterpolator implements TimeInterpolator{
    @Override
    public float getInterpolation(float input) {
        if (input < 0.5) {
            return (float) (Math.sin(input * Math.PI) / 2);
        } else {
            return 1 - (float) (Math.sin(input * Math.PI) / 2);
        }
    }
}
