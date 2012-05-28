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
	 * @param _fraction the _fraction
	 * @param text the text
	 * @param feedback the feedback
	 */
	public Answer(float _fraction, String _text, String _feedback) {
		this.fraction = _fraction;
		this.text = _text;
		this.feedback = _feedback;
	}

	/**
	 * Construct a  new answer with a _fraction attribute and feedback. 
	 * @param _fraction identifies which option is correct (100) and which is false (0)
	 * @param feedback the feedback
	 */
	public Answer(float _fraction, String _feedback) {
		this.fraction = _fraction;
		this.feedback = _feedback;
	}

	/**
	 * Construct a  new answer with only text attribute. 
	 * @param text the text
	 */
	public Answer(String _text) {
		this.text = _text;
	}

	/**
	 * 
	 * @return the _fraction
	 */
	public float getFraction() {
		return fraction;
	}

	/**
	 * @param _fraction setting the _fraction of the answer
	 */
	public void setFraction(float _fraction) {
		this.fraction = _fraction;
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
	public void setText(String _text) {
		this.text = _text;
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
	public void setFeedback(String _feedback) {
		this.feedback = _feedback;
	}

}
