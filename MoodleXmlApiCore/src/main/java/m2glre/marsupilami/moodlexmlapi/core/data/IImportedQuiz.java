package m2glre.marsupilami.moodlexmlapi.core.data;

import java.util.List;

/**
 * Interface representing an imported Moodle quiz
 * @author Marsupilami's Band 
 *
 */
public interface IImportedQuiz extends IQuiz {
	
	/**
	 * @return the count of processed questions
	 */
	public int getProcessedQuestionCount();
	
	/**
	 * @return the count of extracted questions
	 */
	public int getExtractedQuestionCount();
	
	/**
	 * @return the count of non extracted questions
	 */
	public int getNonExtractedQuestionCount();
	
	/**
	 * @return the list of processed questions
	 */
	public List<IQuestion> getProcessedQuestionList();
	
	/**
	 * @return the list of extracted questions
	 */
	public List<IQuestion> getExtractedQuestionList();
	
	/**
	 * @return the list of non extracted questions
	 */
	public List<IQuestion> getNonExtractedQuestionList();
	

}
