package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

/**
 * Class representing a Short Answer Question. 
 * It supports alternative correct responses, each with its own weighting and feedback.
 * @author Marsupilami's Band
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
public class ShortAnswerQuestion extends GenericQuestion {

	/**
	 * The List Of Answers of the question
	 */
	private List<Answer> answer;
	/**
	 * The "usecase" tag toggles case-sensitivity with the values 1/0 or true/false.
	 */
	private boolean usecase;


	/**
	 * Construct a new short answer question
	 */
	public ShortAnswerQuestion() {
		super();
		this.setType(QuestionType.shortanswer);
	}

	/**
	 * 
	 * @return the list of answers
	 */
	public List<Answer> getAnswer() {
		return answer;
	}

	/**
	 * 
	 * @param answer the list of answers
	 */
	public void setAnswer(List<Answer> _answer) {
		this.answer = _answer;
	}

	/**
	 * 
	 * @return check the use case tag
	 */
	public boolean isUsecase() {
		return usecase;
	}

	/**
	 * 
	 * @param usecase the use case tag
	 */
	public void setUsecase(boolean _usecase) {
		this.usecase = _usecase;
	}

}
