package mao.com.myanimation;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "maoTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void frameAnimation(View v) {
        startActivity(new Intent(this, FrameAniActivity.class));
    }

    public void tweenAnimation(View v) {
        startActivity(new Intent(this, TweenAniActivity.class));
    }

    public void propertyAnimation(View v) {
        startActivity(new Intent(this, PropertyAnimation.class));
    }

    public void propertyAdvanceAnimation(View v) {
        startActivity(new Intent(this, PropertyAdvanceAnimation.class));
    }

    private void test() {
        String localPath = getExternalCacheDir().getPath() + "/maolin/";
        File file = new File(getExternalCacheDir().getPath() + "/maolin/");
        if (!file.exists()) {
            file.mkdirs();
        }
        File f = new File(file, "ha.txt");
        try {

            FileOutputStream out = new FileOutputStream(f);
            String str = "this is a test";
            out.write(str.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "onCreate: " + f.renameTo(new File(getExternalCacheDir().getPath() + "/maolin/wa.java")));

        File file1 = new File(Environment.getExternalStorageDirectory() + "/mao/");
        if (!file1.exists()) {
            file1.mkdirs();
        }
        File d = new File(file1, "test.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(d);
            String s = "123465fdkfjdskfjsdklf家的看法接口的";
            try {
                fileOutputStream.write(s.getBytes());
                fileOutputStream.close();
                Log.d(TAG, "onCreate: " + d.renameTo(new File(Environment.getExternalStorageDirectory() + "/mao/shu.java")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
