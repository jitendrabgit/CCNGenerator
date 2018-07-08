package personal.jitendra.creditcard.bo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for CreditCardNumberGeneratorBO
 * 
 * @author Jitendra
 *
 */
public class CreditCardNumberGeneratorBOTest {

	@Test
	public void testGenerate() {
		CreditCardNumberGeneratorBO creditCardNumberGeneratorBO = new CreditCardNumberGeneratorBO();
		String visaCreditCardNum = creditCardNumberGeneratorBO.generate(CardType.VISA);
		assertTrue(visaCreditCardNum.startsWith(CardType.VISA.getNumberStartsWith()));
		assertEquals(CardType.VISA.getNumberLength(), visaCreditCardNum.length());

		String masterCreditCardNum = creditCardNumberGeneratorBO.generate(CardType.MASTER);
		assertTrue(masterCreditCardNum.startsWith(CardType.MASTER.getNumberStartsWith()));
		assertEquals(CardType.MASTER.getNumberLength(), masterCreditCardNum.length());

		String americanExpressCreditCardNum = creditCardNumberGeneratorBO.generate(CardType.AMERICANEXPRESS);
		assertTrue(americanExpressCreditCardNum.startsWith(CardType.AMERICANEXPRESS.getNumberStartsWith()));
		assertEquals(CardType.AMERICANEXPRESS.getNumberLength(), americanExpressCreditCardNum.length());

		String discoverCreditCardNum = creditCardNumberGeneratorBO.generate(CardType.DISCOVER);
		assertTrue(discoverCreditCardNum.startsWith(CardType.DISCOVER.getNumberStartsWith()));
		assertEquals(CardType.DISCOVER.getNumberLength(), discoverCreditCardNum.length());
	}

}
