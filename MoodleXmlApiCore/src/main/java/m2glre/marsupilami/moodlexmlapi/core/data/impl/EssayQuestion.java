package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;
/**
 * Class representing an Essay Question
 * 
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EssayQuestion extends GenericQuestion {

	boolean shuffleanswers;
	Answer answer;

	public EssayQuestion() {
		super();
		this.setType(QuestionType.essay);
	}

	/**
	 * Construct a new essay question
	 * @param shuffleanswers the shuffle answers
	 * @param answer the answer
	 */
	public EssayQuestion(boolean _shuffleanswers, Answer _answer) {
		super();
		this.shuffleanswers = _shuffleanswers;
		this.answer = _answer;
		this.setType(QuestionType.essay);
	}

	/**
	 * 
	 * @return the shuffle answers tag
	 */
	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

	/**
	 * 
	 * @param shuffleanswers the shuffle answers tag
	 */
	public void setShuffleanswers(boolean _shuffleanswers) {
		this.shuffleanswers = _shuffleanswers;
	}

	/**
	 * 
	 * @return the answer 
	 */
	public Answer getAnswer() {
		return answer;
	}

	/**
	 * 
	 * @param answer the answer
	 */
	public void setAnswer(Answer _answer) {
		this.answer = _answer;
	}

}
