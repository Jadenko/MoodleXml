package m2glre.marsupilami.moodlexmlapi.impl;

import java.util.ArrayList;

import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionTextFormat;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MultipleChoiceQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;

public class ObjectQuizExample {

	

	// create quiz
	public static Quiz createQuiz() {
		Quiz quiz = new Quiz();
		ArrayList<QuestionImpl> questionList = new ArrayList<QuestionImpl>();

		CategoryQuestion question1 = new CategoryQuestion();
		question1.setCourse("IVVQ");
		question1.setCategory(question1.getCourse() + "/Défaut pour 1SA3GL1");
		questionList.add(question1);

		GenericQuestion question2 = new GenericQuestion();
		question2.setQuestionType(QuestionType.calculated);
		question2.setName("Aire du cercle (pas du carré)");
		QuestionText questionText2 = new QuestionText(
				"Calcul de l'aire du cercle ayant pour rayon {R}",
				QuestionTextFormat.moodle_auto_format);
		question2.setQuestionText(questionText2);
		question2.setDefaultGrade(1f);
		question2.setPenalty(0.1f);
		question2.setIsHidden(true);
		// question2.setShuffleanswers
		// question2.answer
		questionList.add(question2);

		MultipleChoiceQuestion question3 = new MultipleChoiceQuestion();
		//question3.setQuestionType(QuestionType.multiple...); J'aurai plus beosin de faire ça, je l'ai deja fais dans le constructeur
		question3.setName("Demo question à choix multiples");
		question3.setPenalty(0.1f);
		question3.setSingle(true);
		questionList.add(question3);

		GenericQuestion question4 = new GenericQuestion();
		question4.setQuestionType(QuestionType.calculated);
		questionList.add(question4);

		GenericQuestion question5 = new GenericQuestion();
		question5.setQuestionType(QuestionType.calculated);
		questionList.add(question5);

		GenericQuestion question6 = new GenericQuestion();
		question6.setQuestionType(QuestionType.calculated);
		questionList.add(question6);

		GenericQuestion question7 = new GenericQuestion();
		question7.setQuestionType(QuestionType.calculated);
		questionList.add(question7);

		GenericQuestion question8 = new GenericQuestion();
		question8.setQuestionType(QuestionType.calculated);
		questionList.add(question8);

		GenericQuestion question9 = new GenericQuestion();
		question9.setQuestionType(QuestionType.calculated);
		questionList.add(question9);

		GenericQuestion question10 = new GenericQuestion();
		question10.setQuestionType(QuestionType.calculated);
		questionList.add(question10);

		GenericQuestion question11 = new GenericQuestion();
		question11.setQuestionType(QuestionType.calculated);
		questionList.add(question11);

		GenericQuestion question12 = new GenericQuestion();
		question12.setQuestionType(QuestionType.calculated);
		questionList.add(question12);

		// create bookstore, assigning book
		quiz.setQuestionList(questionList);

		return quiz;

	}

}
