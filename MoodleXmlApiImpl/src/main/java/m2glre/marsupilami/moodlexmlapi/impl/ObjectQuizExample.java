package m2glre.marsupilami.moodlexmlapi.impl;

import java.util.ArrayList;
import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
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
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.ShortAnswerQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Subquestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.TrueFalseQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Unit;

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
		question2.setType(QuestionType.calculated);
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

		String CHAINE_VIDE = "";
		EssayQuestion question4 = new EssayQuestion(true,new Answer(0,CHAINE_VIDE, ""));
		question4.setName("Question ouverte");
		question4.setQuestionText(new QuestionText(
				"Ecrire un programme qui affiche Hello world",
				QuestionTextFormat.moodle_auto_format));
		questionList.add(question4);
		

		MatchingQuestion question5 = new MatchingQuestion();
		question5.setName("Serveur d'application / éditeurs");
		question5.setShuffleanswers(true);
		List<Subquestion> subquestions = new ArrayList<Subquestion>();
		Subquestion subquestion1 = new Subquestion("JBoss", new Answer("Redhat"));
		Subquestion subquestion2 = new Subquestion("Websphere", new Answer("IBM"));
		Subquestion subquestion3 = new Subquestion("GlassFish", new Answer("Oracle"));
		Subquestion subquestion4 = new Subquestion("Tomcat", new Answer("Fondation Apache"));
		subquestions.add(subquestion1);
		subquestions.add(subquestion2);
		subquestions.add(subquestion3);
		subquestions.add(subquestion4);
		question5.setSubquestion(subquestions);
		questionList.add(question5);

		GenericQuestion question6 = new GenericQuestion();
		question6.setType(QuestionType.cloze);
		question6.setName("Question \"Cloze\" (composite ?)");
		QuestionText questionText6 = new QuestionText("Cette question comporte du texte dans" +
				"lequel on a directement intégré des réponses à choix multiples " +
				"{1:MULTICHOICE:Mauvaise réponse#Feedback pour cette mauvaise réponse~Une " +
				"autre mauvaise réponse#Feedback pour cette autre mauvaise réponse~=Bonne" +
				"réponse#Feedback pour la bonne réponse~%50%Réponse qui vaut la" +
				" moitié des points#Feedback pour la question qui vaut la moitié des points} ;" +
				" vous devez maintenant répondre à une question courte{1:SHORTANSWER:" +
				"Mauvaise réponse#Feedback pour cette mauvaise réponse~=Bonne réponse#Feedback" +
				" pour la bonne réponse~%50%Réponse qui vaut la moitié des points#Feedback " +
				"pour la question qui vaut la moitié des points}. Nous avons finalement une" +
				" question qui demande une réponse numérique avec point décimal {2:NUMERICAL" +
				"=23.8:0.1#Feedback pour la bonne réponse 23.8~%50%23.8:2#Feedback pour la" +
				" réponse qui donne la moitié des points}. Remarquez que les adresses URL " +
				"comme www.moodle.org et les binettes :-) sont correctement interprétées :" +
				"a) Est-ce bien? {:MULTICHOICE:=Oui#Bonne réponse~Non#Votre opinion nous\n" +
				" indiffère !}  b) Quelle note désirez-vous? {3:NUMERICAL:=3:2}");
		question6.setQuestionText(questionText6);
		questionList.add(question6);

		MultipleChoiceQuestion question7 = new MultipleChoiceQuestion();
		question7.setName("Architecture à 3 niveaux ?");
		QuestionText questionText7 = new QuestionText("Que désigne une architecture à 3 niveaux ?",QuestionTextFormat.markdown);
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
		Answer answer82 = new Answer(33,"Une architecture client serveur est une architecture N-tiers","Nada.");
		Answer answer83 = new Answer(33,"Une architecture N-tiers correspond à une architecture d'application distribuée sur plusieurs noeuds physiques","Nada.");
		Answer answer84 = new Answer(33,"Une application web est une application reposant sur une architecture N Tiers","Nada.");
		listAnswers8.add(answer81);
		listAnswers8.add(answer82);
		listAnswers8.add(answer83);
		listAnswers8.add(answer84);
		question8.setAnswer(listAnswers8);
		questionList.add(question8);

		NumericalQuestion question9 = new NumericalQuestion();
		question9.setName("HTTP 1er protocole de l'Internet");
		question9.setQuestionText(new QuestionText("En quelle année HTTP devient le premier protocole de l'Internet ?", QuestionTextFormat.moodle_auto_format));
		List<AnswerNumerical> listAnswers9 = new ArrayList<AnswerNumerical>();  
		AnswerNumerical answer91 = new AnswerNumerical(100,"1996",0,"");
		listAnswers9.add(answer91);
		question9.setAnswer(listAnswers9);
		List<Unit> listUnit9 = new ArrayList<Unit>();  
		Unit unit91 = new Unit(1,"année");
		Unit unit92 = new Unit(2,"annéee");
		listUnit9.add(unit91);
		listUnit9.add(unit92);
		question9.setUnit(listUnit9);
		questionList.add(question9);

		ShortAnswerQuestion question10 = new ShortAnswerQuestion();
		question10.setName("MVC");
		question10.setUsecase(false);
		List<Answer> listAnswers10 = new ArrayList<Answer>();  
		Answer answer101 = new Answer(100,"Model View Controller","");
		Answer answer102 = new Answer(100,"Modèle vue contrôleur","");
		listAnswers10.add(answer101);
		listAnswers10.add(answer102);
		question10.setAnswer(listAnswers10);
		questionList.add(question10);

		GenericQuestion question11 = new GenericQuestion();
		question11.setType(QuestionType.calculated);
//		questionList.add(question11);

		TrueFalseQuestion question12 = new TrueFalseQuestion();
		question12.setName("Tomcat et JEE");
		question12.setQuestionText(new QuestionText("Tomcat est un conteneur implémentant toutes les spécifications JEE.", QuestionTextFormat.moodle_auto_format));
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
