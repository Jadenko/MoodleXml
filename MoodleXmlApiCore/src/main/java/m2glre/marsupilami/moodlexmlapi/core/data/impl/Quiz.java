package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Quiz implements IQuiz {
   //XmlAccessType.FIELD pour ne pas avoir une confusion entre le get et la propriété elle meme


	@XmlElement(name = "question")
	public List<QuestionImpl> lquestionList;

	public void setQuestionList(List<QuestionImpl> questionList) {
		this.lquestionList = questionList;
	}

	public List<QuestionImpl> getQuestionList() {
		return lquestionList;
	}

}
