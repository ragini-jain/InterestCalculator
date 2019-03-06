package com.gl.interestcalculator.com.gl.intersetcalculator.service;

public interface InterestService {
    /**
     *
     * @param amount
     * @param year
     * @param rate
     * @return
     */
    public double calculateSimpleInterest(double amount, int year, double rate);

    /**
     *
     * @param amount
     * @param year
     * @param rate
     * @return
     */
    public double calculateCompoundInterest(double amount, int year, double rate);

}
