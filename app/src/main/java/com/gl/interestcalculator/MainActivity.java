package com.gl.interestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gl.interestcalculator.com.gl.intersetcalculator.service.InterestService;
import com.gl.interestcalculator.com.gl.intersetcalculator.service.InterestServiceImpl;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {


    InterestService interestService = new InterestServiceImpl();
    private EditText amount;
    private EditText year;
    private EditText rate;
    private Button btnSimpleInterest;
    private Button btnCompoundInterest;
    private  EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.amountText);
        year = (EditText) findViewById(R.id.yearText);
        rate = (EditText) findViewById(R.id.rateText);
        btnSimpleInterest = (Button) findViewById(R.id.simpleButton);
        btnCompoundInterest = (Button) findViewById(R.id.compoundButton);
        answer = (EditText) findViewById(R.id.editTextAnswer);

        btnSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amountVal = amount.getText().toString();
                String rateVal = rate.getText().toString();
                String yearVal = year.getText().toString();
                if (chkEmpty(amountVal,rateVal,yearVal)) {
                    double amt = parseDouble(amount.getText().toString());
                    int yearInfo = Integer.parseInt(year.getText().toString());
                    double rateInfo = parseDouble(rate.getText().toString());
                    double answerInfo = interestService.calculateSimpleInterest(amt, yearInfo, rateInfo);
                    answer.setText("Answer :" + String.valueOf(answerInfo));
                }
            }
        });

        btnCompoundInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amountVal = amount.getText().toString();
                String rateVal = rate.getText().toString();
                String yearVal = year.getText().toString();
                if (chkEmpty(amountVal,rateVal,yearVal)) {
                    double amt = parseDouble(amount.getText().toString());
                    int yearInfo = Integer.parseInt(year.getText().toString());
                    double rateInfo = parseDouble(rate.getText().toString());
                    double answerInfo = interestService.calculateCompoundInterest(amt, yearInfo, rateInfo);
                    answer.setText("Answer :" + String.valueOf(answerInfo));
                }
            }
        });
    }

    public  boolean chkEmpty(String amount, String rate,String year){
        if (TextUtils.isEmpty(amount)){
            Toast.makeText(MainActivity.this,
                    "Please Enter Amount", Toast.LENGTH_LONG).show();
            return false;
        }if(TextUtils.isEmpty(rate)){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please Enter Rate Of Interest",Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }if(TextUtils.isEmpty(year)){
            Toast.makeText(getApplicationContext(),
                    "Please Enter Year", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}


