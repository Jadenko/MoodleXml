package m2glre.marsupilami.moodlexmlapi.impl;

import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.ImportedQuiz;

public class ImportedQuizImpl extends ImportedQuiz {
	
	List<IQuestion> questionList;
	List<IQuestion> processedQuestionList;
	List<IQuestion> extractedQuestionList;
	List<IQuestion> nonExtractedQuestionList;
	
	public ImportedQuizImpl() {
		
	}

	public int getProcessedQuestionCount() {
		return this.processedQuestionList.size();
	}

	public int getExtractedQuestionCount() {
		return this.extractedQuestionList.size();
	}

	public int getNonExtractedQuestionCount() {
		return this.nonExtractedQuestionList.size();
	}

	public List<IQuestion> getProcessedQuestionList() {
		return this.processedQuestionList;
	}

	public List<IQuestion> getExtractedQuestionList() {
		return this.extractedQuestionList;
	}

	public List<IQuestion> getNonExtractedQuestionList() {
		return this.nonExtractedQuestionList;
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
