package tn.loading;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton PlayButton;
    ToggleButton SoundButton;
    ToggleButton LanguageButton;
    CommonMethod commonMethod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlayButton = (ToggleButton) findViewById(R.id.play);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        PlayButton.startAnimation(myAnim);
        commonMethod = new CommonMethod();
        commonMethod.SoundPlayer(this, R.raw.happyclapp);


        final Drawable playBackg = PlayButton.getBackground();

        PlayButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    PlayButton.setBackgroundResource(R.drawable.playpressed);
                    PlayButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, LoadingActivityGame1.class);
                            //Create the bundle
                            Bundle bundle = new Bundle();

                            //Add your data to bundle
                            bundle.putString("score", "10");
                            //Add the bundle to the intent
                            intent.putExtras(bundle);
                            startActivity(intent);


                        }
                    });

                } else {
                    PlayButton.setBackground(playBackg);
                    // The toggle is disabled
                }
            }
        });


        SoundButton = (ToggleButton) findViewById(R.id.sound);
        final Drawable soundBackg = SoundButton.getBackground();
        SoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SoundButton.isChecked()) {
                    CommonMethod.player.stop();
                } else {
                    commonMethod.SoundPlayer(getApplicationContext(), R.raw.happyclapp);

                }

            }
        });

        SoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SoundButton.setBackgroundResource(R.drawable.soundoff);
                } else {
                    SoundButton.setBackground(soundBackg);
                    // The toggle is disabled
                }
            }
        });


        LanguageButton = (ToggleButton) findViewById(R.id.languagebutton);
        final Drawable langBackg = LanguageButton.getBackground();
        LanguageButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    LanguageButton.setBackgroundResource(R.drawable.tnbutton);
                    PlayButton.setBackgroundResource(R.drawable.aleeb);
                } else {
                    LanguageButton.setBackground(langBackg);
                    PlayButton.setBackgroundResource(R.drawable.play);
                    // The toggle is disabled
                }
            }
        });


    }


}
