package com.example.covidassessment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

public class AssessmentResult extends AppCompatActivity {

    TextView tv1,validdate,tv2,tv3;
    String covidStatus;
    ImageView image1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assessment_result);
        tv1 = (TextView)findViewById(R.id.validrules3);
        tv2 = (TextView)findViewById(R.id.validrules4);
        tv3 = (TextView)findViewById(R.id.validrules5);
        image1=(ImageView)findViewById(R.id.covid1) ;
        validdate= (TextView)findViewById(R.id.validdate);

        Calendar calendar=Calendar.getInstance();
        String currentdate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        validdate.setText(currentdate);

        Intent intent = getIntent();
        covidStatus = intent.getStringExtra("CovidStatus");
        System.out.println(covidStatus);
        if (covidStatus.equals("False")){

            covidNegative(tv1);
            covidNegative2(tv2);
            covidNegative3(tv3);
            image1.setImageResource(R.drawable.covidfail);

        }
        else
        {
            covidPositive(tv1);

            image1.setImageResource(R.drawable.covidpass);
        }

    }
    public void covidPositive(TextView tv1){
        tv1.setText("Retake this screening every day before going to work");
    }
    public void covidNegative(TextView tv1){
        tv1.setText("You should isolate (stay home) and not leave except to get tested or for a medical emergencys");
    }
    public void covidNegative2(TextView tv2){
        tv2.setText("Talk with a doctor/health care provider or call Telehealth Ontario (1-866-797-0000) to get advice or an assessment, including if you need a COVID-19 test");
    }
    public void covidNegative3(TextView tv3){
        tv3.setText("We recommend that you stay home to protect the health and safety of the people you work with.You could be carrying and spreading the virus without knowing it.");
    }
}
