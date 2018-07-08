package personal.jitendra.creditcard.bo;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/**
 * Test class for CreditCard
 * 
 * @author Jitendra
 *
 */
public class CreditCardTest {

	@Test
	public void testCreditCard() {
		CreditCard creditCard = new CreditCard(CardType.VISA, "4237984281563488");
		assertEquals(CardType.VISA, creditCard.getCardType());
		assertEquals("4237984281563488", creditCard.getCreditCardNumber());
		Date date = new Date();
		String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
		assertEquals(formattedDate, creditCard.getExpiryDate());

	}

}
