package m2glre.marsupilami.moodlexmlapi.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;



/**
 * Hello world!
 * 
 */
public class Main {

	private static final String QUIZ_XML = "./quiz-jaxb.xml";

	public static void main(final String[] args) throws JAXBException, IOException {
		QuestionError questionError = new QuestionError("type not supported",
				"the question type is not supported");
		//System.out.println(questionError.getDescription());
		
		File file = new File("c:/quiz.xml");


		// create bookstore, assigning book
		Quiz quiz = ObjectQuizExample.createQuiz();
		


		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(Quiz.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(quiz, file);
		//m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION,"");
		m.marshal(quiz, System.out);

		Writer w = null;
		try {
			w = new FileWriter(QUIZ_XML);
			m.marshal(quiz, w);
		} finally {
			try {
				w.close();
			} catch (Exception e) {
			}
		}

	}
}

