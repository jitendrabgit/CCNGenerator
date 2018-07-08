package personal.jitendra.creditcard.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import personal.jitendra.creditcard.bo.CardType;
import personal.jitendra.creditcard.bo.CreditCard;
import personal.jitendra.creditcard.bo.CreditCardNumberGenerator;

/**
 * Controller class for CreditCardNumberGenerator
 * 
 * @author Jitendra
 *
 */
@RestController
public class CreditCardNumberGeneratorController {

	@Autowired
	private CreditCardNumberGenerator ccnGenerator;

	@RequestMapping("/CCEngine/{typeOfCard}/{noOfCards}")
	public String generateCreditCards(@PathVariable String typeOfCard, @PathVariable String noOfCards)
			throws JsonProcessingException, InterruptedException, ExecutionException {

		CardType cardType = CardType.valueOf(typeOfCard);
		int numberOfCards = Integer.parseInt(noOfCards);
		List<CreditCard> creditCardList = ccnGenerator.generateCreditCards(cardType, numberOfCards);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(creditCardList);

	}
}