package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class AnswerNumerical extends Answer {

	int itolerance;

	public AnswerNumerical() {
		super();
	}

	public AnswerNumerical(float fraction, String text,int tolerance, String feedback) {
		this.ffraction = fraction;
		this.stext = text;
		this.sfeedback = feedback;
		this.itolerance = tolerance;
	}

	public int getTolerance() {
		return itolerance;
	}

	public void setTolerance(int tolerance) {
		this.itolerance = tolerance;
	}
}
