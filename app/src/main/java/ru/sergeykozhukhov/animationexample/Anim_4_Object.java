package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Anim_4_Object extends AppCompatActivity {

    private static final int MODE_XML = 0;
    private static final int MODE_PROPERTY = 1;
    private static final int MODE_PROPERTY_VALUE_HOLDER = 2;

    private static final int DURATION = 1000;

    private int mode;

    private ImageView imageView;

    private List<Animator> animators;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_4_object);

        imageView = findViewById(R.id.anim_4_iv);
        animators = new ArrayList<>();

        mode = MODE_XML;
        float translationY = 150f;

        switch (mode) {
            case MODE_XML:

                ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflaterCompat.loadAnimator(this, R.animator.anim_4_example);
                objectAnimator.setTarget(imageView);
                animators.add(objectAnimator);

                break;
            case MODE_PROPERTY:

                ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
                rotation.setRepeatCount(ObjectAnimator.INFINITE);
                rotation.setRepeatMode(ObjectAnimator.REVERSE);
                rotation.setDuration(DURATION);
                animators.add(rotation);

                ObjectAnimator translation = ObjectAnimator.ofFloat(imageView, "translationY", 0f, translationY);
                translation.setRepeatCount(ObjectAnimator.INFINITE);
                translation.setRepeatMode(ObjectAnimator.REVERSE);
                translation.setDuration(DURATION);
                animators.add(translation);
                break;

            case MODE_PROPERTY_VALUE_HOLDER:
                PropertyValuesHolder alphaHolder = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0f, translationY);
                PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat(View.ROTATION, 0f, 360f);

                ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(imageView, alphaHolder, rotationHolder);
                objectAnimator1.setDuration(DURATION);
                objectAnimator1.setRepeatCount(ObjectAnimator.INFINITE);
                objectAnimator1.setRepeatMode(ObjectAnimator.REVERSE);

                animators.add(objectAnimator1);
                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        for(Animator animator : animators){
            animator.start();
        }
    }

    @Override
    protected void onStop() {
        for(Animator animator : animators){
            animator.end();
        }
        super.onStop();

    }
}
