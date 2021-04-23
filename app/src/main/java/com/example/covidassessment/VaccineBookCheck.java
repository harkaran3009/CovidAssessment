package com.example.covidassessment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class VaccineBookCheck extends AppCompatActivity{
    Spinner dropdownid;
    EditText identification;
    TextView textViewEmpty;
    myDbAdapter helper;
    Context context;
    ArrayList<String> values = new ArrayList<String>();
    AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_book_check);
        dropdownid = (Spinner)  findViewById(R.id.spinner4) ;
        identification = (EditText) findViewById(R.id.vaccineBookCheckIdent) ;
        textViewEmpty = (TextView) findViewById(R.id.textView23) ;
        helper = new myDbAdapter(this);


    }

    public void button8Click(View view) {
        String t1 = dropdownid.getSelectedItem().toString();
        String t2 = identification.getText().toString();
        values = helper.fetchData(t1,t2);
        if(values.get(0) == "false")
        {
            builder = new AlertDialog.Builder(this);
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.setMessage("No Matching Record Found");
            alert.show();
        }
        else
        {
            String name = values.get(0);
            String centre = values.get(1);
            String date = values.get(2);
            textViewEmpty.setText("Patient : " +name + " has Covid Test Booked at " + centre + " on " + date);
        }


    }
}
