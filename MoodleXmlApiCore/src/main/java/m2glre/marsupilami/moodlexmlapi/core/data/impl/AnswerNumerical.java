package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AnswerNumerical extends Answer {

	int tolerance;

	public AnswerNumerical() {
		super();
	}
	
	public AnswerNumerical(float fraction, String text,int tolerance, String feedback) {
		this.fraction = fraction;
		this.text = text;
		this.feedback = feedback;
		this.tolerance = tolerance;
	}

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}
}
