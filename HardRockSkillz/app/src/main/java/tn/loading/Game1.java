package tn.loading;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
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

public class Game1 extends AppCompatActivity implements Chronometer.OnChronometerTickListener {
    private Game1Questions mGame1Questions = new Game1Questions();
    private Chronometer chronometer;
    MediaPlayer mp = null;
    private Button ButtonChoice1;
    private Button ButtonChoice2;
    private Button ButtonChoice3;
    ImageView QuestionImage;
    ImageView mAnswer;
    private TextView numQuestion;
    private TextView coeurNumber;
    int numerocoeur = 3;
    int numeroquestion = 1;
    Random r;
    private int mQuestionNumber = mGame1Questions.mQuestions.length;
    int mScore = 0;
    String zero = "00:00";
    String chrnonoValue;
    ConstraintLayout firstlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        r = new Random();
        mAnswer = new ImageView(this);
        mp = MediaPlayer.create(this, R.raw.happyclapp);
        numQuestion = (TextView) findViewById(R.id.numeroQuest);
        coeurNumber = (TextView) findViewById(R.id.coeurNumber);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime() + (13 * 1000));
        chronometer.setCountDown(true);
        chronometer.setOnChronometerTickListener(this);
        chronometer.start();
        chrnonoValue = (String) chronometer.getText();
        QuestionImage = (ImageView) findViewById(R.id.question);
        ButtonChoice1 = (Button) findViewById(R.id.choice1);
        ButtonChoice2 = (Button) findViewById(R.id.choice2);
        ButtonChoice3 = (Button) findViewById(R.id.choice3);
        firstlayout = (ConstraintLayout) findViewById(R.id.firstLayout);
        updateQuestion(r.nextInt(mQuestionNumber));

        //Start of Button Listener for Button1
        ButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if (ButtonChoice1.getBackground().getConstantState().equals(mAnswer.getDrawable().getConstantState())) {
                    firstlayout.setBackgroundColor(getResources().getColor(R.color.green));
                    final Toast toast = Toast.makeText(getApplicationContext(), "Bravo! Good answer.",
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

                    numeroquestion++;
                    numQuestion.setText("" + numeroquestion);
                    mScore = mScore + 10;
                    updateScore(mScore);

                    if (numeroquestion < 10 && numerocoeur >= 0) {
                        updateQuestion(r.nextInt(mQuestionNumber));
                    } else {
                        onChronometerTick(chronometer);


                    }


                } else {
                    firstlayout.setBackgroundColor(getResources().getColor(R.color.red));

                    final Toast toast = Toast.makeText(getApplicationContext(), "Sorry! Wrong answer.",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);
                    numeroquestion++;
                    numQuestion.setText("" + numeroquestion);
                    numerocoeur--;
                    coeurNumber.setText("" + numerocoeur);

                    if (numeroquestion < 10 && numerocoeur >= 0) {
                        updateQuestion(r.nextInt(mQuestionNumber));
                    } else {
                        onChronometerTick(chronometer);


                    }
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        ButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (ButtonChoice2.getBackground().getConstantState().equals(mAnswer.getDrawable().getConstantState())) {
                    firstlayout.setBackgroundColor(getResources().getColor(R.color.green));

                    final Toast toast = Toast.makeText(getApplicationContext(), "Bravo! Good answer",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);
                    numeroquestion++;
                    numQuestion.setText("" + numeroquestion);
                    mScore = mScore + 10;
                    updateScore(mScore);

                    if (numeroquestion < 10 && numerocoeur >= 0) {
                        updateQuestion(r.nextInt(mQuestionNumber));
                    } else {
                        onChronometerTick(chronometer);


                    }

                } else {
                    firstlayout.setBackgroundColor(getResources().getColor(R.color.red));

                    final Toast toast = Toast.makeText(getApplicationContext(), "Sorry! Wrong answer.",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);
                    numeroquestion++;
                    numQuestion.setText("" + numeroquestion);
                    numerocoeur--;
                    coeurNumber.setText("" + numerocoeur);

                    if (numeroquestion < 10 && numerocoeur >= 0) {
                        updateQuestion(r.nextInt(mQuestionNumber));
                    } else {
                        onChronometerTick(chronometer);


                    }
                }
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        ButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here

                if (ButtonChoice3.getBackground().getConstantState().equals(mAnswer.getDrawable().getConstantState())) {
                    firstlayout.setBackgroundColor(getResources().getColor(R.color.green));

                    final Toast toast = Toast.makeText(getApplicationContext(), "Bravo! Good answer",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);
                    numeroquestion++;
                    numQuestion.setText("" + numeroquestion);
                    mScore = mScore + 10;
                    updateScore(mScore);

                    if (numeroquestion < 10 && numerocoeur >= 0) {
                        updateQuestion(r.nextInt(mQuestionNumber));
                    } else {
                        onChronometerTick(chronometer);


                    }

                } else {
                    firstlayout.setBackgroundColor(getResources().getColor(R.color.red));

                    final Toast toast = Toast.makeText(getApplicationContext(), "Sorry! Wrong answer.",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0, 350);
                    TextView toastMessage = (TextView) toast.getView().findViewById(android.R.id.message);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 650);
                    numeroquestion++;
                    numQuestion.setText("" + numeroquestion);
                    numerocoeur--;
                    coeurNumber.setText("" + numerocoeur);

                    if (numeroquestion < 10 && numerocoeur >= 0) {
                        updateQuestion(r.nextInt(mQuestionNumber));
                    } else {
                        onChronometerTick(chronometer);

                    }
                }
            }
        });

        //End of Button Listener for Button3


    }


    private void updateQuestion(int mQuestionNumber) {

        Thread t = new Thread() {
            @Override
            public void run() {

                try {
                    Thread.sleep(650);
                    //1000ms = 1 sec
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            firstlayout.setBackgroundColor(Color.TRANSPARENT);
                        }

                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };

        t.start();


        QuestionImage.setImageResource(mGame1Questions.getQuestion(mQuestionNumber));
        ButtonChoice1.setBackgroundResource(mGame1Questions.getChoice1(mQuestionNumber));
        ButtonChoice2.setBackgroundResource(mGame1Questions.getChoice2(mQuestionNumber));
        ButtonChoice3.setBackgroundResource(mGame1Questions.getChoice3(mQuestionNumber));
        mAnswer.setImageResource(mGame1Questions.getCorrectAnswer(mQuestionNumber));

        mQuestionNumber++;
    }


    private void updateScore(int point) {
        mScore += mScore;
    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        if ("00:00".equals(chronometer.getText()) || numeroquestion >= 10 || numerocoeur < 0) {
            Intent i = new Intent(Game1.this, LoadingActivityGame2.class);
            i.putExtra("scoreGame1", String.valueOf(mScore));
            Log.d("scoreGame1", "score=" + mScore);
            startActivity(i);
        }
    }
}


