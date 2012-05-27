package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

/**
 * Class representing a multiple choice question. 
 * More than the attributes of a generic question, this class defines her specific attributes.
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MultipleChoiceQuestion extends GenericQuestion {

	/**
	 *  single is used to distinguish single response (radio button) and multiple response (checkbox) variants.
	 */
	private boolean single;
	private boolean shuffleanswers;
	private List<Answer> answer;
	private AnswerNumbering answernumbering;
	private String correctfeedback;
	private String partiallycorrectfeedback;
	private String incorrectfeedback;

	/**
	 * Construct a new multiple choice question 
	 */
	public MultipleChoiceQuestion() {
		super();
		this.setType(QuestionType.multichoice);
	}

	/**
	 * 
	 * @return is the single tag set to true or false
	 */
	public boolean isSingle() {
		return single;
	}

	/**
	 * 
	 * @param setting the single tag
	 */
	public void setSingle(boolean single) {
		this.single = single;
	}

	/**
	 * 
	 * @return getting the shuffle answers tag
	 */
	public boolean getShuffleanswers() {
		return shuffleanswers;
	}

	/**
	 * 
	 * @param shuffleanswers setting the shuffle answers tag
	 */
	public void setShuffleanswers(boolean shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}

	/**
	 * 
	 * @return getting the list of answer
	 */
	public List<Answer> getAnswer() {
		return answer;
	}

	/**
	 * 
	 * @param answer the list of answer 
	 */
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	/**
	 * 
	 * @return getting the answer numbering
	 * @see AnswerNumerical
	 */
	public AnswerNumbering getAnswernumbering() {
		return answernumbering;
	}

	/**
	 * 
	 * @param answernumbering setting the answer numbering
	 */
	public void setAnswernumbering(AnswerNumbering answernumbering) {
		this.answernumbering = answernumbering;
	}

	/**
	 * 
	 * @return the correct feedback
	 */
	public String getCorrectfeedback() {
		return correctfeedback;
	}

	/**
	 * 
	 * @param correctfeedback the correct feedback
	 */
	public void setCorrectfeedback(String correctfeedback) {
		this.correctfeedback = correctfeedback;
	}

	/**
	 * 
	 * @return the partially correct feedback
	 */
	public String getPartiallycorrectfeedback() {
		return partiallycorrectfeedback;
	}

	/**
	 * 
	 * @param partiallycorrectfeedback the partially correct feedback
	 */
	public void setPartiallycorrectfeedback(String partiallycorrectfeedback) {
		this.partiallycorrectfeedback = partiallycorrectfeedback;
	}

	/**
	 * 
	 * @return the incorrect feedback
	 */
	public String getIncorrectfeedback() {
		return incorrectfeedback;
	}

	/**
	 * 
	 * @param incorrectfeedback the incorrect feedback
	 */
	public void setIncorrectfeedback(String incorrectfeedback) {
		this.incorrectfeedback = incorrectfeedback;
	}

}
