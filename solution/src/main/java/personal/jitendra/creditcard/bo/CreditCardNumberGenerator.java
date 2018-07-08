package personal.jitendra.creditcard.bo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

	public List<CreditCard> generateCreditCards(CardType cardType, int numberOfCard)
			throws InterruptedException, ExecutionException {
		List<String> ccnList = new ArrayList<>();
		for (int j = 0; j < numberOfCard; j++) {
			String ccn = ccnGeneratorBO.generate(cardType);
			ccnList.add(ccn);
		}

		List<CreditCard> creditCardList = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Map<String, Future<Boolean>> ccnIsValidFlagMap = new LinkedHashMap<>();
		for (int j = 0; j < ccnList.size(); j++) {
			String creditCardNumber = ccnList.get(j);
			Future<Boolean> future = executor
					.submit((Callable<Boolean>) new CreditCardNumberValidator(creditCardNumber));
			ccnIsValidFlagMap.put(creditCardNumber, future);
		}
		Set<String> ccnSet = ccnIsValidFlagMap.keySet();
		for (String ccn : ccnSet) {
			Future<Boolean> futureValue = ccnIsValidFlagMap.get(ccn);
			boolean isValidCCN = futureValue.get();
			if (isValidCCN) {
				creditCardList.add(new CreditCard(cardType, ccn));
			}
		}
		
		// shut down the executor service now
		executor.shutdown();
		return creditCardList;
	}

}
