package m2glre.marsupilami.moodlexmlapi.presenter;

import java.io.InputStream;
import java.io.OutputStream;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;
import m2glre.marsupilami.moodlexmlapi.core.QuizImportExportService;
import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.ImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.Quiz;

public class QuizImportExportServiceImpl implements QuizImportExportService{

	public IImportedQuiz importQuiz(InputStream is)
			throws InvalidQuizFormatException, InvalidStreamSizeException {
		// TODO Auto-generated method stub
		return null;
	}

	public OutputStream exportQuiz(IQuiz quiz) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
//package m2glre.marsupilami.moodlexmlapi.presenter;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;
//import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;
//import m2glre.marsupilami.moodlexmlapi.core.QuizImportExportService;
//import m2glre.marsupilami.moodlexmlapi.core.data.ImportedQuiz;
//import m2glre.marsupilami.moodlexmlapi.core.data.Quiz;
//
//public class QuizImportExportServiceImpl implements QuizImportExportService{
//
//	public ImportedQuiz importQuiz(InputStream is)
//			throws InvalidQuizFormatException, InvalidStreamSizeException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public OutputStream exportQuiz(Quiz quiz) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
