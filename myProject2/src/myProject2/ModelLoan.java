package myProject2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.util.*;


public class ModelLoan {
	
	private double theWholeLoan;
	private double theInterestRate;
	private int numberOfYears;
	private double annualPayment;
	private double monthlyPayment;
	private double paymentHistory;
	
	//private double principal;
	
	
	
	//private double initialBalance = theWholeLoan; 
	//private int muaji;
	
	
	ModelLoan (double theInterestRate, int numberOfYears, double theWholeLoan, double paymentHistory) {
		this.theInterestRate = theInterestRate;
		this.numberOfYears = numberOfYears;
		this.theWholeLoan = theWholeLoan;
		
	
	}

	public double calcTheMonthlyPayment () {
		double monthlyInterestRate = theInterestRate/1200;	
		monthlyPayment = theWholeLoan * monthlyInterestRate / (1-1/Math.pow(1+monthlyInterestRate, numberOfYears*12));
		return monthlyPayment;
	}
	
	public double calcTheAnnualPayment () {
		annualPayment = monthlyPayment * numberOfYears * 12;
		return annualPayment;
	}
	
			
	public double calcThePaymentHistory () {
		double monthlyRate = theInterestRate / 1200;
		double balance = theWholeLoan, principal, theInterestRate;
		System.out.println("Payment#\tInterest\tPrincipal\tBalance");
		for(int i = 1; i <= numberOfYears * 12; i++) {
			theInterestRate = monthlyRate * balance;
			principal = monthlyPayment - theInterestRate;
			balance = balance - principal;
			System.out.printf("%d\t\t%.2f\t\t%.2f\t\t%.2f%n",i, theInterestRate, principal, balance);
		}
		
		return balance;
	}
			
	
	
	public double getInterestRate () {
		return theInterestRate;
	}
	
	public int getNumberOfYears () {
		return numberOfYears;
	}
	
	public double getTheWholeLoan () {
		return theWholeLoan;
	}
	
	public double getAnnualPayment () {
		return annualPayment;
	}
	
	public double getMonthlyPayment () {
		return monthlyPayment;
	}

	public double getPaymentHistory () {
		return paymentHistory;
	}
}
