package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Class representing a new Sub question
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Subquestion {

	String text;
	Answer answer;

	/**
	 * Default constructor with no fields
	 */
	public Subquestion() {
		super();
	}

	/**
	 * Construct a new sub question with all fields
	 * @param text the text 
	 * @param answer the answer
	 */
	public Subquestion(String text, Answer answer) {
		super();
		this.text = text;
		this.answer = answer;
	}

	/**
	 * 
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text the text
	 */
	public void setText(String text) {
		this.text = text;
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
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
