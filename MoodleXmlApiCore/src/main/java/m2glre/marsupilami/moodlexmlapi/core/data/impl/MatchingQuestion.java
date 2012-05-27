package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MatchingQuestion extends GenericQuestion {

	boolean shuffleanswers;
	List<Subquestion> subquestion;

	public MatchingQuestion() {
		super();
		this.setQuestionType(QuestionType.matching);
	}

	public MatchingQuestion(boolean shuffleanswers,
			List<Subquestion> subquestion) {
		super();
		this.setQuestionType(QuestionType.matching);
		this.shuffleanswers = shuffleanswers;
		this.subquestion = subquestion;
	}

	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}

	public List<Subquestion> getSubquestion() {
		return subquestion;
	}

	public void setSubquestion(List<Subquestion> subquestion) {
		this.subquestion = subquestion;
	}

}
