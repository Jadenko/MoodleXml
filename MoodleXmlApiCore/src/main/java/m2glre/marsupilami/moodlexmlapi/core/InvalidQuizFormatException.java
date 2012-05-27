package m2glre.marsupilami.moodlexmlapi.core;
/**
 * Class representing a special exception, and it's thrown when importing an invalid quiz format 
 * @author Marsupilami's Band
 *
 */
public class InvalidQuizFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construct an invalid quiz format exception
	 * @param parentException
	 */
	public InvalidQuizFormatException(Throwable parentException) {
		super("invalidQuizFormat", parentException);
	}


}


