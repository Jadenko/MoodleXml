package m2glre.marsupilami.moodlexmlapi.impl;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
		String inputFileName = "quiz-exemple.xml";
		
		QuestionError questionError = new QuestionError("type not supported",
				"the question type is not supported");
		//System.out.println(questionError.getDescription());

		//j ai rajouté ça fabien (Jad)

		Quiz quiz = ObjectQuizExample.createQuiz();
		QuizImportExportServiceImpl quizImportExportServiceImpl = new QuizImportExportServiceImpl();
		OutputStream outputStream = quizImportExportServiceImpl.exportQuiz(quiz);
		

		//InputStream inputStream = new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
		
		try {
			//if(Main.class.getResource("MoodleXmlApiImpl/src/main/resources/quiz-exemple.xml")!=null) {
			InputStream is = new FileInputStream(Main.class.getResource("/"+inputFileName).getPath());
			@SuppressWarnings("unused")
			IImportedQuiz importedQuiz = quizImportExportServiceImpl.importQuiz(is);
//			} else {
//				System.out.println("file not found");
//			}
		} catch (InvalidQuizFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidStreamSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

