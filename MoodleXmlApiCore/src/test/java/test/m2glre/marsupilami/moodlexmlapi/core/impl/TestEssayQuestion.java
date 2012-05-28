package test.m2glre.marsupilami.moodlexmlapi.core.impl;

import static org.junit.Assert.*;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Answer;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.EssayQuestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestEssayQuestion {

	public EssayQuestion essayQuestion= null;
	public EssayQuestion essayQuestion2 = null;
	
	@Before
	public void setUp() throws Exception {
		essayQuestion = InitObjetFactory.initEssayQuestion();
		essayQuestion2 = new EssayQuestion(true, new Answer(1f,"Answer","Feedback"));
	}

	@Test
	public void testIsShuffleanswers() {
		assertTrue(essayQuestion.isShuffleanswers());
	}

	@Test
	public void testGetAnswer() {
		assertEquals(essayQuestion.getAnswer().getText(),
					 essayQuestion2.getAnswer().getText());
	}

}
