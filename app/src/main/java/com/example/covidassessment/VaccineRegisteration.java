package com.example.covidassessment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class VaccineRegisteration  extends AppCompatActivity implements View.OnClickListener {

    final Calendar myCalendar = Calendar.getInstance();
    Spinner dropdownid,dropdowncentre,dropdowneligible,dropdowntimeslot;
    private Button buttonname;
    EditText fullname,address,identification,date;
    myDbAdapter helper;
    Context context;
    AlertDialog.Builder builder;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vaccine_registeration);
        buttonname = (Button) findViewById(R.id.button6) ;
        dropdownid = (Spinner)  findViewById(R.id.spinner) ;
        dropdowneligible = (Spinner)  findViewById(R.id.spinner2) ;
        dropdowncentre = (Spinner)  findViewById(R.id.spinner3) ;
        fullname = (EditText) findViewById(R.id.fullNameVaccine) ;
        address = (EditText) findViewById(R.id.addressVaccine) ;
        identification = (EditText) findViewById(R.id.identificationVaccine) ;
        date = (EditText)findViewById(R.id.editTextDate) ;
        dropdowntimeslot = (Spinner)  findViewById(R.id.spinner5) ;
        buttonname.setOnClickListener(this);
        helper = new myDbAdapter(this);

        DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {


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

        date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dp = new DatePickerDialog(VaccineRegisteration.this, date1,  myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));

                dp.getDatePicker().setMinDate(myCalendar.getTimeInMillis());

                dp.getDatePicker().setMaxDate(myCalendar.getTimeInMillis() + (1000*60*60*24*7));
                dp.show();

            }
        });



    }
    public void onClick(View v)
    {

        Toast.makeText(this,"Running", Toast.LENGTH_LONG).show();
        String t1 = fullname.getText().toString();
        String t2 = address.getText().toString();
        String t3 = dropdownid.getSelectedItem().toString();
        String t4 = identification.getText().toString();
        String t5 = dropdowneligible.getSelectedItem().toString();
        String t6 = dropdowncentre.getSelectedItem().toString();
        String t7 = date.getText().toString();
        String t8 = dropdowntimeslot.getSelectedItem().toString();
        int validate = 0;
        try {
            validate = validateFields(t1,t2,t3,t4,t5,t6,t7,t8);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(validate == 0){
            builder = new AlertDialog.Builder(this);
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.setMessage("Please Provide all values");
            alert.show();
        }
        else if(validate == 2)
        {
            builder = new AlertDialog.Builder(this);
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.setMessage("Please enter a future date");
            alert.show();
        }
        else {
            long identity = helper.insertData(t1, t2, t3, t4, t5, t6, t7,t8);
            if (identity < 0) {
                myDbAdapter.Message.message(context, "Unsuccessful");
            } else {
                Intent intent = new Intent(this, VaccineRegisterResult.class);
                finish();
                startActivity(intent);
            }
        }
    }

    public static int validateFields(String t1,String t2,String t3, String t4, String t5, String t6, String t7, String t8) throws ParseException {
        String dateTemp = t7;
        SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date today = c.getTime();
        Date date1=formatter1.parse(dateTemp);
        System.out.println(date1);
        System.out.println(today);

        if((t1 == null || t1.isEmpty()) || (t2 == null || t2.isEmpty()) || (t4 == null || t4.isEmpty()) || (t7 == null || t7.isEmpty()) ){
            return 0;
        }
        else if(date1.before(today))
        {
            return 2;
        }
        else
        {
            return 1;
        }
    }

    private void updateLabel() {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        date.setText(sdf.format(myCalendar.getTime()));
    }

}
