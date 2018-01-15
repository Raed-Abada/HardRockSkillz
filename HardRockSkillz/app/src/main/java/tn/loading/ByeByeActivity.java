package tn.loading;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ByeByeActivity extends AppCompatActivity {

    String pass = "raedabada";
    Button okButton, returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye_bye);


        final EditText password = (EditText) findViewById(R.id.password);
        okButton = (Button) findViewById(R.id.okButton);
        returnButton = (Button) findViewById(R.id.returnButton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(pass)) {
                    Intent intent3 = new Intent(ByeByeActivity.this, MainActivity.class);
                    startActivity(intent3);

                }
            }
        });


    }
}
