package test.m2glre.marsupilami.moodlexmlapi.core.init;

import java.util.ArrayList;
import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionTextFormat;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Answer;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.AnswerNumbering;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MatchingQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MultipleChoiceQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Subquestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.TrueFalseQuestion;

public class InitObjetFactory {

	static GenericQuestion genericQuestionForTest = new GenericQuestion();
	static TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion();
	static MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
	static MatchingQuestion matchingQuestion = new MatchingQuestion();

	public static GenericQuestion initGenericQuestion() {
		genericQuestionForTest.setType(QuestionType.calculated);
		genericQuestionForTest.setName("LeNom");
		QuestionText questionText = new QuestionText("Le Texte de la Question",
				QuestionTextFormat.moodle_auto_format);
		genericQuestionForTest.setQuestionText(questionText);
		genericQuestionForTest.setDefaultGrade(1f);
		genericQuestionForTest.setPenalty(1f);
		genericQuestionForTest.setIsHidden(true);
		genericQuestionForTest.setGeneralFeedBack("Le General Feedback");
		genericQuestionForTest.setImageUrl("Image URL");
		genericQuestionForTest.setImageBase64("Image Base 64");
		genericQuestionForTest.setPenalty(1f);
		List<QuestionError> list = new ArrayList<QuestionError>();
		list.add(new QuestionError("Alpha", "Erreur Merdique"));
		list.add(new QuestionError());
		genericQuestionForTest.setErrors(list);

		return genericQuestionForTest;
	}

	public static List<Answer> initListAnswer() {
		List<Answer> listAnswers = new ArrayList<Answer>();
		Answer answer1 = new Answer(1, "Text pour Answer",
				"Feedback pour Answer");
		listAnswers.add(answer1);
		Answer answer2 = new Answer();
		answer2.setText("Text pour Answer");
		answer2.setFraction(2);
		answer2.setFeedback("Feedback pour Answer");
		listAnswers.add(answer2);
		Answer answer3 = new Answer(3, "Text pour Answer");
		listAnswers.add(answer3);
		Answer answer4 = new Answer("Un Long Texte");
		listAnswers.add(answer4);

		return listAnswers;

	}

	public static TrueFalseQuestion initTrueFalseQuestion() {

		trueFalseQuestion.setAnswer(initListAnswer());

		return trueFalseQuestion;
	}

	public static MultipleChoiceQuestion initMultipleChoiceQuestion() {
		multipleChoiceQuestion.setSingle(true);
		multipleChoiceQuestion.setShuffleanswers(true);
		multipleChoiceQuestion.setAnswer(initListAnswer());
		multipleChoiceQuestion.setAnswernumbering(AnswerNumbering.none);
		multipleChoiceQuestion.setCorrectfeedback("Correctfeedback");
		multipleChoiceQuestion
				.setPartiallycorrectfeedback("Partiallycorrectfeedback");
		multipleChoiceQuestion.setIncorrectfeedback("IncorrectFeedback");

		return multipleChoiceQuestion;
	}

	public static MatchingQuestion initMatchingQuestion() {

		matchingQuestion.setShuffleanswers(true);
		matchingQuestion.setSubquestion(initListSubquestion());
		return matchingQuestion;
	}

	public static List<Subquestion> initListSubquestion() {
		List<Subquestion> subquestions = new ArrayList<Subquestion>();
		Subquestion subquestion1 = new Subquestion("Text0",
				new Answer("Redhat"));
		Subquestion subquestion2 = new Subquestion();
		subquestion2.setText("Text1");
		subquestion2.setAnswer(new Answer("IBM"));
		subquestions.add(subquestion1);
		subquestions.add(subquestion2);

		return subquestions;
	}

}
