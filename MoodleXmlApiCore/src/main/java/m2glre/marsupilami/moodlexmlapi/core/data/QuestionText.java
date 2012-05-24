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
	}

	/**
	 * Construct a question text
	 * 
	 * @param text
	 *            the text
	 * @param format
	 *            the text format
	 */
	public QuestionText(String text, QuestionTextFormat format) {
		this.text = text;
		this.format = format;
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

		this.text = text;
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
