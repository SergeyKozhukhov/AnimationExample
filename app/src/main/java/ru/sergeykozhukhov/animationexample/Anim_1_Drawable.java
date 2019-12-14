package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Anim_1_Drawable extends AppCompatActivity {

    private static final int MODE_XML = 0;
    private static final int MODE_PROPERTY = 1;

    private static final int DURATION = 100;

    private int mode;


    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_1_drawable);

        imageView = findViewById(R.id.anim_1_iv);
        animationDrawable = new AnimationDrawable();

        mode = MODE_XML;
        switch (mode){
            case MODE_XML:
                animationDrawable = (AnimationDrawable)getResources().getDrawable(R.drawable.anim_1_example_horse, null);
                imageView.setBackground(animationDrawable);
                break;
            case MODE_PROPERTY:
                animationDrawable.setOneShot(false); // циклическое повторение
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse0), DURATION);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse1), DURATION);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse2), DURATION);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse3), DURATION);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse4), DURATION);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse5), DURATION);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse6), DURATION);
                animationDrawable.addFrame(getResources().getDrawable(R.drawable.horse7), DURATION);
                imageView.setBackground(animationDrawable);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        animationDrawable.start();
    }

    @Override
    protected void onStop() {
        animationDrawable.stop();
        super.onStop();
    }
}
