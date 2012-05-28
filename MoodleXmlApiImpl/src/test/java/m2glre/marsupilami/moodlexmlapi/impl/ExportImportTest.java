package m2glre.marsupilami.moodlexmlapi.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;
import m2glre.marsupilami.moodlexmlapi.core.QuizImportExportService;
import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;
import m2glre.marsupilami.moodlexmlapi.presenter.QuizImportExportServiceImpl;

import org.junit.Before;
import org.junit.Test;

public class ExportImportTest {


	Quiz aQuiz;
	List<QuestionImpl> listQuestions;

	@Before
	public void setUp() throws Exception {
		aQuiz = new Quiz();
		listQuestions = new ArrayList<QuestionImpl>();
		listQuestions.add(InitObjetFactory.initGenericQuestion());
		listQuestions.add(InitObjetFactory.initMultipleChoiceQuestion());
		aQuiz.setQuestionList(listQuestions);

	}


	@Test
	public void testExportImport() {
		QuizImportExportService service = new QuizImportExportServiceImpl();
		OutputStream export = service.exportQuiz(aQuiz);
		IImportedQuiz importQuiz = null;

		assertNotNull(export);
		
		// InputStream input = new ByteArrayInputStream(
		// ((ByteArrayOutputStream) export).toByteArray());

		// créé un fichier en fonction du quiz généré dans le fichier
		// quiz-jaxb.xml
		File f = new File("./quiz-jaxb.xml");

		try {
			// Utilisation du fichier pour créer un InputStream attendu dans
			// importQuiz
			InputStream input = new FileInputStream(f);
			importQuiz = service.importQuiz(input);
		} catch (InvalidQuizFormatException e) {
			e.printStackTrace();
		} catch (InvalidStreamSizeException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int count = importQuiz.getQuestionList().size();
		int processedQuestionsCount = importQuiz.getExtractedQuestionCount() + importQuiz.getNonExtractedQuestionCount();
		assertNotNull(importQuiz);
		assertEquals(count, 2);
		assertEquals(importQuiz.getExtractedQuestionCount(), 2);
		assertEquals(importQuiz.getNonExtractedQuestionCount(), count - importQuiz.getExtractedQuestionCount());
		assertEquals(importQuiz.getProcessedQuestionCount(), processedQuestionsCount);
		assertEquals(importQuiz.getNonExtractedQuestionList().size(), 0);
		assertEquals(importQuiz.getQuestionList().get(0).getName(), aQuiz.getQuestionList().get(0).getName());
		assertEquals(importQuiz.getQuestionList().get(0).getType(), aQuiz.getQuestionList().get(0).getType());
		assertEquals(importQuiz.getQuestionList().get(1).getType(), aQuiz.getQuestionList().get(1).getType());
		assertEquals(importQuiz.getQuestionList().get(0).getQuestionText().getQuestionTextFormat(), aQuiz.getQuestionList().get(0).getQuestionText().getQuestionTextFormat());
		assertEquals(importQuiz.getQuestionList().get(0).getQuestionText().getText().trim(), aQuiz.getQuestionList().get(0).getQuestionText().getText().trim());
		assertEquals(importQuiz.getQuestionList().get(0).getGeneralFeedBack(), aQuiz.getQuestionList().get(0).getGeneralFeedBack());
		
	}
	

}
