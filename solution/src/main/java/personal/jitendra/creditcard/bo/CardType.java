package personal.jitendra.creditcard.bo;

/**
 * Enum for CardType
 * 
 * @author Jitendra
 *
 */
public enum CardType {
	VISA("4", 16), MASTER("5", 16), AMERICANEXPRESS("37", 15), DISCOVER("6", 15);

	private String numberStartsWith;

	private int numberLength;

	/**
	 * Constructor for CardType
	 * 
	 * @param numberStartsWith
	 * @param numberLength
	 */
	CardType(String numberStartsWith, int numberLength) {
		this.numberStartsWith = numberStartsWith;
		this.numberLength = numberLength;
	}

	public String getNumberStartsWith() {
		return numberStartsWith;
	}

	public int getNumberLength() {
		return numberLength;
	}

}
