package com.gl.interestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.gl.interestcalculator.com.gl.intersetcalculator.service.InterestService;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.*;
import static java.lang.String.*;

/**
 * @author ragini.jain
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, InterestService{

    private EditText mAmountLabel;
    private EditText mYearLabel;
    private EditText mRateLabel;
    private Button mBtnSimpleInterest;
    private Button mBtnCompoundInterest;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        registerListener();
    }

    /**
     * Init View
     */
    private void initViews() {
        mAmountLabel = findViewById(R.id.amountText);
        mYearLabel =findViewById(R.id.yearText);
        mRateLabel = findViewById(R.id.rateText);
        mBtnSimpleInterest = findViewById(R.id.simpleButton);
        answer = findViewById(R.id.editTextAnswer);
        mBtnCompoundInterest = findViewById(R.id.compoundButton);
    }


    /**
     * Validate Views
     * @param amount As Principle
     * @param rate as Rate of Interest
     * @param year required Year
     * @return Boolean if found true
     */
    private  boolean validateViews(String amount, String rate,String year){
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

    /**
     * Click Event Listener
     */
    private void registerListener(){
        mBtnCompoundInterest.setOnClickListener(this);
        mBtnSimpleInterest.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (view == mBtnSimpleInterest) {
            calculateSimpleInterest();
        }else if (view ==mBtnCompoundInterest) {
            calculateCompoundInterest();
        }
    }

    /**
     * Calculate Simple Interest
     */
    private void calculateSimpleInterest(){
        String amountVal = mAmountLabel.getText().toString();
        String rateVal = mRateLabel.getText().toString();
        String yearVal = mYearLabel.getText().toString();
        if (validateViews(amountVal,rateVal,yearVal)) {
            double amt = parseDouble(mAmountLabel.getText().toString());
            int yearInfo = parseInt(mYearLabel.getText().toString());
            double rateInfo = parseDouble(mRateLabel.getText().toString());
            double answerInfo = calculateSimpleInterest(amt, yearInfo, rateInfo);
            answer.setText(format("Answer :%s", valueOf(answerInfo)));
        }
    }

    /**
     * Calculate Compound Interest
     */
    private void calculateCompoundInterest(){
        String amountVal = mAmountLabel.getText().toString();
        String rateVal = mRateLabel.getText().toString();
        String yearVal = mYearLabel.getText().toString();
        if (validateViews(amountVal,rateVal,yearVal)) {
            double amt = parseDouble(mAmountLabel.getText().toString());
            int yearInfo = parseInt(mYearLabel.getText().toString());
            double rateInfo = parseDouble(mRateLabel.getText().toString());
            double answerInfo = calculateCompoundInterest(amt, yearInfo, rateInfo);
            answer.setText(format("Answer :%s", valueOf(answerInfo)));
        }
    }

    public double calculateSimpleInterest(double amount, int year, double rate){
        return amount*year*rate/100;
    }



    public double calculateCompoundInterest(double amount, int year, double rate){
        return  amount *
                (Math.pow((1 + rate / 100), year));
    }
}


