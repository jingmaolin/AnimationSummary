package mao.com.myanimation.Property;

import android.animation.TypeEvaluator;
import android.graphics.Color;
import android.util.Log;

/**
 * Description ：自定义颜色变更器
 * Created by jingmaolin on 2018/8/8.
 * Job number：600029
 * Phone ：13342446520
 */

public class ColorEvaluator implements TypeEvaluator<Integer> {
    private static final String TAG = "maoTest";

    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int alpha = Color.alpha(startValue) + (int) (fraction * (Color.alpha(endValue) - Color.alpha(startValue)));
        int red = Color.red(startValue) + (int) (fraction * (Color.red(endValue) - Color.red(startValue)));
        int green = Color.green(startValue) + (int) (fraction * (Color.green(endValue) - Color.green(startValue)));
        int blue = Color.blue(startValue) + (int) (fraction * (Color.blue(endValue) - Color.blue(startValue)));
        Log.d(TAG, "evaluate: " + "alpha=" + alpha + "; red = " + red + "; green = " + green + "; blue = " + blue);
        return Color.argb(alpha, red, green, blue);
    }
}
