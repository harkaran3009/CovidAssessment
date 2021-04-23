package com.example.covidassessment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VaccineRegisterResult extends AppCompatActivity {

    String name,date,time,centre;
    TextView t1,t2,t3;
    String[] suit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_register_result);

        Intent intent = new Intent();
        t1 = (TextView)findViewById(R.id.vaccinetest3);
        t2 = (TextView)findViewById(R.id.covidcenterVaccine);
        t3 = (TextView)findViewById(R.id.coviddatevaccine);
        //suit = intent.getStringArrayExtra("nameres");
        Bundle b=this.getIntent().getExtras();
        String[] array=b.getStringArray("key");



        t1.setText(array[0]);
        t2.setText(array[3]);
        t3.setText(array[1] + " at " + array[2]);
    }
}
