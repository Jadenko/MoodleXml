package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "jad.model")
public class Quiz implements IQuiz {
   //XmlAccessType.FIELD pour ne pas avoir une confusion entre le get et la propriété elle meme
	
	
	@XmlElement(name = "question")
	public List<QuestionImpl> questionList;
	
	public void setQuestionList(List<QuestionImpl> questionList) {
		this.questionList = questionList;
	}

	public List<QuestionImpl> getQuestionList() {
		return questionList;
	}

}
