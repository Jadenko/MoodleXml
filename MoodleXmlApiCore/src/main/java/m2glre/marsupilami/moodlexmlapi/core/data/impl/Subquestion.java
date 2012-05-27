package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Subquestion {

	String stext;
	Answer oanswer;

	public Subquestion() {
		super();
	}

	public Subquestion(String text, Answer answer) {
		super();
		this.stext = text;
		this.oanswer = answer;
	}

	public String getText() {
		return stext;
	}

	public void setText(String text) {
		this.stext = text;
	}

	public Answer getAnswer() {
		return oanswer;
	}

	public void setAnswer(Answer answer) {
		this.oanswer = answer;
	}

}
