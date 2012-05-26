package m2glre.marsupilami.moodlexmlapi.presenter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;
import m2glre.marsupilami.moodlexmlapi.core.QuizImportExportService;
import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;

public class QuizImportExportServiceImpl implements QuizImportExportService {

	public QuizImportExportServiceImpl() {
		super();
	}

	public IImportedQuiz importQuiz(InputStream is)
			throws InvalidQuizFormatException, InvalidStreamSizeException {
		// TODO Auto-generated method stub
		IImportedQuiz importedQuiz = null;
		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Quiz.class);
		
		Unmarshaller um = context.createUnmarshaller();
		Quiz quizImported = (Quiz) um.unmarshal(new FileReader("./quiz-jaxb.xml"));

			for (int i = 0; i < quizImported.getQuestionList().toArray().length; i++) {
				System.out.println("Question " + (i + 1) + ": "
						+ quizImported.getQuestionList().get(i).getName() + " from "
						+ quizImported.getQuestionList().get(i).getImageUrl());
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return importedQuiz;
	}

	public OutputStream exportQuiz(IQuiz quiz) {
		//TODO priorité 3 - externaliser le path
		final String PATH_FILE = "./quiz-jaxb.xml";

		JAXBContext context;
		OutputStream os = null;
		try {
			context = JAXBContext.newInstance(Quiz.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION,"");
			os = new FileOutputStream(PATH_FILE);
			m.marshal(quiz, os);
			//ligne suivante à enlever
			m.marshal(quiz, System.out);

		} catch (JAXBException e1) {
			//TODO Priorité: 3 - externaliser les msgs
			System.err.println("Marsupilami's Project: Erreur JAXB - Survenue lors de la sérialisation (Objet Java -> Moodle Xml)");
			e1.printStackTrace();
		} catch (FileNotFoundException e) {
			System.err.println("Marsupilami's Project:");
			e.printStackTrace();
		}

		return os;
	}

}