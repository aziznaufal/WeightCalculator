package com.example.aziznaufal.weightcalc_2;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Calc_1 extends AppCompatActivity {
    Button btnNext;
    EditText txtName;
    RadioButton radioButton;
    RadioGroup rdoGroup;
    Intent myIntent;
    String gender;
    String[] Data = new  String[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_1);
        btnNext = (Button)findViewById(R.id.btnNext);
        txtName = (EditText) findViewById(R.id.txtName);

        rdoGroup = (RadioGroup) findViewById(R.id.rdoGroup);


        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Next();
            }
        });
    }


    private void Next(){
        int selectedId = rdoGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        gender = radioButton.getText().toString();
        try {

            Data[0] = txtName.getText().toString();
            Data[1] = gender;
        }catch (Exception er){
            Toast.makeText(getApplicationContext(), er.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
        myIntent = new Intent(Calc_1.this, Calc_2.class);
        myIntent.putExtra("Data API", Data);
        startActivity(myIntent);
    }

    /*public void Back(){
        myIntent = new Intent(Calc_1.this, Calc_2.class);
        startActivity(myIntent);
    }*/
}
