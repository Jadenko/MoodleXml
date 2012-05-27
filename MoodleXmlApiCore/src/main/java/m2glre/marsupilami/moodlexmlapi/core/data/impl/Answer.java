package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {

	@XmlAttribute
	float ffraction;
	String stext;
	String sfeedback;

	public Answer() {

	}

	public Answer(float fraction, String text, String feedback) {
		this.ffraction = fraction;
		this.stext = text;
		this.sfeedback = feedback;
	}

	public Answer(float fraction, String feedback) {
		this.ffraction = fraction;
		this.sfeedback = feedback;
	}

	public Answer(String text) {
		this.stext = text;
	}

	public float getFraction() {
		return ffraction;
	}

	public void setFraction(int fraction) {
		this.ffraction = fraction;
	}

	public String getText() {
		return stext;
	}

	public void setText(String text) {
		this.stext = text;
	}

	public String getFeedback() {
		return sfeedback;
	}

	public void setFeedback(String feedback) {
		this.sfeedback = feedback;
	}

}
