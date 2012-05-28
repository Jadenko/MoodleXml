package m2glre.marsupilami.moodlexmlapi.core.data;
/**
 * Classe représentant une erreur  
 * @author Marsupilami's Band
 *
 */
public class QuestionError {

	private String scode;
	private String sdescription;
	public QuestionError() {
	}

/**
 * Create a question error object
 *
 * @param code
 * @param description
 */
	public QuestionError(String code, String description) {
		this.scode = code;
		this.sdescription = description;
	}

	/**
	* @return the code
	*/
	public String getCode() {
		return scode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return sdescription;
	}

}
