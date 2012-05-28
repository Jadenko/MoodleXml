package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;


/**
 * An implementation of a quiz 
 * @author Marsupilami's Band
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Quiz implements IQuiz {
	

	/**
	 * The list of question representing a quiz (One CategoryQuestion and many GenericQuestion)
	 */
	@XmlElement(name = "question")
	public List<QuestionImpl> questionList;

	/**
	 * 
	 * @param questionList the list of questions to set
	 */
	public void setQuestionList(List<QuestionImpl> _questionList) {
		this.questionList = _questionList;
	}

	/**
	 * @return the list of questions
	 */
	public List<QuestionImpl> getQuestionList() {
		return questionList;
	}

}
