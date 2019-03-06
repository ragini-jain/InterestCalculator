package com.gl.interestcalculator.com.gl.intersetcalculator.service;

import com.gl.interestcalculator.com.gl.intersetcalculator.service.*;

public class InterestServiceImpl implements InterestService {

    public double calculateSimpleInterest(double amount, int year, double rate){
        return amount*year*rate/100;
    }



    public double calculateCompoundInterest(double amount, int year, double rate){
        return  amount *
                (Math.pow((1 + rate / 100), year));
    }
}
