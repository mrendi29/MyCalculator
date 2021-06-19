package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        int height = Integer.parseInt(intent.getStringExtra("feet"));
        int inches = Integer.parseInt(intent.getStringExtra("inches"));
        TextView genderTxt = findViewById(R.id.resultGenderTxt);
        genderTxt.setText(getString(R.string.resultGender, gender));

        TextView heightTxt = findViewById(R.id.resultHeightTxt);
        heightTxt.setText(getString(
                R.string.resultHeight,
                height,
                inches
        ));

        TextView resultBmi = findViewById(R.id.resultBmiTxt);
        resultBmi.setText(getString(
                R.string.resultBmi,
                getIdealWeight(gender, height, inches)
        ));
    }


    public double getIdealWeight(String gender, int feet, int inches) {
        double initialWeight = gender.equals("Male") ? 50.0 : 45.5;
        return initialWeight + 2.3 * (((feet * 12) + inches) - 60);
    }
}