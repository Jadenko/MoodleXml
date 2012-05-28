package test.m2glre.marsupilami.moodlexmlapi.core.impl;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import m2glre.marsupilami.moodlexmlapi.core.data.impl.MatchingQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.impl.Subquestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestMatchingQuestion {

	MatchingQuestion matchingQuestion = null;
	MatchingQuestion matchingQuestionBis = null;
	
	@Before
	public void setUp() throws Exception {
		matchingQuestion = InitObjetFactory.initMatchingQuestion();
		matchingQuestionBis = new MatchingQuestion(false, InitObjetFactory.initListSubquestion());
	}

	@Test
	public void testSetShuffleanswers() {
		assertEquals(matchingQuestion.getType().toString(), "matching");
		assertEquals(true, matchingQuestion.isShuffleanswers());
		assertEquals(false, matchingQuestionBis.isShuffleanswers());
	}

	@Test
	public void testSetSubquestion() {
		List<Subquestion> subquestions = matchingQuestion.getSubquestion();
		Iterator it = subquestions.iterator();
		int index = 0;
		while (it.hasNext()) {

			Subquestion element = (Subquestion) it.next();
			if (index == 0) {
				assertEquals(element.getText(), "Text0");
				assertEquals(element.getAnswer().getText(), "Redhat");
				index ++;
			}
			else {
				assertEquals(element.getText(), "Text1");
				assertEquals(element.getAnswer().getText(), "IBM");
			}

		}

	}
}
