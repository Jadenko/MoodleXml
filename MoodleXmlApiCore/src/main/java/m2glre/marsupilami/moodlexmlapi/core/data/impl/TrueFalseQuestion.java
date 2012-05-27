package m2glre.marsupilami.moodlexmlapi.core.data.impl;
/**
 * Class representing a True/False question
 * More than the attributes of a generic question, this class defines her specific attributes.
 * Two answer tags are given, one which is true, and one which is false.
 * @author Marsupilami's Band
 */
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrueFalseQuestion extends GenericQuestion {

	private List<Answer> answer;

	/**
	 * Construct a new true/false question
	 */
	public TrueFalseQuestion() {
		super();
		this.setType(QuestionType.truefalse);
	}

	/**
	 * 
	 * @return the list of answers
	 */
	public List<Answer> getAnswer() {
		return answer;
	}

	/**
	 * 
	 * @param answer the list of answers
	 */
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

}
