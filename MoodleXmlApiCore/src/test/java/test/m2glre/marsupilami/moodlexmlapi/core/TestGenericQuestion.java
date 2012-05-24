package test.m2glre.marsupilami.moodlexmlapi.core;

import static org.junit.Assert.*;

import m2glre.marsupilami.moodlexmlapi.core.data.GenericQuestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestGenericQuestion {
	
	GenericQuestion genericQuestion = null;
	
	@Before
	public void setUp() throws Exception {
		genericQuestion = InitObjetFactory.initGenericQuestion();
	}


	@Test
	public void testQuestionType() {
		assertEquals("calculated", genericQuestion.getType().toString());
	}


	@Test
	public void testSetName() {
		assertEquals("LeNom", genericQuestion.getName());
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
