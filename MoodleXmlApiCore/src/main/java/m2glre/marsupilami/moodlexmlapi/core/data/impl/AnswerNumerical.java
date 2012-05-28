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
	float itolerance;


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
	public AnswerNumerical(float fraction, String text,int tolerance, String feedback) {
		this.ffraction = fraction;
		this.stext = text;
		this.sfeedback = feedback;
		this.itolerance = tolerance;
	}

	/**
	 * @return getting the tolerance of the numerical answer
	 */
	public float getTolerance() {
		return itolerance;
	}

	/**
	 * @param tolerance setting the tolerance of the numerical answer
	 */
	public void setTolerance(float tolerance) {
		this.itolerance = tolerance;
	}
}
