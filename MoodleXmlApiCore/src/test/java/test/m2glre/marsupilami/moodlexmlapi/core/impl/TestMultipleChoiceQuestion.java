package test.m2glre.marsupilami.moodlexmlapi.core.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.MultipleChoiceQuestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestMultipleChoiceQuestion {

	MultipleChoiceQuestion multipleChoiceQuestion = null;
	
	@Before
	public void setUp() throws Exception {
		multipleChoiceQuestion = InitObjetFactory.initMultipleChoiceQuestion();
	}

	@Test
	public void testMultipleChoiceQuestion() {
		assertNotNull(multipleChoiceQuestion);
	}

	@Test
	public void testIsSingle() {
		assertEquals(true, multipleChoiceQuestion.isSingle());
	}


	@Test
	public void testGetShuffleanswers() {
		assertEquals(true, multipleChoiceQuestion.getShuffleanswers());
	}


	@Test
	public void testGetAnswer() {
		assertEquals("Text pour Answer", multipleChoiceQuestion.getAnswer().get(0).getText());
	}


	@Test
	public void testGetAnswernumbering() {
		assertEquals("none", multipleChoiceQuestion.getAnswernumbering().toString());
	}


	@Test
	public void testGetCorrectfeedback() {
		assertEquals("Correctfeedback", multipleChoiceQuestion.getCorrectfeedback());
	}


	@Test
	public void testGetPartiallycorrectfeedback() {
		assertEquals("Partiallycorrectfeedback", multipleChoiceQuestion.getPartiallycorrectfeedback());
	}


	@Test
	public void testGetIncorrectfeedback() {
		assertEquals("IncorrectFeedback", multipleChoiceQuestion.getIncorrectfeedback());
	}


}
