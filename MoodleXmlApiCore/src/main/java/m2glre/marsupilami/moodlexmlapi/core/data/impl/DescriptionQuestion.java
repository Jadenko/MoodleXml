package m2glre.marsupilami.moodlexmlapi.core.data.impl;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;

public class DescriptionQuestion extends GenericQuestion {
	
	private String image;
	private boolean shuffleanswers;
	
	public DescriptionQuestion() {
		super();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isShuffleanswers() {
		return shuffleanswers;
	}

	public void setShuffleanswers(boolean shuffleanswers) {
		this.shuffleanswers = shuffleanswers;
	}
	
	

}
