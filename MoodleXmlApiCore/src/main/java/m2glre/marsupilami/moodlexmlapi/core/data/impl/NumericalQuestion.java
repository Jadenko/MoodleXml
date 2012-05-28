package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class NumericalQuestion extends GenericQuestion {
	
	boolean shuffleanswers;
	
	public NumericalQuestion() {
		super();
		this.setType(QuestionType.numerical);
	}

	private List<AnswerNumerical> answer;
	@XmlElementWrapper(name="units")
	private List<Unit> unit;

	public List<AnswerNumerical> getAnswer() {
		return answer;
	}

	public void setAnswer(List<AnswerNumerical> answer) {
		this.answer = answer;
	}

	public List<Unit> getUnit() {
		return unit;
	}

	public void setUnit(List<Unit> unit) {
		this.unit = unit;
	}
	
	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}

}
