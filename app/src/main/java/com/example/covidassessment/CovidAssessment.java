package com.example.covidassessment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CovidAssessment extends AppCompatActivity implements View.OnClickListener {
    Spinner dropdown;
    private Button buttonname;
    CheckBox chkbox1yes,chkbox1no,chkbox2yes,chkbox2no,chkbox3yes,chkbox3no,chkbox4yes,chkbox4no,chkbox5yes,chkbox5no,chkbox6yes,chkbox6no,
    chkbox7yes,chkbox7no;
    AlertDialog.Builder builder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.covid_assessment);

        buttonname = (Button) findViewById(R.id.button5) ;
        buttonname.setOnClickListener(this);
        chkbox1yes = (CheckBox)findViewById(R.id.checkBox1Yes);
        chkbox1no = (CheckBox)findViewById(R.id.checkBox1No);
        chkbox2yes = (CheckBox)findViewById(R.id.checkBox2Yes);
        chkbox2no = (CheckBox)findViewById(R.id.checkBox2No);
        chkbox3yes = (CheckBox)findViewById(R.id.checkBox3Yes);
        chkbox3no = (CheckBox)findViewById(R.id.checkBox3No);
        chkbox4yes = (CheckBox)findViewById(R.id.checkBox4Yes);
        chkbox4no = (CheckBox)findViewById(R.id.checkBox4No);
        chkbox5yes = (CheckBox)findViewById(R.id.checkBox5Yes);
        chkbox5no = (CheckBox)findViewById(R.id.checkBox5No);
        chkbox6yes = (CheckBox)findViewById(R.id.checkBox6Yes);
        chkbox6no = (CheckBox)findViewById(R.id.checkBox6No);
        chkbox7yes = (CheckBox)findViewById(R.id.checkBox7Yes);
        chkbox7no = (CheckBox)findViewById(R.id.checkBox7No);
        chkbox1yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox1no.setChecked(false);
            }
        });
        chkbox1no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox1yes.setChecked(false);
            }
        });
        chkbox2yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox2no.setChecked(false);
            }
        });
        chkbox2no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox2yes.setChecked(false);
            }
        });
        chkbox3yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox3no.setChecked(false);
            }
        });
        chkbox3no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox3yes.setChecked(false);
            }
        });
        chkbox4yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox4no.setChecked(false);
            }
        });
        chkbox4no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox4yes.setChecked(false);
            }
        });
        chkbox5yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox5no.setChecked(false);
            }
        });
        chkbox5no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox5yes.setChecked(false);
            }
        });
        chkbox6yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox6no.setChecked(false);
            }
        });
        chkbox6no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox6yes.setChecked(false);
            }
        });
        chkbox7yes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox7no.setChecked(false);
            }
        });
        chkbox7no.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chkbox7yes.setChecked(false);
            }
        });
    }

    public void onClick(View v)
    {
        Intent intent = new Intent(this, AssessmentResult.class);
        if((chkbox1yes.isChecked() || chkbox1no.isChecked()) && (chkbox2yes.isChecked() || chkbox2no.isChecked()) &&
                (chkbox3yes.isChecked() || chkbox3no.isChecked()) && (chkbox4yes.isChecked() || chkbox4no.isChecked()) &&
                (chkbox5yes.isChecked() || chkbox5no.isChecked()) && (chkbox6yes.isChecked() || chkbox6no.isChecked()) &&
                (chkbox7yes.isChecked() || chkbox7no.isChecked()))
        {
            if(chkbox1yes.isChecked() || chkbox2yes.isChecked()||chkbox3yes.isChecked()||chkbox4yes.isChecked()||chkbox5yes.isChecked()||chkbox6yes.isChecked() ||chkbox7yes.isChecked())
            {

                intent.putExtra("CovidStatus","False");
                clearCheckBox();
                startActivity(intent);
            }
            else{
                intent.putExtra("CovidStatus","True");
                clearCheckBox();
                startActivity(intent);
            }

        }
        else
        {
            builder = new AlertDialog.Builder(this);
            AlertDialog alert = builder.create();
            alert.setTitle("Alert");
            alert.setMessage("Please answer all the questions");
            alert.show();
        }

    }
    public void clearCheckBox()
    {
        chkbox1yes.setChecked(false);
        chkbox2yes.setChecked(false);
        chkbox3yes.setChecked(false);
        chkbox4yes.setChecked(false);
        chkbox5yes.setChecked(false);
        chkbox6yes.setChecked(false);
        chkbox7yes.setChecked(false);
        chkbox1no.setChecked(false);
        chkbox2no.setChecked(false);
        chkbox3no.setChecked(false);
        chkbox4no.setChecked(false);
        chkbox5no.setChecked(false);
        chkbox6no.setChecked(false);
        chkbox7no.setChecked(false);
    }


}
