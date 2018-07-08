package personal.jitendra.creditcard.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for CreditCardNumberValidator
 * 
 * @author Jitendra
 *
 */
public class CreditCardNumberValidatorTest {

	/**
	 * test validateCreditCardNumber method with valid creditCardNumber
	 */
	@Test
	public void testValidateCreditCardNumberWithValidCCN() {
		String creditCardNumber = "4374436105489468";
		boolean isValidCreditCardNumber = CreditCardNumberValidator.validateCreditCardNumber(creditCardNumber);
		assertTrue(isValidCreditCardNumber);
	}

	/**
	 * test validateCreditCardNumber method with invalid creditCardNumber
	 */
	@Test
	public void testValidateCreditCardNumberWithInValidCCN() {
		String creditCardNumber = "4374436105489467";
		boolean isValidCreditCardNumber = CreditCardNumberValidator.validateCreditCardNumber(creditCardNumber);
		assertFalse(isValidCreditCardNumber);
	}

}
