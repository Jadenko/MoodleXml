package m2glre.marsupilami.moodlexmlapi.core.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
* @author Jad
*
*/
 
@XmlAccessorType(XmlAccessType.FIELD)
public class QuestionText {

	@XmlElement(name = "text")
	private String stext;
	@XmlAttribute
	private QuestionTextFormat oformat;

	public QuestionText() {
	}

/**
 * Construct a question text
 *
 * @param text
 *            the text
 * @param format
 * the text format
 */
	public QuestionText(String text, QuestionTextFormat format) {
		this.stext = text;
		this.oformat = format;
	}

	public QuestionText(String text) {
		int beginIndex = 0;
		int endIndex = 60;

		if (text.length() > 60) {
			String textResult = "";
			while (endIndex < text.length()) {
				textResult = textResult.concat(text.substring(beginIndex, endIndex));
				textResult = textResult.concat("\n\t\t");
				beginIndex += 60;
				endIndex += 60;
			}
				textResult = textResult.concat(text.substring(beginIndex, text.length()));
			
			text = textResult;
		}

		this.stext = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return stext;
	}

	public void setText(String text) {
		this.stext = stext;
	}

	/**
	 * @return the format
	 */
	public QuestionTextFormat getQuestionTextFormat() {
		return oformat;
	}

}
