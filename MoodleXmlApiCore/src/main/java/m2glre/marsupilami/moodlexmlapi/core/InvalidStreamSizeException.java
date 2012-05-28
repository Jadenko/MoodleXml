package m2glre.marsupilami.moodlexmlapi.core;

/**
 * Class representing a special exception, and it's thrown when importing a none supported stream size.
 * @author Marsupilami's Band
 *
 */
public class InvalidStreamSizeException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long lmaxSize ;
	private Long lstreamSize ;

	/**
	 * @return the maxSize
	 */
	public Long getMaxSize() {
		return lmaxSize;
	}

	/**
	 * @return the streamSize
	 */
	public Long getStreamSize() {
		return lstreamSize;
	}

	public InvalidStreamSizeException(Long maxSize, Long streamSize) {
		super("invalidStreamSizeException");
		this.lmaxSize = maxSize ;
		this.lstreamSize = streamSize ;
	}


}
