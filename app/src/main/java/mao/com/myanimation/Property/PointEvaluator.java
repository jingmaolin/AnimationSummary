package mao.com.myanimation.Property;

import android.animation.TypeEvaluator;

/**
 * Description ：自定义计算器 （可规定起点到终点的轨迹）
 * Created by jingmaolin on 2018/8/8.
 * Phone ：13342446520
 */

public class PointEvaluator implements TypeEvaluator<PointBean> {
    @Override
    public PointBean evaluate(float fraction, PointBean startValue, PointBean endValue) {
        int x = startValue.getPointX() + (int) (fraction * (endValue.getPointX() - startValue.getPointX()));
        int y = startValue.getPointY() + (int) (fraction * (endValue.getPointY() - startValue.getPointY()));
        return new PointBean(x, y);
    }
}
