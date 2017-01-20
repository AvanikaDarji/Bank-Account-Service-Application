package FinalProject;

import java.util.Date;




	public class Account {
		


		private static double annualInterestRate = 3.0;

		private	int Id ;

		private double balance;

		private Date  dateCreated  = new Date();
		
		Account(){

		Id = 0;

		balance = 0.0;

		}
		Account(int id,double bal){

		Id = id;

		balance = bal;

	
		}

		public void setId(int id){

		Id = id;

		}
		public int getId(){

		return Id;

		}

		public void setBalance(double bal){

		balance = bal;

		}

		public double getBalance(){

		return balance;

		}

		public static void setAnnualInterestRate(double AnnualInterestRate){

		annualInterestRate = AnnualInterestRate;

		}

		public static double getAnnualInterestRate(){

		return annualInterestRate;

		}

		public  Date getDate(){
			return dateCreated;
		}

		public double getMonthlyInterestRate(){

		return (annualInterestRate/12);

		}


		public double getMonthlyInterest(){

		double monthlyInterest = (annualInterestRate/1200)*balance;

		return monthlyInterest;

		}
		public void withdraw(double amount){
		balance = balance - amount;

		}
		public void deposit(double amount) {

		  balance = balance + amount;

		   }
		void displayAccount(Account account){
			
		}
	void displayAccounts(Account[] account_array)
	{
		System.out.printf("%14d",getId());
		System.out.printf("%21.2f",getMonthlyInterest()) ;
		System.out.printf("%16.2f",getBalance()) ;
		System.out.print(getDate());
		
		System.out.print("\n");
		}

	}
