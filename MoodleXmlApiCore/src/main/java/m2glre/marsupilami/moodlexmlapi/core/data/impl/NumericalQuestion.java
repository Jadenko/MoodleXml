package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

/**
 * Class representing a new Numerical question. 
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class NumericalQuestion extends GenericQuestion {

	/**
	 * The default constructor of a new numerical question.
	 */
	public NumericalQuestion() {
		super();
		this.setType(QuestionType.numerical);
	}

	/**
	 * @see AnswerNumerical
	 */
	private List<AnswerNumerical> answer;
	/**
	 * @see Unit
	 */
	@XmlElementWrapper(name="units")
	private List<Unit> unit;

	/**
	 * 
	 * @return the list of numerical answers
	 */
	public List<AnswerNumerical> getAnswer() {
		return answer;
	}

	/**
	 * 
	 * @param answer the list of numerical answers
	 */
	public void setAnswer(List<AnswerNumerical> answer) {
		this.answer = answer;
	}

	/**
	 * 
	 * @return the list of units
	 */
	public List<Unit> getUnit() {
		return unit;
	}

	/**
	 * 
	 * @param unit the list of units
	 */
	public void setUnit(List<Unit> unit) {
		this.unit = unit;
	}

}
