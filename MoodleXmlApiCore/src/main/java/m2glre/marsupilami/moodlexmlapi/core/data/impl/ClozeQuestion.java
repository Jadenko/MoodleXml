package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;

public class ClozeQuestion extends GenericQuestion{
	
	boolean shuffleanswers;
	
	public ClozeQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}
}
