package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {

	@XmlAttribute
	float fraction;
	String text;
	String feedback;

	public Answer() {

	}

	public Answer(float fraction, String text, String feedback) {
		this.fraction = fraction;
		this.text = text;
		this.feedback = feedback;
	}

	public Answer(float fraction, String feedback) {
		this.fraction = fraction;
		this.feedback = feedback;
	}

	public Answer(String text) {
		this.text = text;
	}

	public float getFraction() {
		return fraction;
	}

	public void setFraction(int fraction) {
		this.fraction = fraction;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
