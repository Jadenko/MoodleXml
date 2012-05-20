package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MultipleChoiceQuestion extends GenericQuestion {

	@XmlElement(name = "single")
	boolean single;
	boolean shuffleanswers;
	List<Answer> answer;
	AnswerNumbering answernumbering;
	String correctfeedback;
	String partiallycorrectfeedback;
	String incorrectfeedback;


	
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

	public boolean getShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
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

	public String getCorrectfeedback() {
		return correctfeedback;
	}

	public void setCorrectfeedback(String correctfeedback) {
		this.correctfeedback = correctfeedback;
	}

	public String getPartiallycorrectfeedback() {
		return partiallycorrectfeedback;
	}

	public void setPartiallycorrectfeedback(String partiallycorrectfeedback) {
		this.partiallycorrectfeedback = partiallycorrectfeedback;
	}

	public String getIncorrectfeedback() {
		return incorrectfeedback;
	}

	public void setIncorrectfeedback(String incorrectfeedback) {
		this.incorrectfeedback = incorrectfeedback;
	}

}

