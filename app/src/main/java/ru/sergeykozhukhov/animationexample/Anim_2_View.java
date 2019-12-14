package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Anim_2_View extends AppCompatActivity {

    private static final int MODE_XML = 0;
    private static final int MODE_PROPERTY = 1;

    private static final int DURATION = 2000;

    private int mode;

    private ImageView imageView;
    private Animation animation;
    private AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_2_view);

        imageView = findViewById(R.id.anim_2_iv);

        mode = MODE_XML;
        switch (mode) {
            case MODE_XML:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_2_example);
                break;
            case MODE_PROPERTY:

                AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                alphaAnimation.setRepeatMode(Animation.REVERSE);
                alphaAnimation.setRepeatCount(Animation.INFINITE);
                alphaAnimation.setDuration(DURATION);

                ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f);
                scaleAnimation.setRepeatMode(Animation.REVERSE);
                scaleAnimation.setRepeatCount(Animation.INFINITE);
                scaleAnimation.setDuration(DURATION);

                RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f);
                rotateAnimation.setRepeatMode(Animation.REVERSE);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                rotateAnimation.setDuration(DURATION);

                TranslateAnimation translateAnimation = new TranslateAnimation(200f, 200f, 200f, 300f);
                translateAnimation.setRepeatMode(Animation.REVERSE);
                translateAnimation.setRepeatCount(Animation.INFINITE);
                translateAnimation.setDuration(DURATION);

                animationSet = new AnimationSet(false);
                animationSet.addAnimation(alphaAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                break;

        }
    }

    @Override
    protected void onStop() {
        imageView.clearAnimation();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mode == MODE_XML)
            imageView.startAnimation(animation);
        else
            imageView.startAnimation(animationSet);

    }

}
