package personal.jitendra.creditcard.bo;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * CreditCardNumberGeneratorBO class
 * 
 * @author Jitendra
 *
 */
@Component
public class CreditCardNumberGeneratorBO {
	private Random random = new Random();

	public String generate(CardType cardType) {
		return generate(cardType.getNumberStartsWith(), cardType.getNumberLength());
	}

	private String generate(String startWith, int ccnLength) {

		int numOfdigitsTobeGenerated = ccnLength - startWith.length();

		int numOfRandomDigits = numOfdigitsTobeGenerated - 1;

		StringBuilder builder = new StringBuilder(startWith);
		for (int i = 0; i < numOfRandomDigits; i++) {
			int digit = this.random.nextInt(10);
			builder.append(digit);
		}

		// Using Luhn algorithm to calculate the last digit.
		int lastDigit = this.calculateLastDigit(builder.toString());
		builder.append(lastDigit);

		return builder.toString();
	}

	/**
	 * Calculate last digit with the help of Luhn algorithm algorithm
	 * 
	 * @param number
	 * @return last digit of credit card number
	 */
	private int calculateLastDigit(String number) {

		int sum = 0;
		for (int i = 0; i < number.length(); i++) {

			// Get the single digit
			int digit = Integer.parseInt(number.substring(i, (i + 1)));

			if ((i % 2) == 0) {
				digit = digit * 2;
				digit = digit > 9 ? digit - 9 : digit;
			}
			sum += digit;
		}

		// Get last number required to make the sum as a multiple of 10
		int mod = sum % 10;
		return ((mod == 0) ? 0 : 10 - mod);
	}

}
