package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class EssayQuestion extends GenericQuestion {

	boolean bshuffleanswers;
	Answer oanswer;

	public EssayQuestion() {
		super();
		this.setType(QuestionType.essay);
	}

	public EssayQuestion(boolean shuffleanswers, Answer answer) {
		super();
		this.bshuffleanswers = shuffleanswers;
		this.oanswer = answer;
		this.setType(QuestionType.essay);
	}

	public boolean isShuffleanswers() {
		return bshuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.bshuffleanswers = shuffleanswers;
	}

	public Answer getAnswer() {
		return oanswer;
	}

	public void setAnswer(Answer answer) {
		this.oanswer = answer;
	}

}
