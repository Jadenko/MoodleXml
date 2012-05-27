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
	private boolean bsingle;
	private boolean bshuffleanswers;
	private List<Answer> lanswer;
	private AnswerNumbering oanswernumbering;
	private String scorrectfeedback;
	private String spartiallycorrectfeedback;
	private String sincorrectfeedback;


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
		return bsingle;
	}

	/**
	 * 
	 * @param setting the single tag
	 */
	public void setSingle(boolean single) {
		this.bsingle = single;
	}

	/**
	 * 
	 * @return getting the shuffle answers tag
	 */
	public boolean getShuffleanswers() {
		return bshuffleanswers;
	}

	/**
	 * 
	 * @param shuffleanswers setting the shuffle answers tag
	 */
	public void setShuffleanswers(boolean shuffleanswers) {
		this.bshuffleanswers = shuffleanswers;
	}

	/**
	 * 
	 * @return getting the list of answer
	 */
	public List<Answer> getAnswer() {
		return lanswer;
	}

	/**
	 * 
	 * @param answer the list of answer 
	 */
	public void setAnswer(List<Answer> answer) {
		this.lanswer = answer;
	}

	/**
	 * 
	 * @return getting the answer numbering
	 * @see AnswerNumerical
	 */
	public AnswerNumbering getAnswernumbering() {
		return oanswernumbering;
	}

	/**
	 * 
	 * @param answernumbering setting the answer numbering
	 */
	public void setAnswernumbering(AnswerNumbering answernumbering) {
		this.oanswernumbering = answernumbering;
	}

	/**
	 * 
	 * @return the correct feedback
	 */
	public String getCorrectfeedback() {
		return scorrectfeedback;
	}

	/**
	 * 
	 * @param correctfeedback the correct feedback
	 */
	public void setCorrectfeedback(String correctfeedback) {
		this.scorrectfeedback = correctfeedback;
	}

	/**
	 * 
	 * @return the partially correct feedback
	 */
	public String getPartiallycorrectfeedback() {
		return spartiallycorrectfeedback;
	}

	/**
	 * 
	 * @param partiallycorrectfeedback the partially correct feedback
	 */
	public void setPartiallycorrectfeedback(String partiallycorrectfeedback) {
		this.spartiallycorrectfeedback = partiallycorrectfeedback;
	}

	/**
	 * 
	 * @return the incorrect feedback
	 */
	public String getIncorrectfeedback() {
		return sincorrectfeedback;
	}

	/**
	 * 
	 * @param incorrectfeedback the incorrect feedback
	 */
	public void setIncorrectfeedback(String incorrectfeedback) {
		this.sincorrectfeedback = incorrectfeedback;
	}

}
