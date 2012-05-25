package test.m2glre.marsupilami.moodlexmlapi.core.impl;

import static org.junit.Assert.*;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.NumericalQuestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestNumericalQuestion {

	public NumericalQuestion numericalQuestion = null;
	
	@Before
	public void setUp() throws Exception {
		numericalQuestion = InitObjetFactory.initNumericalQuestion();
	}
	
	@Test
	public void testTypeQuestion() {
		assertEquals("numerical", numericalQuestion.getType().toString());
	}

	@Test
	public void testGetAnswer() {
		assertEquals("Very Bad", numericalQuestion.getAnswer().get(1).getText());
		assertEquals(0, numericalQuestion.getAnswer().get(0).getTolerance());
	}

	@Test
	public void testGetUnit() {
		assertEquals("Unit 1", numericalQuestion.getUnit().get(0).getUnit_name());
		assertEquals(1, numericalQuestion.getUnit().get(0).getMultiplier());
	}

}
