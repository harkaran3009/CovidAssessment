package com.example.covidassessment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button button1 = (Button)findViewById(R.id.button);



        setSupportActionBar(toolbar);

    }

    public void button1Click(View view) {
        Intent intent = new Intent(MainActivity.this, CovidAssessment.class);
        startActivity(intent);
    }
    public void button3Click(View view) {
        Intent intent = new Intent(MainActivity.this, VaccineRegisteration.class);
        startActivity(intent);
    }
    public void button7Click(View view) {
        Intent intent = new Intent(MainActivity.this, VaccineBookCheck.class);
        startActivity(intent);
    }

    public void button2Click(View view) {
        Intent intent = new Intent(MainActivity.this, CovidTestBook.class);
        startActivity(intent);
    }

    public void button4Click(View view) {
        Intent intent = new Intent(MainActivity.this, CovidInfo.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}