package test.m2glre.marsupilami.moodlexmlapi.core.data;

import static org.junit.Assert.*;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;
import m2glre.marsupilami.moodlexmlapi.core.data.QuestionText;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestGenericQuestion {
	
	GenericQuestion genericQuestion = null;
	GenericQuestion genericQuestion2 = null;
	@Before
	public void setUp() throws Exception {
		genericQuestion = InitObjetFactory.initGenericQuestion();
		genericQuestion2 = new GenericQuestion();
		genericQuestion2.setName("Question avec un Très Long Nom");
		genericQuestion2.setQuestionText(new QuestionText("Très Long Texte: Cette question comporte du texte 1234567890" +
				"123456"));
	}


	@Test
	public void testQuestionType() {
		assertEquals("calculated", genericQuestion.getType().toString());
	}


	@Test
	public void testSetName() {
		assertEquals("LeNom", genericQuestion.getName());
		assertEquals(genericQuestion2.getQuestionText().getText(),
				"Très Long Texte: Cette question comporte du texte 1234567890\n\t\t" +
						"123456");
	}

	@Test
	public void testSetQuestionText() {
		assertEquals("moodle_auto_format", genericQuestion.getQuestionText().getQuestionTextFormat().toString());
		assertEquals("Le Texte de la Question", genericQuestion.getQuestionText().getText());
	}
	
	@Test
	public void testSetGeneralFeedBack() {
		assertEquals("Le General Feedback", genericQuestion.getGeneralFeedBack());
	}

	@Test
	public void testSetPenalty() {
		assertEquals("1.0", genericQuestion.getPenalty().toString());
	}

	@Test
	public void testSetDefaultGrade() {
		assertEquals("1.0", genericQuestion.getDefaultGrade().toString());
	}

	@Test
	public void testSetIsHidden() {
		assertTrue(genericQuestion.isHidden());
	}

	@Test
	public void testSetImageUrl() {
		assertEquals("Image URL", genericQuestion.getImageUrl());
	}

	@Test
	public void testSetImageBase64() {
		assertEquals("Image Base 64", genericQuestion.getImageBase64());
	}

	@Test
	public void testSetErrors() {
		assertEquals("Erreur Merdique", genericQuestion.getErrors().get(0).getDescription());
		assertEquals("Alpha", genericQuestion.getErrors().get(0).getCode());

	}

	
}
