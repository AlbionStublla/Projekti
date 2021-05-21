package myProject2;

import java.awt.*;
import javax.swing.*;
import java.text.*;
import java.util.*;


public class ViewLoan extends JPanel {
	
	private int LeftMargin = 20;
	private int firstLine = 20;
	JFrame frame;
	//private JFrame theFrame;
	private double interesi;
	private int vitet;
	private double totalAmmount;
	public double pagesaVjetore;
	public double pagesaMujore;
	public double numberOfYears;
	public double  historia;
	public double  thePaymentHistory;
	
	//public JTextField theHistory;
	
	public ViewLoan() {
		
		frame = new JFrame();
		frame.getContentPane().add(this);
		frame.setBounds(0,0,5000,5000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
				
		}
		
	public ModelLoan getLoanInfo() {
		double interesi = getInterestRate();
		int vitet = getNumberOfYears();
		double totalAmmount = getTheWholeLoan();
		double historia = getPaymentHistory();
		return new ModelLoan(interesi, vitet, totalAmmount, historia);
	}
	
	public void getInfo() {
		ModelLoan loan = getLoanInfo();
		pagesaMujore = loan.calcTheMonthlyPayment();
		pagesaVjetore =  loan.calcTheAnnualPayment();
		thePaymentHistory = loan.calcThePaymentHistory();
		
	}
	
	
	
	
	public double getInterestRate() {
		
		interesi = new Double(JOptionPane.showInputDialog("Write the Interest Rate"));
		return interesi;
		
		
	}
	
	public int getNumberOfYears() {
		 vitet = new Integer(JOptionPane.showInputDialog("Write the number of years"));
		 return vitet;
	}
		
	public double getTheWholeLoan() {
		 totalAmmount = new Double(JOptionPane.showInputDialog("Write the total ammount"));
		 return totalAmmount;
	}
				
	public double getPaymentHistory() {
		double monthlyRate = interesi/1200;
		double balance = getTheWholeLoan(), principal, interesi;
		for(int i = 1; i <= numberOfYears * 12; i++) {
			interesi = monthlyRate * balance;
			principal = pagesaMujore - interesi;
			balance = balance - principal;
			System.out.printf("%d \t %.2f \t %.2f \t %.2f %n",i, interesi, principal, balance);
		}
		
		return balance;
	}
	

		
	
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 5000, 5000);
		g.setColor(Color.RED);
		g.setFont(new Font("Tahoma",Font.BOLD, 30));
		g.drawString("Loan Calculator", LeftMargin+ 25*firstLine,15+ firstLine);
		g.setFont(new Font("Times new Roman", Font.BOLD, 15));
		g.drawString("Interesi: "+interesi, LeftMargin,LeftMargin +4* firstLine );
		g.drawString("Numri i viteve: "+vitet, LeftMargin, LeftMargin +6* firstLine);
		g.drawString("Shuma totale: "+totalAmmount, LeftMargin, LeftMargin + 8*firstLine);
		
		DecimalFormat formatter = new DecimalFormat("0.00");
		g.drawString("Pagesa mujore eshte "+formatter.format(pagesaMujore), LeftMargin, firstLine + 10*LeftMargin);
		
		
		g.drawString("Pagesa vjetore eshte "+formatter.format(pagesaVjetore), LeftMargin, firstLine + 12*LeftMargin);
		
	
		
		
	}
	
	public static void main(String[] args) {
		ViewLoan korniza = new ViewLoan();
		korniza.getInfo();
		korniza.frame.setVisible(true);
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

