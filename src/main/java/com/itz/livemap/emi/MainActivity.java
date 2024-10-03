//Mohammed Hassan Fawal
//Mobile App Development
//Assignment 1
//October 2 2024
//EMI Calculator


package com.itz.livemap.emi;

import static com.itz.livemap.emi.R.id.lPayable;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Defining the EMI calculating Factors
public class MainActivity extends AppCompatActivity {
    EditText loanAmount;
    EditText interest;
    EditText years;
    EditText months;
    TextView lEmi;
    TextView lTenure;
    TextView lLoanAmount;
    TextView lPayableAmount;
    TextView lTotalPayment;
    Button summaryBtn,clear;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // these for editText values
        loanAmount = findViewById(R.id.amount);
        interest = findViewById(R.id.interest);
        years = findViewById(R.id.years);
        months = findViewById(R.id.months);
        // these for TextView values
        lEmi = findViewById(R.id.lemi);
        lTenure = findViewById(R.id.lTenure);
        lLoanAmount = findViewById(R.id.lLoanAmount);
        lPayableAmount = findViewById(R.id.lPayable);
        lTotalPayment = findViewById(R.id.lTotalAmount);
        // Button
        summaryBtn = findViewById(R.id.summaryBtn);
        clear = findViewById(R.id.clearBtn);
        summaryBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                double loanAmount1 = Integer.parseInt(loanAmount.getText().toString());
                double interest1 = Double.parseDouble(interest.getText().toString());
                int month1 = Integer.parseInt(months.getText().toString());
                int year1 = Integer.parseInt(years.getText().toString());

                int yearExchange = (year1*12)+month1;

                double principle = loanAmount1*(interest1/100);
                double power = Math.pow(interest1/100+1, yearExchange);
                double sum = principle/(1-(1/power));
                double totalInterest = sum*yearExchange-loanAmount1;
                double totalPayment2 = loanAmount1+totalInterest;
                // now set the value
                lEmi.setText(String.valueOf(sum));
                lTenure.setText(String.valueOf(yearExchange+"months"));
                lLoanAmount.setText(String.valueOf(loanAmount1));
                lPayableAmount.setText(String.valueOf(totalInterest));
                lTotalPayment.setText(String.valueOf(totalPayment2));

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}