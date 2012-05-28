package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import java.util.List;

public class CalculatedQuestion extends NumericalQuestion {

	private String image;
	private List<AnswerCalculated> answerCalculatedList;
	private List<CalculatedQuestionDataSetDefinition> calculatedQuestionDataSetDefinitionList;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<AnswerCalculated> getAnswerCalculatedList() {
		return answerCalculatedList;
	}
	public void setAnswerCalculatedList(List<AnswerCalculated> answerCalculatedList) {
		this.answerCalculatedList = answerCalculatedList;
	}
	public List<CalculatedQuestionDataSetDefinition> getCalculatedQuestionDataSetDefinitionList() {
		return calculatedQuestionDataSetDefinitionList;
	}
	public void setCalculatedQuestionDataSetDefinitionList(
			List<CalculatedQuestionDataSetDefinition> calculatedQuestionDataSetDefinitionList) {
		this.calculatedQuestionDataSetDefinitionList = calculatedQuestionDataSetDefinitionList;
	}

}
