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
	 * @throws InterruptedException 
	 */
	@Test
	public void testValidateCreditCardNumberWithValidCCN() throws InterruptedException {
		String creditCardNumber = "4374436105489468";
		boolean isValidCreditCardNumber = new CreditCardNumberValidator(creditCardNumber).validateCreditCardNumber(creditCardNumber);
		assertTrue(isValidCreditCardNumber);
	}

	/**
	 * test validateCreditCardNumber method with invalid creditCardNumber
	 * @throws InterruptedException 
	 */
	@Test
	public void testValidateCreditCardNumberWithInValidCCN() throws InterruptedException {
		String creditCardNumber = "4374436105489465";
		boolean isValidCreditCardNumber = new CreditCardNumberValidator(creditCardNumber).validateCreditCardNumber(creditCardNumber);
		assertFalse(isValidCreditCardNumber);
	}

}
