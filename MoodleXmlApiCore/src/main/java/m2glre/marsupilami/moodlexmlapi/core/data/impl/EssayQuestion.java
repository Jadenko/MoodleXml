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

	boolean bshuffleanswers;
	Answer oanswer;

	public EssayQuestion() {
		super();
		this.setType(QuestionType.essay);
	}

	/**
	 * Construct a new essay question
	 * @param shuffleanswers the shuffle answers
	 * @param answer the answer
	 */
	public EssayQuestion(boolean shuffleanswers, Answer answer) {
		super();
		this.bshuffleanswers = shuffleanswers;
		this.oanswer = answer;
		this.setType(QuestionType.essay);
	}

	/**
	 * 
	 * @return the shuffle answers tag
	 */
	public boolean isShuffleanswers() {
		return bshuffleanswers;
	}

	/**
	 * 
	 * @param shuffleanswers the shuffle answers tag
	 */
	public void setShuffleanswers(boolean shuffleanswers) {
		this.bshuffleanswers = shuffleanswers;
	}

	/**
	 * 
	 * @return the answer 
	 */
	public Answer getAnswer() {
		return oanswer;
	}

	/**
	 * 
	 * @param answer the answer
	 */
	public void setAnswer(Answer answer) {
		this.oanswer = answer;
	}

}
