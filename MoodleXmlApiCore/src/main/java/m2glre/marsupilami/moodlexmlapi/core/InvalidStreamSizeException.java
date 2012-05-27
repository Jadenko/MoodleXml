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
	private Long maxSize ;
	private Long streamSize ;
	
	/**
	 * @return the maxSize
	 */
	public Long getMaxSize() {
		return maxSize;
	}

	/**
	 * @return the streamSize
	 */
	public Long getStreamSize() {
		return streamSize;
	}

	public InvalidStreamSizeException(Long maxSize, Long streamSize) {
		super("invalidStreamSizeException");
		this.maxSize = maxSize ;
		this.streamSize = streamSize ;
	}


}
