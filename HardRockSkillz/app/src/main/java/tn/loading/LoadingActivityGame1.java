package tn.loading;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoadingActivityGame1 extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    int count = 3;
    boolean bool = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circular_android_progress_bar1);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bombe);
        mp.start();


        progressBar = (ProgressBar) findViewById(R.id.circular_progress_bar);
        final TextView compteur = (TextView) findViewById(R.id.Number);
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
                        Intent intent = new Intent(LoadingActivityGame1.this, Game1.class);
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
