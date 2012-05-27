package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class MatchingQuestion extends GenericQuestion {

	boolean bshuffleanswers;
	List<Subquestion> lsubquestion;

	public MatchingQuestion() {
		super();
		this.setType(QuestionType.matching);
	}

	public MatchingQuestion(boolean shuffleanswers,
			List<Subquestion> subquestion) {
		super();
		this.setType(QuestionType.matching);
		this.bshuffleanswers = shuffleanswers;
		this.lsubquestion = subquestion;
	}

	public boolean isShuffleanswers() {
		return bshuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.bshuffleanswers = shuffleanswers;
	}

	public List<Subquestion> getSubquestion() {
		return lsubquestion;
	}

	public void setSubquestion(List<Subquestion> subquestion) {
		this.lsubquestion = subquestion;
	}

}
