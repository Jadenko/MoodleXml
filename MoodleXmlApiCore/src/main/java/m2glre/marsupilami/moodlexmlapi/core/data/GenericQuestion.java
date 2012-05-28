/**
*
*/
package m2glre.marsupilami.moodlexmlapi.core.data;

import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;


import m2glre.marsupilami.moodlexmlapi.core.data.impl.EssayQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MatchingQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MultipleChoiceQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.NumericalQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.ShortAnswerQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.TrueFalseQuestion;

/**
 * Classe commune ayant les propriétés de bases qui correspondent au balises du format Moodle XML
 * @author Marsupilami's Band
 */
@XmlSeeAlso({MultipleChoiceQuestion.class,
	         TrueFalseQuestion.class,
	         ShortAnswerQuestion.class,
	         NumericalQuestion.class,
	         MatchingQuestion.class,
	         EssayQuestion.class})
public class GenericQuestion extends QuestionImpl {


	/**
	 * @param questionType the questionType to set
	 */
	public void setType(QuestionType _type) {
		this.type = _type;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String _name) {
		String nameR = "";
		if(name != null){
			nameR = nameR.concat("<text>").concat(name).concat("</text>");	
		}
		this.name = _name;
	}

	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(QuestionText _questionText) {
		this.questionText = _questionText;
	}

	/**
	 * @param generalFeedBack the generalFeedBack to set
	 */
	public void setGeneralFeedBack(String _generalFeedBack) {
		this.generalFeedBack = _generalFeedBack;
	}

	/**
	 * @param penalty the penalty to set
	 */
	public void setPenalty(Float _penalty) {
		this.penalty = _penalty;
	}

	/**
	 * @param defaultGrade the defaultGrade to set
	 */
	public void setDefaultGrade(Float _defaultGrade) {
		this.defaultGrade = _defaultGrade;
	}

	/**
	 * @param isHidden the isHidden to set
	 */
	public void setIsHidden(Boolean _isHidden) {
		this.isHidden = _isHidden;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String _imageUrl) {
		this.imageUrl = _imageUrl;
	}

	/**
	 * @param imageBase64 the imageBase64 to set
	 */
	public void setImageBase64(String _imageBase64) {
		this.imageBase64 = _imageBase64;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<QuestionError> _errors) {
		this.errors = _errors;
	}



}
