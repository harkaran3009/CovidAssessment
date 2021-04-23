package com.example.covidassessment;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CovidInfo  extends AppCompatActivity {
    TextView linkText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_info);
        linkText = (TextView) findViewById(R.id.covidmoreinfo);
        linkText.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
