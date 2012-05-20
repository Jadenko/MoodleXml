package m2glre.marsupilami.moodlexmlapi.core.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.impl.Answer;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrueFalseQuestion extends GenericQuestion {

	private List<Answer> answer;

	public TrueFalseQuestion() {
		super();
		this.setQuestionType(QuestionType.truefalse);
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

}
