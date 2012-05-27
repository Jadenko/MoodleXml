package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShortAnswerQuestion extends GenericQuestion {

	private List<Answer> lanswer;
	private boolean busecase;

	public ShortAnswerQuestion() {
		super();
		this.setType(QuestionType.shortanswer);
	}

	public List<Answer> getAnswer() {
		return lanswer;
	}

	public void setAnswer(List<Answer> answer) {
		this.lanswer = answer;
	}

	public boolean isUsecase() {
		return busecase;
	}

	public void setUsecase(boolean usecase) {
		this.busecase = usecase;
	}

}
