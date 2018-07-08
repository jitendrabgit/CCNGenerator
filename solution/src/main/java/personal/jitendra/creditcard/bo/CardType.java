package personal.jitendra.creditcard.bo;

/**
 * Enum for CardType
 * 
 * @author Jitendra
 *
 */
public enum CardType {
	VISA("4", 16), MASTER("5", 16), AMERICANEXPRESS("37", 15), DISCOVER("6", 15);

	private String startsWith;

	private int length;

	CardType(String startingDigits, int length) {
		this.startsWith = startingDigits;
		this.length = length;
	}

	public String getStartsWith() {
		return startsWith;
	}

	public int getLength() {
		return length;
	}

}
