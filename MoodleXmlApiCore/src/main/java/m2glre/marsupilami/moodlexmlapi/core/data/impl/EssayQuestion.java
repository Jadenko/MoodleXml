package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class EssayQuestion extends GenericQuestion {

	boolean shuffleanswers;
	Answer answer;

	public EssayQuestion() {
		super();
		this.setType(QuestionType.essay);
	}

	public EssayQuestion(boolean shuffleanswers, Answer answer) {
		super();
		this.shuffleanswers = shuffleanswers;
		this.answer = answer;
		this.setType(QuestionType.essay);
	}

	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
