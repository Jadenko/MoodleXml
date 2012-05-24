package m2glre.marsupilami.moodlexmlapi.impl;


import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBException;

import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;
import m2glre.marsupilami.moodlexmlapi.presenter.QuizImportExportServiceImpl;



/**
 * Hello world!
 * 
 */
public class Main {

//	private static final String QUIZ_XML = "./quiz-jaxb.xml";

	public static void main(final String[] args) throws JAXBException, IOException {
		QuestionError questionError = new QuestionError("type not supported",
				"the question type is not supported");
		//System.out.println(questionError.getDescription());

		
		
		
		Quiz quiz = ObjectQuizExample.createQuiz();

		QuizImportExportServiceImpl quizImportExportServiceImpl = new QuizImportExportServiceImpl();
		OutputStream outputStream = quizImportExportServiceImpl.exportQuiz(quiz);

	}
}

