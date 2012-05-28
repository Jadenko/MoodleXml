package m2glre.marsupilami.moodlexmlapi.core.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Classe représentant une question
 * @author Marsupilami's Band
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
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
 * the text format
 */
	public QuestionText(String _text, QuestionTextFormat _format) {
		this.text = _text;
		this.format = _format;
	}

	/**
	 * Utilisée spécialement pour les questions de type Cloze.
	 * Contruction d'une question text en prenant en compte les textes qui exèdent les 60 caracteres.
	 * Dans le fichier XML généré, y'a un saut à la ligne et une tabulation chaque 60 caractères.
	 * Ce qui permet une meilleur visibilité du text sur le fichier XML.
	 * @param text Le Long Text à insérer ou un court text.
	 */
	public QuestionText(String _text) {
		int beginIndex = 0;
		int endIndex = 60;

		if (_text.length() > 60) {
			String textResult = "";
			while (endIndex < _text.length()) {
				textResult = textResult.concat(_text.substring(beginIndex, endIndex));
				textResult = textResult.concat("\n\t\t");
				beginIndex += 60;
				endIndex += 60;
			}
				textResult = textResult.concat(_text.substring(beginIndex, _text.length()));
			
			_text = textResult;
		}

		this.text = _text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text Le texte à insérer
	 */
	public void setText(String _text) {
		this.text = _text;
	}

	/**
	 * @return the format
	 */
	public QuestionTextFormat getQuestionTextFormat() {
		return format;
	}

}
