package m2glre.marsupilami.moodlexmlapi.impl;

import m2glre.marsupilami.moodlexmlapi.core.data.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MainTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public MainTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(MainTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		QuestionError questionError = new QuestionError("type not supported", "the question type is not supported");
        System.out.println(questionError.getDescription());
        assertEquals("type not supported", questionError.getCode());
	}
}
