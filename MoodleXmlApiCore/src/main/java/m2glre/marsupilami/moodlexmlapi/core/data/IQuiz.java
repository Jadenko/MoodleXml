package m2glre.marsupilami.moodlexmlapi.core.data;

import java.util.List;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
/**
 * Interface representing a Moodle quiz
 * @author Marsupilami's Group
 *
 */
public interface IQuiz {

	/**
	 * @return the question list
	 */
	public List<QuestionImpl> getQuestionList();

}
