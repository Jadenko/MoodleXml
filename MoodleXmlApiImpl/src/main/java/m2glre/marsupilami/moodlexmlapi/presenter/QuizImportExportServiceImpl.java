package m2glre.marsupilami.moodlexmlapi.presenter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;
import m2glre.marsupilami.moodlexmlapi.core.QuizImportExportService;
import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;
import m2glre.marsupilami.moodlexmlapi.impl.ObjectQuizExample;

public class QuizImportExportServiceImpl implements QuizImportExportService {

	public QuizImportExportServiceImpl() {
		super();
	}

	public IImportedQuiz importQuiz(InputStream is)
			throws InvalidQuizFormatException, InvalidStreamSizeException {
		// TODO Auto-generated method stub
		return null;
	}

	public OutputStream exportQuiz(IQuiz quiz) {
		final String QUIZ_XML = "./quiz-jaxb.xml";


		// create JAXB context and instantiate marshaller
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Quiz.class, GenericQuestion.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// m.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION,"");
			m.marshal(quiz, System.out);
			Writer w = null;
				try {
					w = new FileWriter(QUIZ_XML);
					m.marshal(quiz, w);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						w.close();
					} catch (Exception e) {
					}
				}

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	
		return null;
	}

}