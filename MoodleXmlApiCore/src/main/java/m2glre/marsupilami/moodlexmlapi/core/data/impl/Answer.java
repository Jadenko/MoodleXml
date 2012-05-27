package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
/**
 * Class representing an answer.
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {

	/**
	 * identifies which option is correct (100) and which is false (0)
	 */
	@XmlAttribute
	float fraction;
	/**
	 * The text of the answer
	 */
	String text;
	/**
	 * The feedback of the question
	 */
	String feedback;

	public Answer() {

	}

	/**
	 * Construct a  new answer with all the attributes 
	 * @param fraction the fraction
	 * @param text the text
	 * @param feedback the feedback
	 */
	public Answer(float fraction, String text, String feedback) {
		this.fraction = fraction;
		this.text = text;
		this.feedback = feedback;
	}

	/**
	 * Construct a  new answer with a fraction attribute and feedback. 
	 * @param fraction identifies which option is correct (100) and which is false (0)
	 * @param feedback the feedback
	 */
	public Answer(float fraction, String feedback) {
		this.fraction = fraction;
		this.feedback = feedback;
	}

	/**
	 * Construct a  new answer with only text attribute. 
	 * @param text the text
	 */
	public Answer(String text) {
		this.text = text;
	}

	/**
	 * 
	 * @return the fraction
	 */
	public float getFraction() {
		return fraction;
	}

	/**
	 * @param fraction setting the fraction of the answer
	 */
	public void setFraction(int fraction) {
		this.fraction = fraction;
	}

	/**
	 * 
	 * @return getting the text of the answer
	 */
	public String getText() {
		return text;
	}

	/**
	 * 
	 * @param text Setting the text of the answer
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
 	 * @return getting the feedback of the answer
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
  	 * @param getting the feedback of the answer
	 */
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
