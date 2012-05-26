package test.m2glre.marsupilami.moodlexmlapi.core;

import static org.junit.Assert.*;

import m2glre.marsupilami.moodlexmlapi.core.InvalidQuizFormatException;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestInvalidQuizFormatException {
	InvalidQuizFormatException invalidQuizFormatException = null;
	String msg ;
	@Before
	public void setUp() {
		invalidQuizFormatException = InitObjetFactory.initInvalidQuizFormatException();
	}

	@Test
	public void test() {
		
		msg = invalidQuizFormatException.getMessage();
		assertEquals("invalidQuizFormat",msg);
		
	}

}
