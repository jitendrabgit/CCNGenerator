package personal.jitendra.creditcard.validator;

/**
 * CreditCardNumberValidator class
 * 
 * @author Jitendra
 *
 */
public class CreditCardNumberValidator {

	public static boolean validateCreditCardNumber(String number) {
		int sum = 0;
		int length = number.length();
		for (int i = 0; i < length - 1; i++) {

			// Get the single digit
			int digit = Integer.parseInt(number.substring(i, (i + 1)));

			if ((i % 2) == 0) {
				digit = digit * 2;
				if (digit > 9) {
					digit = digit > 9 ? digit - 9 : digit;
				}
			}
			sum += digit;
		}

		sum = sum + Integer.parseInt(number.substring(length - 1, length));
		return sum % 10 == 0;
	}
}
