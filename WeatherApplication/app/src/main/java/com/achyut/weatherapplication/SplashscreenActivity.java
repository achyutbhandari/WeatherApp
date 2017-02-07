package com.achyut.weatherapplication;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashscreenActivity extends AppCompatActivity {

   /* public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }*/

    /**
     * Called when the activity is first created.
     */
    Thread splashTread;
    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("..Splash Screen", "OnCreate is called");
        setContentView(R.layout.activity_splashscreen);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        anim.reset();
        LinearLayout l = (LinearLayout) findViewById(R.id.lin_lay);
         l.clearAnimation();
         l.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent(SplashscreenActivity.this,
                            MainActivity.class);
                   /* intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);*/

                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in, R.anim.side_out);

                    SplashscreenActivity.this.finish();
                } catch (Exception e) {
                    // do nothing
                } finally {
                    SplashscreenActivity.this.finish();
                }
            }
        };
        splashTread.start();


    }


}
