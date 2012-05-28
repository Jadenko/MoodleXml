package test.m2glre.marsupilami.moodlexmlapi.core.data;

import static org.junit.Assert.*;

import m2glre.marsupilami.moodlexmlapi.core.data.impl.Quiz;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestQuiz {

	Quiz unQuiz = null;
	
	@Before
	public void setUp() throws Exception {
		unQuiz = InitObjetFactory.initQuiz();
	}


	@Test
	public void testGetQuestionList() {
		assertEquals(unQuiz.getQuestionList().size(), 1);
	}

}
