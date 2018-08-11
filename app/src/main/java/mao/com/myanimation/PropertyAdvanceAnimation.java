package mao.com.myanimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import mao.com.myanimation.Property.CustomBallFlowView;

/**
 * Description ：属性动画的高级应用
 * Created by jingmaolin on 2018/8/8.
 * Job number：600029
 */

public class PropertyAdvanceAnimation extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_advance);
    }

    public void evaluator(View v) {
        CustomBallFlowView customBallFlow = findViewById(R.id.evaluator);
        customBallFlow.setVisibility(View.VISIBLE);
    }

    public void interpolator(View v) {

    }
}
