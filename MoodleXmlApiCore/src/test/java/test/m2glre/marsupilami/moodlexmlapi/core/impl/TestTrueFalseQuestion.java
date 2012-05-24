package test.m2glre.marsupilami.moodlexmlapi.core.impl;

import static org.junit.Assert.*;

import m2glre.marsupilami.moodlexmlapi.core.data.impl.TrueFalseQuestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestTrueFalseQuestion {

	TrueFalseQuestion trueFalseQuestion = null;
	
	@Before
	public void setUp() throws Exception {
		trueFalseQuestion = InitObjetFactory.initTrueFalseQuestion();
	}


	@Test
	public void testGetAnswer() {
		assertEquals("Text pour Answer", trueFalseQuestion.getAnswer().get(0).getText());
		assertEquals("Feedback pour Answer", trueFalseQuestion.getAnswer().get(0).getFeedback());
		assertEquals("1.0", String.valueOf(trueFalseQuestion.getAnswer().get(0).getFraction()));
	}



}
