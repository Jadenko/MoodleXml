package m2glre.marsupilami.moodlexmlapi.core;

import java.io.InputStream;
import java.io.OutputStream;

import m2glre.marsupilami.moodlexmlapi.core.data.IImportedQuiz;
import m2glre.marsupilami.moodlexmlapi.core.data.IQuiz;


/**
* Import export quiz service
* @author fsil
*
*/
public interface QuizImportExportService {

/**
 * Import a quiz from a source formated in Moodle XML format
 * @param is the input stream containing the quiz in Moodle XML format
 * @return the imported quiz
 */
	public IImportedQuiz importQuiz(InputStream is) throws InvalidQuizFormatException, InvalidStreamSizeException;

	/**
	 * Export a quiz in the Moodle XML format
	 * @param quiz the quiz to export
	 * @return the output stream containing the quiz in Moodle XML format
	 */
	public OutputStream exportQuiz(IQuiz quiz);

}
