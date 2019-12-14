package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Anim_8_Transition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_8_transition);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()){
              overridePendingTransition(R.anim.anim_8_example_enter_from_top_left, R.anim.anim_8_example_exit_from_top_left_to_right_down);
        }
    }
}
