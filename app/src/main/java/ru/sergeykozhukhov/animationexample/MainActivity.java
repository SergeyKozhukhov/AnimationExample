package ru.sergeykozhukhov.animationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View iv_main;

    private Button btn_anim_1;
    private Button btn_anim_2;
    private Button btn_anim_3;
    private Button btn_anim_4;
    private Button btn_anim_5;
    private Button btn_anim_6;
    private View btn_anim_7;
    private Button btn_anim_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_main = findViewById(R.id.main_iv);

        btn_anim_1 = findViewById(R.id.main_btn_to_anim_1);
        btn_anim_1.setOnClickListener(this);

        btn_anim_2 = findViewById(R.id.main_btn_to_anim_2);
        btn_anim_2.setOnClickListener(this);

        btn_anim_3 = findViewById(R.id.main_btn_to_anim_3);
        btn_anim_3.setOnClickListener(this);

        btn_anim_4 = findViewById(R.id.main_btn_to_anim_4);
        btn_anim_4.setOnClickListener(this);

        btn_anim_5 = findViewById(R.id.main_btn_to_anim_5);
        btn_anim_5.setOnClickListener(this);

        btn_anim_6 = findViewById(R.id.main_btn_to_anim_6);
        btn_anim_6.setOnClickListener(this);

        btn_anim_7 = findViewById(R.id.main_btn_to_anim_7);
        btn_anim_7.setOnClickListener(this);

        btn_anim_8 = findViewById(R.id.main_btn_to_anim_8);
        btn_anim_8.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.main_btn_to_anim_1: {
                i = new Intent(this, Anim_1_Drawable.class);
                startActivity(i);
                break;
            }
            case R.id.main_btn_to_anim_2: {
                i = new Intent(this, Anim_2_View.class);
                startActivity(i);
                break;
            }
            case R.id.main_btn_to_anim_3: {
                i = new Intent(this, Anim_3_Value.class);
                startActivity(i);
                break;
            }
            case R.id.main_btn_to_anim_4: {
                i = new Intent(this, Anim_4_Object.class);
                startActivity(i);
                break;
            }
            case R.id.main_btn_to_anim_5: {
                i = new Intent(this, Anim_5_Custom.class);
                startActivity(i);
                break;
            }
            case R.id.main_btn_to_anim_6: {
                i = new Intent(this, Anim_6_Scene.class);
                startActivity(i);
                break;
            }

            case R.id.main_btn_to_anim_7: {

                String transitionNameIv = getString(R.string.main_to_anim_7_iv_transition_name);
                String transitionNameBtn = getString(R.string.main_to_anim_7_btn_transition_name);

                iv_main.setTransitionName(transitionNameIv);
                btn_anim_7.setTransitionName(transitionNameBtn);

                Pair<View, String> pair1 = Pair.create(iv_main, iv_main.getTransitionName());
                Pair<View, String> pair2 = Pair.create(btn_anim_7, btn_anim_7.getTransitionName());

                i = new Intent(this, Anim_7_SharedElement.class);
                final ActivityOptions options = ActivityOptions.
                        makeSceneTransitionAnimation(this, pair1, pair2);
                startActivity(i, options.toBundle());

                break;
            }

            case R.id.main_btn_to_anim_8: {

                /*Bitmap thumbnail= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                ActivityOptionsCompat options_with_drawable = ActivityOptionsCompat.makeThumbnailScaleUpAnimation(btn_anim_8, thumbnail, 100, 100);*/

                ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(
                        this,
                        R.anim.anim_8_example_enter_from_bottom_right,
                        R.anim.anim_8_example_exit_from_top_left_to_left_up
                );
                i = new Intent(this, Anim_8_Transition.class);
                startActivity(i, options.toBundle());
                break;
            }
        }
    }
}
