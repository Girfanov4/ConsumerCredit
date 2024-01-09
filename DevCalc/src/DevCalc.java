import java.util.Arrays;
import java.util.List;


public class DevCalc {
	
	public static List<Object> getDetails(String _loanAmount, String _annualInterestRate, String _loanTermInYears){
		
//		Сумма кредита
		double loanAmount = Double.parseDouble(_loanAmount);
		
//		Годовая процентная ставка
		double annualInterestRate = Double.parseDouble(_annualInterestRate);
		
//		Срок кредита в годах
		int loanTermInYears = Integer.parseInt(_loanTermInYears);
		
//		Ежемесячная процентная ставка
		double monthlyInterestRate = getMonthlyInterestRate(annualInterestRate);
		
//		Количество Платежей
		int numberOfPayments = getNumberOfPayments(loanTermInYears);
		
//		Ежемесячная выплата
		double monthlyPayment =getMonthlyPayment(loanAmount,monthlyInterestRate,numberOfPayments);
		
		return Arrays.asList(monthlyInterestRate, numberOfPayments, monthlyPayment);
		
	}
	
	private static Double getMonthlyInterestRate(Double annualInterestRate) {
		
		return(annualInterestRate / 100 / 12);
		
	}
	private static Integer getNumberOfPayments(Integer loanTermInYears) {
		
		return(loanTermInYears * 12);
		
	}
	
	private static Double getMonthlyPayment(Double loanAmount, Double monthlyInterestRate, Integer numberOfPayments) {
		
		return((loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments)));
		
	}

}
