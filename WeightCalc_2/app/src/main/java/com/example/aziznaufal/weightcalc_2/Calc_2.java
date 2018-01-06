package com.example.aziznaufal.weightcalc_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calc_2 extends AppCompatActivity {

    Button btnNext;
    Button btnBack;
    EditText txtHeight;
    EditText txtWeight;
    Intent myIntent;
    String[] Data = new String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_2);
        btnNext = (Button)findViewById(R.id.btnNext);
        btnBack = (Button)findViewById(R.id.btnBack);
        txtHeight = (EditText) findViewById(R.id.txtHeight);
        txtWeight = (EditText) findViewById(R.id.txtWeight);
        Bundle extra = getIntent().getExtras();
        Data = extra.getStringArray("Data API");



        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Next();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Back();
            }
        });

    }

    private void Next(){
        Data[2] = txtHeight.getText().toString();
        Data[3] = txtWeight.getText().toString();
        myIntent = new Intent(Calc_2.this, Calc_Result.class);
        myIntent.putExtra("Data API", Data);
        startActivity(myIntent);
    }

    private void Back(){
        myIntent = new Intent(Calc_2.this, Calc_1.class);
        startActivity(myIntent);
    }
}
