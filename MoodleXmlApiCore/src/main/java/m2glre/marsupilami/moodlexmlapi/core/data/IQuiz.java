package m2glre.marsupilami.moodlexmlapi.core.data;

import java.util.List;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;
/**
 * Interface representing a Moodle quiz
<<<<<<< HEAD:MoodleXmlApiCore/src/main/java/m2glre/marsupilami/moodlexmlapi/core/data/IQuiz.java
 * @author Jad
=======
 * @author Marsupilami's Group 
>>>>>>> 4891ff7156ef5dd1214276b0f0fc1457d5889788:MoodleXmlApiCore/src/main/java/m2glre/marsupilami/moodlexmlapi/core/data/IQuiz.java
 *
 */
public interface IQuiz {

	/**
	 * @return the question list
	 */
	public List<QuestionImpl> getQuestionList();

}
