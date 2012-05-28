package m2glre.marsupilami.moodlexmlapi.core.data.impl;

public class AnswerCalculated extends AnswerNumerical {
	
	private int tolerancetype;
	private int correctanswerformat;
	private int correctanswerlength;
	
	public AnswerCalculated() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTolerancetype() {
		return tolerancetype;
	}
	public void setTolerancetype(int tolerancetype) {
		this.tolerancetype = tolerancetype;
	}
	public int getCorrectanswerformat() {
		return correctanswerformat;
	}
	public void setCorrectanswerformat(int correctanswerformat) {
		this.correctanswerformat = correctanswerformat;
	}
	public int getCorrectanswerlength() {
		return correctanswerlength;
	}
	public void setCorrectanswerlength(int correctanswerlength) {
		this.correctanswerlength = correctanswerlength;
	}
}
