
public abstract class Credit {
	private Double loanAmount;
	private Double annualInterestRate;
	private Integer loanTermInYears;
	private double monthlyInterestRate;
	
	public void monthlyInterestRate() {
		monthlyInterestRate = annualInterestRate / 100 / 12;
	};
	
	public abstract void numberOfPayments();
	
	public abstract void monthlyPayment();
	
	
}

