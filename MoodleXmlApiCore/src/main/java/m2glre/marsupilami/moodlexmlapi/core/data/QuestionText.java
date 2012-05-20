package m2glre.marsupilami.moodlexmlapi.core.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Jad
 *
 */
public class QuestionText {
	
	@XmlElement(name = "text")
	private String text;
	@XmlAttribute
	private QuestionTextFormat format;
	
	
	public QuestionText() {
		super();
	}
	
	
	/**
	 * Construct a question text
	 * @param text the text
	 * @param format the text format
	 */
	public QuestionText(String text, QuestionTextFormat format) {
		this.text = text;
		this.format = format;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @return the format
	 */
	public QuestionTextFormat getQuestionTextFormat() {
		return format;
	}
	

}
