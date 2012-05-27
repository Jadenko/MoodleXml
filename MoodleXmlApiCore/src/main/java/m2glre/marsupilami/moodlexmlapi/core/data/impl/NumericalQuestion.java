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

	public NumericalQuestion() {
		super();
		this.setType(QuestionType.numerical);
	}

	private List<AnswerNumerical> lanswer;
	@XmlElementWrapper(name="units")
	private List<Unit> lunit;

	public List<AnswerNumerical> getAnswer() {
		return lanswer;
	}

	public void setAnswer(List<AnswerNumerical> answer) {
		this.lanswer = answer;
	}

	public List<Unit> getUnit() {
		return lunit;
	}

	public void setUnit(List<Unit> unit) {
		this.lunit = unit;
	}

}
