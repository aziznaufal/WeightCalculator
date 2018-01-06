package com.example.aziznaufal.weightcalc_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calc_Result extends AppCompatActivity {
    Button btnOkay;
    TextView txtView;
    TextView txtconclu;
    EditText txtResult;
    String gender;
    Intent myIntent;
    String[] Data = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc__result);
        btnOkay = (Button)findViewById(R.id.btnOkay);
        txtView = (TextView) findViewById(R.id.txtView);
        txtconclu = (TextView) findViewById(R.id.txtconclu);
        txtResult = (EditText) findViewById(R.id.txtResult);
        Bundle extra = getIntent().getExtras();
        Data = extra.getStringArray("Data API");
        if(Data[1].equals("Male"))
            gender = "Mr.";
        else
            gender = "Mrs.";

        int Ideal = ideal(Integer.parseInt(Data[2]), Data[1]);
        double bmi = BMI(Integer.parseInt(Data[2]), Integer.parseInt(Data[3]));
        String Conclusion;

        if (bmi > 27)
        {
            Conclusion = "Obesitas  ( > 27kg )";
        }
        else if (bmi > 25)
        {
            Conclusion = "Over Weight/Kegemukan  ( 25 - 27kg )";
        }
        else if (bmi > 18)
        {
            Conclusion = "Normal Weight/Normal ( 18 - 25kg )";
        }
        else
        {
            Conclusion = "Under Weight/Kurus ( < 18kg )";
        }
        txtView.setText("It's your result "+gender+" "+Data[0]);
        txtconclu.setText("The Conclusion is "+Conclusion);
        txtResult.setText("Your Ideal Weight is "+Ideal+"\nAnd Your Body mass index  is "+bmi);


        btnOkay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Home();
            }
        });
    }
    private void Home(){
        myIntent = new Intent(Calc_Result.this, MainActivity.class);
        startActivity(myIntent);
    }

    public int ideal(int Height, String gender)
    {
        if(gender.equals("Male"))
        {
            return ((Height - 100)-(10*(Height - 100)/100));
        }
        else
        {
            return ((Height - 100) - (15 * (Height - 100) / 100));
        }
    }

    public double BMI(int Height, int Weight)
    {
        double bm = (Height / 100) * (Height / 100);
        return Weight / bm;
    }
}
