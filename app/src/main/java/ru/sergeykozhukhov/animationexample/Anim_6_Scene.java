package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;

public class Anim_6_Scene extends AppCompatActivity {

    private static final int MODE_XML = 0;
    private static final int MODE_PROPERTY = 1;

    private static final int DURATION = 1500;

    private static int SCENE_1 = 0;
    private static int SCENE_2 = 1;

    private int modeLoad;
    private int modeScene;

    int targetScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_6_scene);

        final FrameLayout scene_container = findViewById(R.id.anim_6_fl_scene_container);

        modeScene = SCENE_1;

        modeLoad = MODE_XML;

        findViewById(R.id.anim_6_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (modeLoad) {
                    case MODE_XML:
                        nextScene();
                        TransitionInflater transitionInflater = TransitionInflater.from(Anim_6_Scene.this);
                        TransitionManager transitionManager = transitionInflater.inflateTransitionManager(R.transition.anim_6_example_transition_manager, scene_container);
                        Scene nextScene = Scene.getSceneForLayout(scene_container, targetScene, Anim_6_Scene.this);
                        transitionManager.transitionTo(nextScene);
                        break;
                    case MODE_PROPERTY:
                        nextScene();
                        Transition transition = new ChangeBounds();
                        transition.setDuration(DURATION);
                        Scene finalScene = Scene.getSceneForLayout(scene_container, targetScene, Anim_6_Scene.this);
                        TransitionManager.go(finalScene, transition);
                        break;
                }

            }
        });

    }

    private void nextScene(){
        if (modeScene == SCENE_1) {
            targetScene = R.layout.anim_6_example_scene_2;
            modeScene = SCENE_2;
        } else {
            targetScene = R.layout.anim_6_example_scene_1;
            modeScene = SCENE_1;
        }
    }
}

