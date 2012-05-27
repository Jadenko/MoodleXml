package m2glre.marsupilami.moodlexmlapi.core;

public class InvalidStreamSizeException extends Exception {

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
