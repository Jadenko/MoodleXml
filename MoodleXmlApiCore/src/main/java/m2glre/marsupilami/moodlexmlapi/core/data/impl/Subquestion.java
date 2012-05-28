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

	String stext;
	Answer oanswer;

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
		this.stext = text;
		this.oanswer = answer;
	}

	/**
	 * 
	 * @return the text
	 */
	public String getText() {
		return stext;
	}

	/**
	 * 
	 * @param text the text
	 */
	public void setText(String text) {
		this.stext = text;
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
