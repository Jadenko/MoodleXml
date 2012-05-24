package m2glre.marsupilami.moodlexmlapi.core.data;

public class QuestionError {

	private String code;
	private String description;

	public QuestionError() {
	}

	/**
	 * Create a question error object
	 * 
	 * @param code
	 * @param description
	 */
	public QuestionError(String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
