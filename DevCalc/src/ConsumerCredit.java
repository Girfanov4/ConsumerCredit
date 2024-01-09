
public class ConsumerCredit extends Credit {

	

	@Override
	public void numberOfPayments(Double loanAmount) {
		Integer numberOfPayments =getLoanTermInYears() * 12;
		
	}

	@Override
	public void monthlyPayment() {
		// TODO Автоматически созданная заглушка метода
		
	}

}
