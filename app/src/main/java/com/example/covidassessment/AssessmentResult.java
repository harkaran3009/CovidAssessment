package com.example.covidassessment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AssessmentResult extends AppCompatActivity {

    TextView tv;
    String covidStatus;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assessment_result);
        tv = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        covidStatus = intent.getStringExtra("CovidStatus");
        System.out.println(covidStatus);
        if (covidStatus.equals("False")){
            covidPositive(tv);
        }
        else
        {
            covidNegative(tv);
        }

    }
    public void covidPositive(TextView tv1){
        tv1.setText("You May Have Covid, Get it Tested");
    }
    public void covidNegative(TextView tv1){
        tv1.setText("You don't have any Covid Symptoms");
    }
}
