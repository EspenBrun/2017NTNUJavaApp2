package com.example.android.mathpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MathActivity extends AppCompatActivity {

    private TextView rand1View;
    private TextView rand2View;
    private EditText answerView;
    private EditText maxView;

    private int request_Code = 1;
    private int randMax;
    private int rand1;
    private int rand2;
    private int answer;
    private int correct;
    String toastText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        rand1View = (TextView)findViewById(R.id.rand1);
        rand2View = (TextView)findViewById(R.id.rand2);
        answerView = (EditText) findViewById(R.id.answer);
        maxView = (EditText)findViewById(R.id.max);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == request_Code && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            rand1 = extras.getInt("rand1",rand1);
            rand2 = extras.getInt("rand2",rand2);
            rand1View.setText(String.valueOf(rand1));
            rand2View.setText(String.valueOf(rand2));
        }
    }

    // Get to new random numbers from the RandomActivity
    public void newRand(){
        if(maxView.getText().length() > 0) {
            randMax = Integer.parseInt(maxView.getText().toString());

            Intent intent = new Intent("ebru.randomActivity");
            intent.putExtra("randMax", randMax);
            startActivityForResult(intent, request_Code);
        }
    }

    public void add(View v) {
        rand1 = Integer.parseInt(rand1View.getText().toString());
        rand2 = Integer.parseInt(rand2View.getText().toString());

        if(answerView.getText().length() > 0) {
            answer = Integer.parseInt(answerView.getText().toString());
            correct = rand1+rand2;

            if(answer == correct){
                toastText = getString(R.string.correct);
            } else {
                toastText = getString(R.string.wrong_correct_answer_is) + correct;
            }

            newRand();
        } else {
            toastText = "Try to answer";
        }

        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }

    public void multiply(View v){
        rand1 = Integer.parseInt(rand1View.getText().toString());
        rand2 = Integer.parseInt(rand2View.getText().toString());
        if(answerView.getText().length() > 0) {
            answer = Integer.parseInt(answerView.getText().toString());
            correct = rand1 * rand2;

            if (answer == correct) {
                toastText = getString(R.string.correct);
            } else {
                toastText = getString(R.string.wrong_correct_answer_is) + correct;
            }

            newRand();
        } else {
            toastText = "Try to answer";
        }

        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }
}
