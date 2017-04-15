package com.example.android.mathpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class RandomActivity extends AppCompatActivity {

    private int randMax = 100;
    private Random random = new Random();
    private int rand1;
    private int rand2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        randMax = getIntent().getIntExtra("randMax", randMax);
        rand1 = random.nextInt(randMax + 1);
        rand2 = random.nextInt(randMax + 1);

        Bundle extras = new Bundle();
        extras.putInt("rand1",rand1);
        extras.putInt("rand2",rand2);

        Intent intent = new Intent();
        intent.putExtras(extras);
        setResult(RESULT_OK, intent);

        finish();
    }
}
