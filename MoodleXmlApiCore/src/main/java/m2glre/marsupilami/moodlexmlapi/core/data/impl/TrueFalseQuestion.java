package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrueFalseQuestion extends GenericQuestion {

	private List<Answer> lanswer;

	public TrueFalseQuestion() {
		super();
		this.setType(QuestionType.truefalse);
	}

	public List<Answer> getAnswer() {
		return lanswer;
	}

	public void setAnswer(List<Answer> answer) {
		this.lanswer = answer;
	}

}
