package personal.jitendra.creditcard.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import personal.jitendra.creditcard.validator.CreditCardNumberValidator;

/**
 * CreditCardNumberGenerator class
 * 
 * @author Jitendra
 *
 */
@Component
public class CreditCardNumberGenerator {

	@Autowired
	private CreditCardNumberGeneratorBO ccnGeneratorBO;

	public List<CreditCard> generateCreditCards(CardType cardType, int numberOfCard) {
		List<String> ccnList = new ArrayList<>();
		for (int j = 0; j < numberOfCard; j++) {
			String ccn = ccnGeneratorBO.generate(cardType);
			ccnList.add(ccn);
		}

		List<CreditCard> creditCardList = new ArrayList<>();
		for (int j = 0; j < ccnList.size(); j++) {
			String creditCardNumber = ccnList.get(j);
			if (CreditCardNumberValidator.validateCreditCardNumber(creditCardNumber)) {
				creditCardList.add(new CreditCard(cardType, creditCardNumber));
			}
		}
		return creditCardList;
	}

}
