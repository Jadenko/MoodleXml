package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MultipleChoiceQuestion extends GenericQuestion {

	private boolean bsingle;
	private boolean bshuffleanswers;
	private List<Answer> lanswer;
	private AnswerNumbering oanswernumbering;
	private String scorrectfeedback;
	private String spartiallycorrectfeedback;
	private String sincorrectfeedback;

	public MultipleChoiceQuestion() {
		super();
		this.setType(QuestionType.multichoice);
	}

	public boolean isSingle() {
		return bsingle;
	}

	public void setSingle(boolean single) {
		this.bsingle = single;
	}

	public boolean getShuffleanswers() {
		return bshuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.bshuffleanswers = shuffleanswers;
	}

	public List<Answer> getAnswer() {
		return lanswer;
	}

	public void setAnswer(List<Answer> answer) {
		this.lanswer = answer;
	}

	public AnswerNumbering getAnswernumbering() {
		return oanswernumbering;
	}

	public void setAnswernumbering(AnswerNumbering answernumbering) {
		this.oanswernumbering = answernumbering;
	}

	public String getCorrectfeedback() {
		return scorrectfeedback;
	}

	public void setCorrectfeedback(String correctfeedback) {
		this.scorrectfeedback = correctfeedback;
	}

	public String getPartiallycorrectfeedback() {
		return spartiallycorrectfeedback;
	}

	public void setPartiallycorrectfeedback(String partiallycorrectfeedback) {
		this.spartiallycorrectfeedback = partiallycorrectfeedback;
	}

	public String getIncorrectfeedback() {
		return sincorrectfeedback;
	}

	public void setIncorrectfeedback(String incorrectfeedback) {
		this.sincorrectfeedback = incorrectfeedback;
	}

}
