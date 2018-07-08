package personal.jitendra.creditcard.bo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for CardType
 * 
 * @author Jitendra
 *
 */
public class CardTypeTest {

	@Test
	public void testCardType() {
		CardType visaCard = CardType.VISA;
		assertEquals("4", visaCard.getNumberStartsWith());
		assertEquals(16, visaCard.getNumberLength());

		CardType masterCard = CardType.MASTER;
		assertEquals("5", masterCard.getNumberStartsWith());
		assertEquals(16, masterCard.getNumberLength());

		CardType americanExpressCard = CardType.AMERICANEXPRESS;
		assertEquals("37", americanExpressCard.getNumberStartsWith());
		assertEquals(15, americanExpressCard.getNumberLength());

		CardType discoverCard = CardType.DISCOVER;
		assertEquals("6", discoverCard.getNumberStartsWith());
		assertEquals(16, discoverCard.getNumberLength());
	}

}
