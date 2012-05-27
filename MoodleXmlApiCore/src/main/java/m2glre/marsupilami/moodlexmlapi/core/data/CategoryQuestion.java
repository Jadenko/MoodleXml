/**
 * 
 */
package m2glre.marsupilami.moodlexmlapi.core.data;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import m2glre.marsupilami.moodlexmlapi.core.data.impl.QuestionImpl;

/**
 * Class representing the dummy question of type category.
 * 
 * @author Marsupilami's Band
 * 
 */
@XmlAccessorType(XmlAccessType.NONE)
public class CategoryQuestion extends QuestionImpl {
	
	@XmlElement(name = "category")
	private String category;
	private String course;


	/**
	 * @return the course
	 */
	public String getCourse() {
		return course;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getName()
	 */
	public String getName() {
		return null;
	}
	
	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getQuestionText()
	 */
	public QuestionText getQuestionText() {
		return null;
	}


	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getGeneralFeedBack()
	 */
	public String getGeneralFeedBack() {
		return null;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getPenalty()
	 */
	public Float getPenalty() {
		return null;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getDefaultGrade()
	 */
	public Float getDefaultGrade() {
		return null;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#isHidden()
	 */
	public Boolean isHidden() {
		return null;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getImageUrl()
	 */
	public String getImageUrl() {
		return null;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getImageBase64()
	 */
	public String getImageBase64() {
		return null;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getErrors()
	 */
	public List<QuestionError> getErrors() {
		return null;
	}


	/**
	 * @param category  the category to set
	 */
	public void setCategory(String category) {
		String rslt = "";
		rslt = course+"/"+category;
		this.category = rslt;
	}

	/**
	 * @see m2glre.marsupilami.moodlexmlapi.core.data.IQuestion#getType()
	 */
	@XmlAttribute(name = "type")
	public QuestionType getType() {
		return QuestionType.category;
	}
	
	/**
	 * @param course the course to set
	 */
	public void setCourse(String course) {
		this.course = course;
	}
}
