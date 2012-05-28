package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
 * Class representing a numerical answer.
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AnswerNumerical extends Answer {

	/**
	 * how accurate must the number be?
	 */
	float tolerance;


	public AnswerNumerical() {
		super();
	}
	
	/**
	 * Construct a  new numerical answer with all the attributes 
	 * @param fraction identifies which option is correct (100) and which is false (0)
	 * @param tolerance the tolerance
	 * @param text the text
	 * @param feedback the feedback
	 */
	public AnswerNumerical(float _fraction, String _text,int _tolerance, String _feedback) {
		this.fraction = _fraction;
		this.text = _text;
		this.feedback = _feedback;
		this.tolerance = _tolerance;
	}

	/**
	 * @return getting the tolerance of the numerical answer
	 */
	public float getTolerance() {
		return tolerance;
	}

	/**
	 * @param tolerance setting the tolerance of the numerical answer
	 */
	public void setTolerance(float _tolerance) {
		this.tolerance = _tolerance;
	}
}
