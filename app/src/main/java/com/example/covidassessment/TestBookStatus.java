package com.example.covidassessment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TestBookStatus extends AppCompatActivity {
    String name,date,time,centre;
    TextView t1,t2,t3;
    String[] suit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covidbooking_confirm);
        Intent intent = new Intent();
        t1 = (TextView)findViewById(R.id.covidtest3);
        t2 = (TextView)findViewById(R.id.covidcenter);
        t3 = (TextView)findViewById(R.id.coviddate);
        //suit = intent.getStringArrayExtra("nameres");
        Bundle b=this.getIntent().getExtras();
        String[] array=b.getStringArray("key");



        t1.setText(array[0]);
        t2.setText(array[3]);
        t3.setText(array[1] + " at " + array[2]);




    }
}
