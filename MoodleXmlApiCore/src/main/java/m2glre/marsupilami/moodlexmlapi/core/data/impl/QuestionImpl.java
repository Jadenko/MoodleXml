package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlSeeAlso({ CategoryQuestion.class, GenericQuestion.class })
public class QuestionImpl implements IQuestion {

	@XmlAttribute
	public QuestionType type;
	public String name;
	@XmlElement(name = "questiontext")
	public QuestionText questionText;
	public String generalFeedBack;
	public Float penalty;
	public Float defaultGrade;
	@XmlElement(name = "hidden")	
	public Boolean isHidden;
	public String imageUrl;
	public String imageBase64;
	public List<QuestionError> errors;

	public QuestionType getType() {
		return type;
	}

	public String getName() {
		name = name.replace("&lt;", "<");
		name = name.replace("&gt;", ">");
		return name;
	}

	public QuestionText getQuestionText() {
		return questionText;
	}

	public String getGeneralFeedBack() {
		return generalFeedBack;
	}

	public Float getPenalty() {
		return penalty;
	}

	public Float getDefaultGrade() {
		return defaultGrade;
	}

	public Boolean isHidden() {
		return isHidden;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public List<QuestionError> getErrors() {
		return errors;
	}

}
