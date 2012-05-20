package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlRootElement(name = "question")
public class MultipleChoiceQuestion extends GenericQuestion {

	@XmlElement(name = "single")
	boolean single;
	int shuffleanswers;
	List<Answer> answer;
	AnswerNumbering answernumbering;


	
	public MultipleChoiceQuestion() {
		super();
		this.setQuestionType(QuestionType.multichoice);
	}

	public boolean isSingle() {
		return single;
	}

	public void setSingle(boolean single) {
		this.single = single;
	}

	public int getShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(int shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public AnswerNumbering getAnswernumbering() {
		return answernumbering;
	}

	public void setAnswernumbering(AnswerNumbering answernumbering) {
		this.answernumbering = answernumbering;
	}

}


enum AnswerNumbering {
	none,
	abc,
	ABCD,
	o123
}
