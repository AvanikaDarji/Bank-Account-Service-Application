package FinalProject;


	
	import java.util.Date;


	public class CDAccount extends Account {
		
		private int duration ;
		private double CDAnnualInterestRate;
		private Date  dateCreated  = new Date();

		public CDAccount() {

		}
		public CDAccount(int duration) {
			this.duration = duration;

		}
		public CDAccount(int duration, double CDAnnualInterestRate){
			this.duration = duration;
			this.CDAnnualInterestRate = CDAnnualInterestRate;
		}
		public CDAccount(int Id,double balance,int duration){
			this.duration = duration;
			setId(Id);
			setBalance(balance);
		}

		public int getDuration() {
			return duration;
		}
		
		public void setDuration(int duration) {
			if(duration > 3){
				CDAnnualInterestRate = getCDAnnualInterestRate();
			}
			this.duration = duration;
		}
		
		public double getCDAnnualInterestRate() {
			CDAnnualInterestRate = (getDuration()/3)*0.5 + getAnnualInterestRate();
			return CDAnnualInterestRate;
		}

		public void setCDAnnualInterestRate(double CDAnnualInterestRate) {
			this.CDAnnualInterestRate = CDAnnualInterestRate;
		}
		
		//override method
		public void displayAccounts(){
			System.out.printf("%14d", getId());
			System.out.printf("%16.2f",getBalance()) ;
			System.out.printf("%18.2f", getCDAnnualInterestRate()) ;
			System.out.print("        " + getDate());
			System.out.print("\n");
			for (int i = 1; i <= duration; i++){
				System.out.print("Month   " +i+ ":   "); 
				System.out.printf("%2.2f",+((getMonthlyInterest()*i) + getBalance()));
				System.out.println("");
			}
		}

		//override method 
		public double getMonthlyInterest(){
			double monthlyInterest = (getCDAnnualInterestRate()/1200)*getBalance();
			return monthlyInterest;
		}
}



