package personal.jitendra.creditcard.bo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CreditCard POJO class and its immutable
 * 
 * @author Jitendra
 *
 */
public final class CreditCard {

	private final CardType cardType;
	private final String creditCardNumber;
	private final String expiryDate;

	public CreditCard(CardType cardType, String creditCardNumber) {
		this.cardType = cardType;
		this.creditCardNumber = creditCardNumber;
		Date date = new Date();
		String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);
		this.expiryDate = formattedDate;
	}

	public CardType getCardType() {
		return cardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

}
