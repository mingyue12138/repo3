package demo;

import java.util.Date;

public class Loan {
    private double annualIntersetRate;
    private int numberOfYears;
    private double loanAmout;
    private java.util.Date loanDate;



    public Loan(double annualIntersetRate, int numberOfYears, double loanAmout, Date loanDate) {
        this.annualIntersetRate = annualIntersetRate;
        this.numberOfYears = numberOfYears;
        this.loanAmout = loanAmout;
        //this.loanDate = loanDate;
        loanDate = new java.util.Date();
    }

    public Loan(double interest, int year, double loanAmout) {
        annualIntersetRate = interest;
        numberOfYears = year;
        this.loanAmout = loanAmout;

        }


    public double getAnnualIntersetRate() {
        return annualIntersetRate;
    }

    public void setAnnualIntersetRate(double annualIntersetRate) {
        this.annualIntersetRate = annualIntersetRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmout() {
        return loanAmout;
    }

    public void setLoanAmout(double loanAmout) {
        this.loanAmout = loanAmout;
    }
    public double getMonthlyPayment(){
        double monthlyInterestRate = annualIntersetRate/1200;
        double monthlyPayment = loanAmout * monthlyInterestRate/(1-(1/Math.pow(1+monthlyInterestRate,numberOfYears*12)));
        return monthlyPayment;
    }
    public double getTotalPayment(){
        double totalPayment = getMonthlyPayment()*numberOfYears*12;
        return totalPayment;

    }
    public java.util.Date getLoanDate(){
        return loanDate;
    }

}
