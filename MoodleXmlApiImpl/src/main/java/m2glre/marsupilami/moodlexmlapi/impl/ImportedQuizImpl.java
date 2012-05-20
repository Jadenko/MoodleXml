package m2glre.marsupilami.moodlexmlapi.impl;

import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.data.ImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.Question;

public class ImportedQuizImpl implements ImportedQuiz {
	
	List<Question> questionList;
	
	public ImportedQuizImpl() {
		
	}

	public List<Question> getQuestionList() {
		return this.questionList;
	}

	public int getProcessedQuestionCount() {
		return this.questionList.size();
	}

	public int getExtractedQuestionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNonExtractedQuestionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Question> getProcessedQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getExtractedQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> getNonExtractedQuestionList() {
		// TODO Auto-generated method stub
		return null;
	}

}
//package m2glre.marsupilami.moodlexmlapi.impl;
//
//import java.util.List;
//
//import m2glre.marsupilami.moodlexmlapi.core.data.ImportedQuiz;
//import m2glre.marsupilami.moodlexmlapi.core.data.Question;
//
//public class ImportedQuizImpl implements ImportedQuiz {
//
//	public List<Question> getQuestionList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public int getProcessedQuestionCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int getExtractedQuestionCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int getNonExtractedQuestionCount() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public List<Question> getProcessedQuestionList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Question> getExtractedQuestionList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Question> getNonExtractedQuestionList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
