package tn.loading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class ScoreActivity extends AppCompatActivity {
    CommonMethod commonMethod;
    TextView scoreText, highScoreText, bestone, msg1, msg2, win;
    EditText WinnerName;
    ToggleButton replayButton;
    String score;
    Button submit;
    int Score;
    int HScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        commonMethod = new CommonMethod();
        commonMethod.player.stop();
        replayButton = (ToggleButton) findViewById(R.id.replayButton);
        scoreText = (TextView) findViewById(R.id.scoreText);
        submit = (Button) findViewById(R.id.OkButton);
        bestone = (TextView) findViewById(R.id.bestOne);
        WinnerName = (EditText) findViewById(R.id.nameEditText);
        highScoreText = (TextView) findViewById(R.id.highScoreTextview);
        msg1 = (TextView) findViewById(R.id.GO);
        msg2 = (TextView) findViewById(R.id.luck);
        win = (TextView) findViewById(R.id.Winner);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            score = bundle.getString("scoreFinal");
            scoreText.setText(score);
        }
        if (score != "") {
            Score = Integer.parseInt(score);
            HScore = Integer.parseInt(highScoreText.getText().toString());

            if (Score > HScore) {
                win.setVisibility(View.VISIBLE);
                msg1.setVisibility(View.GONE);
                msg2.setVisibility(View.GONE);
                highScoreText.setText(score);

                WinnerName.setVisibility(View.VISIBLE);

            } else {
                WinnerName.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);

            }
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bestone.setText(WinnerName.getText());
                submit.setVisibility(View.GONE);
                WinnerName.setVisibility(View.GONE);


            }
        });


        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ScoreActivity.this, ByeByeActivity.class);
                i.putExtra("scoreGame1", String.valueOf(Score));
                startActivity(i);
            }
        });
    }

}
