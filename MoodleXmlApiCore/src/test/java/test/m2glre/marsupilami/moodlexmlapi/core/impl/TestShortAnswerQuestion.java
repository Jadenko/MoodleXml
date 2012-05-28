package test.m2glre.marsupilami.moodlexmlapi.core.impl;

import static org.junit.Assert.*;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.ShortAnswerQuestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestShortAnswerQuestion {

	public ShortAnswerQuestion shortAnswerQuestion = null;

	@Before
	public void setUp() throws Exception {
		shortAnswerQuestion = InitObjetFactory.initShortAnswerQuestion();
	}


	@Test
	public void testGetAnswer() {
		assertEquals("Text pour Answer", shortAnswerQuestion.getAnswer().get(2).getFeedback());
	}

//	@Test
//	public void testSetAnswer() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testIsUsecase() {
		assertTrue(shortAnswerQuestion.isUsecase());
	}



}
