package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalculate = findViewById(R.id.button);
        btnCalculate.setOnClickListener(v -> {
            RadioGroup radioGroup = findViewById(R.id.radioGroup);
            RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

            TextInputLayout feet = findViewById(R.id.feet);
            TextInputLayout inches = findViewById(R.id.inches);

            String gender;
            String feetStr = feet.getEditText().getText().toString().trim();
            String inchesStr = inches.getEditText().getText().toString().trim();
            if (!validateFields(radioGroup.getCheckedRadioButtonId(), feetStr, inchesStr)) {
                Toast.makeText(getBaseContext(), "Please fill all values", Toast.LENGTH_LONG).show();
            } else {
                gender = radioButton.getText().toString();
                Log.d("MyApp", String.format("%s -> %s => %s ", gender, feetStr, inchesStr));
                Intent intent = new Intent(Calculator.this, Result.class);
                intent.putExtra("gender", gender);
                intent.putExtra("feet", feetStr);
                intent.putExtra("inches", inchesStr);
                startActivity(intent);
            }
        });
    }

    private boolean validateFields(int gender, String feetStr, String inchesStr) {
        return (gender != -1 && feetStr != null && inchesStr != null) &&
                (!feetStr.isEmpty() && !inchesStr.isEmpty());
    }
}