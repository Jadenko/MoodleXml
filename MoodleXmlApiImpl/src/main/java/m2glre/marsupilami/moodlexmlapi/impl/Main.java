package m2glre.marsupilami.moodlexmlapi.impl;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBException;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;
import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.ImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;
import m2glre.marsupilami.moodlexmlapi.presenter.QuizImportExportServiceImpl;



/**
 * Hello world!
 * 
 */
public class Main {

//	private static final String QUIZ_XML = "./quiz-jaxb.xml";

	public static void main(final String[] args) throws JAXBException, IOException {
		
		String fileName = "./quiz-jaxb.xml";
		
		QuestionError questionError = new QuestionError("type not supported",
				"the question type is not supported");
		//System.out.println(questionError.getDescription());

		Quiz quiz = ObjectQuizExample.createQuiz();
		QuizImportExportServiceImpl quizImportExportServiceImpl = new QuizImportExportServiceImpl();
		OutputStream outputStream = quizImportExportServiceImpl.exportQuiz(quiz);
		
		InputStream is = new FileInputStream("quiz-exemple.xml");
		try {
			IImportedQuiz importedQuiz = quizImportExportServiceImpl.importQuiz(is);
		} catch (InvalidQuizFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStreamSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
}

