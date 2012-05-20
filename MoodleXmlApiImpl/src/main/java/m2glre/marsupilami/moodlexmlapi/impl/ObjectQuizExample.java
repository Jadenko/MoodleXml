package m2glre.marsupilami.moodlexmlapi.impl;

import java.util.ArrayList;
import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionTextFormat;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionType;
import m2glre.marsupilami.moodlexmlapi.core.data.TrueFalseQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Answer;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.AnswerNumbering;
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

		GenericQuestion question3 = new GenericQuestion();
		//question3.setQuestionType(QuestionType.multiple...); J'aurai plus beosin de faire ça, je l'ai deja fais dans le constructeur
//		questionList.add(question3);

		GenericQuestion question4 = new GenericQuestion();
		question4.setQuestionType(QuestionType.calculated);
//		questionList.add(question4);

		GenericQuestion question5 = new GenericQuestion();
		question5.setQuestionType(QuestionType.calculated);
//		questionList.add(question5);

		GenericQuestion question6 = new GenericQuestion();
		question6.setQuestionType(QuestionType.calculated);
//		questionList.add(question6);

		MultipleChoiceQuestion question7 = new MultipleChoiceQuestion();
		question7.setName("Architecture à 3 niveaux ?");
		QuestionText questionText7 = new QuestionText("Que désigne une architecture à 3 niveaux ?",QuestionTextFormat.html);
		question7.setQuestionText(questionText7);
		question7.setImageUrl("backupdata/446px-Uncle_Sam_pointing_finger_.jpg");
		question7.setImageBase64("/9j/4AAQSkZJRgABAQEAqwCrAAD/2wBDAAYEBQYFBAY");
		question7.setGeneralFeedBack("");
		question7.setDefaultGrade(1f);
		question7.setPenalty(0.1f);
		question7.setIsHidden(false);
		question7.setShuffleanswers(true);
		question7.setSingle(true);
		question7.setCorrectfeedback("");
		question7.setPartiallycorrectfeedback("");
		question7.setIncorrectfeedback("");
		question7.setAnswernumbering(AnswerNumbering.none);
		List<Answer> listAnswers = new ArrayList<Answer>();  
		Answer answer1 = new Answer(-100,"Une architecture MVC","Une application non distribuée peut implémentée MVC.");
		Answer answer2 = new Answer(100,"Une architecture N tiers ou N vaut 3","Nada.");
		listAnswers.add(answer1);
		listAnswers.add(answer2);
		question7.setAnswer(listAnswers);
		questionList.add(question7);

		MultipleChoiceQuestion question8 = new MultipleChoiceQuestion();
		question8.setName("Architectures N tiers");
		question8.setQuestionText(new QuestionText("Cocher les assertions vraies.",QuestionTextFormat.moodle_auto_format));
		question8.setImageBase64(" /9j/4AAQSkZJRgABAQEAqwCrAAD/2wBDAAYEBQYFBAYGBQYHBwYIChAKCgkJChQOD");
		question8.setGeneralFeedBack("Rappel N tiers : architectures multi-niveaux pouvant être distribuées sur plusieurs noeuds physique d'un réseau.");
		question8.setDefaultGrade(1f);
		question8.setPenalty(0.1f);
		question8.setIsHidden(false);
		question8.setShuffleanswers(true);
		question8.setCorrectfeedback("OK");
		question8.setPartiallycorrectfeedback("");
		question8.setIncorrectfeedback("KO");
		question8.setAnswernumbering(AnswerNumbering.abc);
		List<Answer> listAnswers8 = new ArrayList<Answer>();  
		Answer answer81 = new Answer(0,"Une architecture N-tiers est uniquement une architecture à base de Web Services","Une architecture distribuée peut reposer par exemple sur RMI");
		Answer answer82 = new Answer(33.333f,"Une architecture client serveur est une architecture N-tiers","Nada.");
		Answer answer83 = new Answer(33.333f,"Une architecture N-tiers correspond à une architecture d'application distribuée sur plusieurs noeuds physiques","Nada.");
		Answer answer84 = new Answer(33.333f,"Une application web est une application reposant sur une architecture N Tiers","Nada.");
		listAnswers8.add(answer81);
		listAnswers8.add(answer82);
		listAnswers8.add(answer83);
		listAnswers8.add(answer84);
		question8.setAnswer(listAnswers8);
		questionList.add(question8);

		GenericQuestion question9 = new GenericQuestion();
		question9.setQuestionType(QuestionType.calculated);
//		questionList.add(question9);

		GenericQuestion question10 = new GenericQuestion();
		question10.setQuestionType(QuestionType.calculated);
//		questionList.add(question10);

		GenericQuestion question11 = new GenericQuestion();
		question11.setQuestionType(QuestionType.calculated);
//		questionList.add(question11);

		TrueFalseQuestion question12 = new TrueFalseQuestion();
		List<Answer> listAnswers12 = new ArrayList<Answer>();  
		Answer answer121 = new Answer(0,"true","Tomcat est un conteneur Web uniquement.");
		Answer answer122 = new Answer(100,"false","Tomcat n'est pas un conteneur Web uniquement.");
		listAnswers12.add(answer121);
		listAnswers12.add(answer122);
		question12.setAnswer(listAnswers12);
		questionList.add(question12);
		

		// create bookstore, assigning book
		quiz.setQuestionList(questionList);

		return quiz;

	}

}
