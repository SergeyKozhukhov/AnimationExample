package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;

import ru.sergeykozhukhov.animationexample.custom_view.FinanceProgressView;

public class Anim_5_Custom extends AppCompatActivity {

    private static final int MODE_XML = 0;
    private static final int MODE_PROPERTY = 1;

    private static final int DURATION = 2500;

    private int mode;

    ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_5_custom);

        FinanceProgressView financeProgressView = findViewById(R.id.anim_5_fp);

        mode = MODE_XML;
        switch (mode) {
            case MODE_XML:
                objectAnimator = (ObjectAnimator) AnimatorInflaterCompat.loadAnimator(this, R.animator.anim_5_example);
                objectAnimator.setTarget(financeProgressView);
                break;
            case MODE_PROPERTY:
                objectAnimator = ObjectAnimator.ofInt(financeProgressView, "progress", 10, 75);
                objectAnimator.setDuration(DURATION);
                objectAnimator.setInterpolator(new BounceInterpolator());
                objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
                objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
                objectAnimator.setTarget(financeProgressView);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        objectAnimator.start();
    }

    @Override
    protected void onStop() {
        objectAnimator.end();
        super.onStop();
    }
}
