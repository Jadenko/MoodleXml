package m2glre.marsupilami.moodlexmlapi.impl;

<<<<<<< HEAD:MoodleXmlApiImpl/src/main/java/m2glre/marsupilami/moodlexmlapi/impl/App.java

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;
=======
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionError;


>>>>>>> 6317845429de77e0ad67b847fd9b1d405c90928d:MoodleXmlApiImpl/src/main/java/m2glre/marsupilami/moodlexmlapi/impl/Main.java

/**
 * Hello world!
 * 
 */
<<<<<<< HEAD:MoodleXmlApiImpl/src/main/java/m2glre/marsupilami/moodlexmlapi/impl/App.java
public class App {

	private static final String QUIZ_XML = "./quiz-jaxb.xml";

	public static void main(final String[] args) throws JAXBException, IOException {
		QuestionError questionError = new QuestionError("type not supported",
				"the question type is not supported");
		//System.out.println(questionError.getDescription());
		


		// create bookstore, assigning book
		Quiz quiz = ObjectQuizExample.createQuiz();
		


		// create JAXB context and instantiate marshaller
		JAXBContext context = JAXBContext.newInstance(Quiz.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
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
=======
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        QuestionError questionError = new QuestionError("type not supported", "the question type is not supported");
        System.out.println(questionError.getDescription());
    	
    	
    }
>>>>>>> 6317845429de77e0ad67b847fd9b1d405c90928d:MoodleXmlApiImpl/src/main/java/m2glre/marsupilami/moodlexmlapi/impl/Main.java
}
