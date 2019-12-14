package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Anim_3_Value extends AppCompatActivity {

    private static final int MODE_XML = 0;
    private static final int MODE_PROPERTY = 1;
    private static final int MODE_PROPERTY_VALUE_HOLDER = 2;

    private static final int DURATION = 1000;

    private int mode;

    private List<Animator> animators = new ArrayList<>();

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_3_value);

        imageView = findViewById(R.id.anim_3_iv);

        mode = MODE_PROPERTY_VALUE_HOLDER;
        switch (mode) {
            case MODE_XML:
                ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.anim_3_example);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        imageView.setAlpha((Float) animator.getAnimatedValue());
                    }
                });
                animators.add(valueAnimator);
                break;
            case MODE_PROPERTY:

                ValueAnimator alphaAnimator = ValueAnimator.ofFloat(0f, 1f);
                alphaAnimator.setDuration(DURATION);
                alphaAnimator.setRepeatMode(ValueAnimator.REVERSE);
                alphaAnimator.setRepeatCount(ValueAnimator.INFINITE);
                alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setAlpha((Float) animation.getAnimatedValue());
                    }
                });
                animators.add(alphaAnimator);

                ValueAnimator scaleAnimator = ValueAnimator.ofFloat(0.5f, 1f);
                scaleAnimator.setDuration(DURATION);
                scaleAnimator.setRepeatMode(ValueAnimator.REVERSE);
                scaleAnimator.setRepeatCount(ValueAnimator.INFINITE);
                scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Float scale = (Float) animation.getAnimatedValue();
                        imageView.setScaleX(scale);
                        imageView.setScaleY(scale);
                    }
                });
                animators.add(scaleAnimator);
                break;
            case MODE_PROPERTY_VALUE_HOLDER:
                PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofFloat("alpha", 0f, 1f);
                PropertyValuesHolder scaleHolder = PropertyValuesHolder.ofFloat("scale", 0.5f, 1f);

                ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(alphaHolder, scaleHolder);
                animator.setDuration(DURATION);
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.setRepeatCount(ValueAnimator.INFINITE);

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        imageView.setAlpha((Float)animation.getAnimatedValue("alpha"));
                        Float scale = (Float)animation.getAnimatedValue("scale");
                        imageView.setScaleX(scale);
                        imageView.setScaleY(scale);
                    }
                });
                animators.add(animator);
                break;
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Animator animator : animators) {
                    if (animator.isRunning()) {
                        animator.cancel();
                    } else {
                        animator.start();
                    }
                }
            }
        });
    }


    @Override
    protected void onStop() {
        for (Animator animator : animators) {
            if (animator.isRunning()) {
                animator.cancel();
            }
        }
        super.onStop();
    }

}

