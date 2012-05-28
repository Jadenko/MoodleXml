package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

/**
 * An implementation of a IQuestion. 
 * Only getters are implemented.
 * Setters are managed in the sub classes.
 * @author Marsupilamis's Band
 * @see The interface IQuestion
 */
@XmlSeeAlso({ CategoryQuestion.class, GenericQuestion.class })
public class QuestionImpl implements IQuestion {

	/**
	 * Type of question
	 * @see QuestionType
	 */
	@XmlAttribute
	public QuestionType type;
	/**
	 * The name of the question
	 */
	public String name;
	/**
	 * The question text
	 */
	@XmlElement(name = "questiontext")
	public QuestionText questionText;
	/**
	 * The general feedback
	 */
	public String generalFeedBack;
	/**
	 * the penalty
	 */
	public Float penalty;
	/**
	 * The default grade
	 */
	public Float defaultGrade;
	/**
	 * The hidden tag
	 */
	@XmlElement(name = "hidden")
	public Boolean isHidden;
	/**
	 * The image URL
	 */
	public String imageUrl;
	/**
	 * The image base 64
	 */
	public String imageBase64;
	/** 
	 * The list of errors
	 */
	public List<QuestionError> errors;

	/**
	 * @return the type of question
	 */
	public QuestionType getType() {
		return type;
	}

	/**
	 * @return the name of the question
	 */
	public String getName() {
		name = name.replace("&lt;", "<");
		name = name.replace("&gt;", ">");
		return name;
	}

	/**
	 * @return the question text
	 */
	public QuestionText getQuestionText() {
		return questionText;
	}

	/**
	 * @return the general feedback
	 */
	public String getGeneralFeedBack() {
		return generalFeedBack;
	}

	/**
	 * @return the penalty
	 */
	public Float getPenalty() {
		return penalty;
	}

	/**
	 * @return the default grade
	 */
	public Float getDefaultGrade() {
		return defaultGrade;
	}

	/**
	 * @return hidden tag
	 */
	public Boolean isHidden() {
		return isHidden;
	}

	/**
	 * @return the image URL
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @return The image base 64
	 */
	public String getImageBase64() {
		return imageBase64;
	}

	/**
	 * @return the list of errors
	 */
	public List<QuestionError> getErrors() {
		return errors;
	}

}
