package tn.loading;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static tn.loading.R.id.coeurNumber;

public class Game2 extends AppCompatActivity implements Chronometer.OnChronometerTickListener {
    private Game2Questions mGame2Questions = new Game2Questions();
    private Chronometer chronometer2;
    MediaPlayer mp2 = null;
    private Button TrueButton;
    private Button FalseButton;
    private TextView numQuestion2;
    private TextView coeurNumber2;
    private TextView question2;
    int numerocoeur2 = 3;
    int numeroquestion2 = 1;
    Random r2;
    ImageView mAnswer2;
    private int mQuestionNumber2 = mGame2Questions.mQuestions2.length;
    int mScore2 = 0;
    ConstraintLayout firstLayout;
    String Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        mAnswer2 = new ImageView(this);
        r2 = new Random();
        mp2 = MediaPlayer.create(this, R.raw.happyclapp);
        chronometer2 = (Chronometer) findViewById(R.id.chronometer);
        chronometer2.setBase(SystemClock.elapsedRealtime() + (13 * 1000));
        chronometer2.setCountDown(true);
        chronometer2.setOnChronometerTickListener(this);
        chronometer2.start();
        numQuestion2 = (TextView) findViewById(R.id.numeroQuest);
        coeurNumber2 = (TextView) findViewById(coeurNumber);
        question2 = (TextView) findViewById(R.id.Question);
        TrueButton = (Button) findViewById(R.id.TrueButton);
        FalseButton = (Button) findViewById(R.id.FalseButton);
        firstLayout = (ConstraintLayout) findViewById(R.id.firstLayout);
        updateQuestion(r2.nextInt(mQuestionNumber2));


        //Start of Button Listener for Button1
        TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TrueButton.getBackground().getConstantState().equals(mAnswer2.getDrawable().getConstantState())) {
                    firstLayout.setBackgroundColor(getResources().getColor(R.color.green));
                    final Toast toast = Toast.makeText(getApplicationContext(), "Bravo! Good answer",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);
                    numeroquestion2++;
                    numQuestion2.setText("" + numeroquestion2);
                    mScore2 = mScore2 + 10;
                    updateScore(mScore2);

                    if (numeroquestion2 < 10 && numerocoeur2 >= 0) {
                        updateQuestion(r2.nextInt(mQuestionNumber2));
                    } else {
                        onChronometerTick(chronometer2);


                    }


                } else {
                    firstLayout.setBackgroundColor(getResources().getColor(R.color.red));
                    final Toast toast = Toast.makeText(getApplicationContext(), "Sorry! Wrong answer.",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);

                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);

                    numeroquestion2++;
                    numQuestion2.setText("" + numeroquestion2);
                    numerocoeur2--;
                    coeurNumber2.setText("" + numerocoeur2);

                    if (numeroquestion2 < 10 && numerocoeur2 >= 0) {
                        updateQuestion(r2.nextInt(mQuestionNumber2));
                    } else {
                        onChronometerTick(chronometer2);


                    }
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (FalseButton.getBackground().getConstantState().equals(mAnswer2.getDrawable().getConstantState())) {
                    firstLayout.setBackgroundColor(getResources().getColor(R.color.green));
                    final Toast toast = Toast.makeText(getApplicationContext(), "Bravo! Good answer",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);

                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);
                    numeroquestion2++;
                    numQuestion2.setText("" + numeroquestion2);
                    mScore2 = mScore2 + 10;
                    updateScore(mScore2);

                    if (numeroquestion2 < 10 && numerocoeur2 >= 0) {
                        updateQuestion(r2.nextInt(mQuestionNumber2));
                    } else {
                        onChronometerTick(chronometer2);

                    }

                } else {
                    firstLayout.setBackgroundColor(getResources().getColor(R.color.red));
                    final Toast toast = Toast.makeText(getApplicationContext(), "Sorry! Wrong answer.",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);

                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);

                    numeroquestion2++;
                    numQuestion2.setText("" + numeroquestion2);
                    numerocoeur2--;
                    coeurNumber2.setText("" + numerocoeur2);

                    if (numeroquestion2 < 10 && numerocoeur2 >= 0) {
                        updateQuestion(r2.nextInt(mQuestionNumber2));
                    } else {
                        onChronometerTick(chronometer2);


                    }
                }
            }
        });
    }

    //End of Button Listener for Button2


    private void updateQuestion(int mQuestionNumber2) {
        Thread t = new Thread() {
            @Override
            public void run() {

                try {
                    Thread.sleep(650);
                    //1000ms = 1 sec
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            firstLayout.setBackgroundColor(Color.TRANSPARENT);
                        }

                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };

        t.start();
        question2.setText(mGame2Questions.getQuestion2(mQuestionNumber2));
        mAnswer2.setImageResource(mGame2Questions.getCorrectAnswer2(mQuestionNumber2));
        mQuestionNumber2++;
    }


    private void updateScore(int point) {
        mScore2 += mScore2;
    }

    private void stopPlaying() {
        if (mp2 != null) {
            mp2.stop();
            mp2.release();
            mp2 = null;
        }
    }


    @Override
    public void onChronometerTick(Chronometer chronometer) {
        if ("00:00".equals(chronometer.getText()) || numeroquestion2 >= 10 || numerocoeur2 < 0) {
            Intent i = new Intent(Game2.this, ScoreActivity.class);
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                Score = extras.getString("score");
                int F = Integer.parseInt(Score) + mScore2;
                i.putExtra("scoreFinal", String.valueOf(F));
                Log.d("Game2", "score=" + F);
            }
            startActivity(i);
        }
    }
}




