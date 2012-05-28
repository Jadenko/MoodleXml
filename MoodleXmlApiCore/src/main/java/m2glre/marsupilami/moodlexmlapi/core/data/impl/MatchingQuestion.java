package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;
/**
 * Pair matching responses use the "shuffleanswers" tag to determine whether the order of the items should be randomized. 
 * Each pair is contained inside a "subquestion" tag. 
 * The first item of each pair is contained with a "text" tag, while the second has an "answer" tag around it as well.  
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchingQuestion extends GenericQuestion {

	boolean shuffleanswers;
	List<Subquestion> subquestion;

	/**
	 * Constructeur par défaut qui détermine le type des questions qui seront utilisées 
	 */
	public MatchingQuestion() {
		super();
		this.setType(QuestionType.matching);
	}

	/**
	 * Constructeur qui détermine le type des questions qui seront utilisées
	 * @param shuffleanswers To determine whether the order of the items should be randomized 
	 * @param subquestion The first item of each pair is contained with a "text" tag, while the second has an "answer" tag around it as well.
	 */
	public MatchingQuestion(boolean _shuffleanswers,
			List<Subquestion> _subquestion) {
		super();
		this.setType(QuestionType.matching);
		this.shuffleanswers = _shuffleanswers;
		this.subquestion = _subquestion;
	}

	/**
	 * @return The shuffleanswers
	 */
	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

	/**
	 * @param To set the shuffleanswers 
	 */
	public void setShuffleanswers(boolean _shuffleanswers) {
		this.shuffleanswers = _shuffleanswers;
	}

	/**
	 * @return A list of Subquestions
	 */
	public List<Subquestion> getSubquestion() {
		return subquestion;
	}

	/**
	 * @param subquestion To set the list of subquestions
	 */
	public void setSubquestion(List<Subquestion> _subquestion) {
		this.subquestion = _subquestion;
	}

}
