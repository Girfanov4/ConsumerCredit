
public abstract class Credit {
	private Double loanAmount;
	private Double annualInterestRate;
	private Integer loanTermInYears;
	private double monthlyInterestRate;
	
	public void monthlyInterestRate() {
		monthlyInterestRate = annualInterestRate / 100 / 12;
	};
	
	public abstract void numberOfPayments(Double loanAmount);
	
	public abstract void monthlyPayment();

	public Integer getLoanTermInYears() {
		return loanTermInYears;
	}

	public void setLoanTermInYears(Integer loanTermInYears) {
		this.loanTermInYears = loanTermInYears;
	}
	
	
}

