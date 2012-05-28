package test.m2glre.marsupilami.moodlexmlapi.core.init;

import java.util.ArrayList;
import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionTextFormat;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Answer;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.AnswerNumbering;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.AnswerNumerical;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.EssayQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MatchingQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MultipleChoiceQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.NumericalQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.ShortAnswerQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Subquestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.TrueFalseQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Unit;

public class InitObjetFactory {

	static GenericQuestion genericQuestionForTest = new GenericQuestion();
	static CategoryQuestion categoryQuestionForTest = new CategoryQuestion();
	static TrueFalseQuestion trueFalseQuestion = new TrueFalseQuestion();
	static MultipleChoiceQuestion multipleChoiceQuestion = new MultipleChoiceQuestion();
	static MatchingQuestion matchingQuestion = new MatchingQuestion();
	static ShortAnswerQuestion shortAnswerQuestion = new ShortAnswerQuestion();
	static NumericalQuestion numericalQuestion = new NumericalQuestion();
	static EssayQuestion essayQuestion = new EssayQuestion();
	static InvalidQuizFormatException invalidQuizFormatException;

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
		QuestionText questionText = new QuestionText();
		questionText.setText("Le Texte de la Question");
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

	public static ShortAnswerQuestion initShortAnswerQuestion() {

		shortAnswerQuestion.setAnswer(initListAnswer());
		shortAnswerQuestion.setUsecase(true);
		return shortAnswerQuestion;
	}

	public static NumericalQuestion initNumericalQuestion() {
		numericalQuestion.setAnswer(InitObjetFactory.initListAnswerNumerical());
		numericalQuestion.setUnit(InitObjetFactory.initListUnit());
		return numericalQuestion;
	}

	private static List<Unit> initListUnit() {
		List<Unit> listUnit = new ArrayList<Unit>();
		Unit unit1 = new Unit(1,"Unit 1");
		Unit unit2 = new Unit();
		unit2.setMultiplier(2);
		unit2.setUnit_name("Unit 2");
		listUnit.add(unit1);
		listUnit.add(unit2);
		
		return listUnit;
	}

	private static List<AnswerNumerical> initListAnswerNumerical() {
		List<AnswerNumerical> listNumericalAnswer = new ArrayList<AnswerNumerical>();
		AnswerNumerical answer1 = new AnswerNumerical(100,"2012",0,"Great");
		AnswerNumerical answer2 = new AnswerNumerical();
		answer2.setTolerance(33);
		answer2.setFeedback("Bad");
		answer2.setTolerance(10);
		answer2.setText("Very Bad");
		listNumericalAnswer.add(answer1);
		listNumericalAnswer.add(answer2);

		return listNumericalAnswer;
	}

	public static EssayQuestion initEssayQuestion() {
		essayQuestion.setShuffleanswers(true);
		essayQuestion.setAnswer(new Answer("Answer"));
		return essayQuestion;
	}

	public static CategoryQuestion initCategoryQuestion() {
		categoryQuestionForTest.setCourse("IVVQ");
		categoryQuestionForTest.setCategory("LaCategorie");
		return categoryQuestionForTest;
	}

	public static InvalidQuizFormatException initInvalidQuizFormatException() {
		Throwable throwable = new Throwable("Les Invalides");
		invalidQuizFormatException = new InvalidQuizFormatException(throwable);
		return invalidQuizFormatException;
	}

}
