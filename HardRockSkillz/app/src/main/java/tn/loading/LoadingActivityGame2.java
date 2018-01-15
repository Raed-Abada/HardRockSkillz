package tn.loading;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingActivityGame2 extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0;
    int count = 3;
    boolean bool = true;
    private Handler handler = new Handler();
    private MediaPlayer mp;
    private TextView compteur;
    String Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circular_android_progress_bar2);
        mp = MediaPlayer.create(this, R.raw.bombe);
        mp.start();
        progressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        compteur = (TextView) findViewById(R.id.Number);
        new Thread(new Runnable() {
            public void run() {

                while (progressStatus < progressBar.getMax()) {
                    progressStatus += 5;
                    //Update progress bar with completion of operation
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);

                        }

                    });

                    try {
                        // Sleep for 300 milliseconds.
                        //Just to display the progress slowly
                        Thread.sleep(174);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }

                handler.post(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(LoadingActivityGame2.this, Game2.class);
                        Bundle extras = getIntent().getExtras();

                        if (extras != null) {
                            Score = extras.getString("scoreGame1");
                            intent.putExtra("score", Score);
                            Log.d("LoadingScoreGame1", "score=" + Score);
                        }
                        startActivity(intent);
                    }
                });


            }

        })
                .start();

        Thread t = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(1100);
                        //1000ms = 1 sec
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count--;
                                if (count != 0 && bool == true) {
                                    compteur.setText(String.valueOf(count));

                                } else {
                                    compteur.setText("GO!");
                                    bool = false;


                                }
                            }

                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        };
        t.start();


    }

}
