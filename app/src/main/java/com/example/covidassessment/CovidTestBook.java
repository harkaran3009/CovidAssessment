package com.example.covidassessment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CovidTestBook extends AppCompatActivity {

    EditText bookDate;
    final Calendar myCalendar = Calendar.getInstance();
    CheckBox checkBoxTemp;
    TextView linkText;
    AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_booking);
        bookDate= (EditText) findViewById(R.id.coviddate);
        checkBoxTemp = (CheckBox) findViewById(R.id.checkBoxTestBook) ;
        linkText = (TextView) findViewById(R.id.covidbooking7);
        linkText.setMovementMethod(LinkMovementMethod.getInstance());

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {


            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel();
            }

        };

        bookDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DatePickerDialog dp = new DatePickerDialog(CovidTestBook.this, date,  myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dp.getDatePicker().setMinDate(myCalendar.getTimeInMillis());

                dp.getDatePicker().setMaxDate(myCalendar.getTimeInMillis() + (1000*60*60*24*7));
                dp.show();

            }
        });

    }
    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        bookDate.setText(sdf.format(myCalendar.getTime()));
    }

    public void covidbookClick(View view) {
        if(!checkBoxTemp.isChecked())
        {
            builder = new AlertDialog.Builder(this);
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.setMessage("Please check the box to give your consent");
            alert.show();
        }

    }

}
