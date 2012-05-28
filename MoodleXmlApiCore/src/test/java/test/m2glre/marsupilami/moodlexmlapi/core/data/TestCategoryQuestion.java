package test.m2glre.marsupilami.moodlexmlapi.core.data;

import static org.junit.Assert.*;
import m2glre.marsupilami.moodlexmlapi.core.data.CategoryQuestion;

import org.junit.Before;
import org.junit.Test;

import test.m2glre.marsupilami.moodlexmlapi.core.init.InitObjetFactory;

public class TestCategoryQuestion {

	CategoryQuestion categoryQuestion = null ;
	
	@Before
	public void setUp() throws Exception {
		categoryQuestion = InitObjetFactory.initCategoryQuestion();
	}

	@Test
	public void testGetType() {
		assertEquals(categoryQuestion.getType().toString(), "category");
	}
	

	@Test
	public void testGetCategory() {
		assertEquals("IVVQ/LaCategorie",
					  categoryQuestion.getCategory());
	}

	@Test
	public void testGetCourse() {
		assertEquals(categoryQuestion.getCourse(), "IVVQ");
	}

	@Test
	public void testGetName() {
		assertNull(categoryQuestion.getName());
	}

	@Test
	public void testGetQuestionText() {
		assertNull(categoryQuestion.getQuestionText());
	}

	@Test
	public void testGetGeneralFeedBack() {
		assertNull(categoryQuestion.getGeneralFeedBack());
	}

	@Test
	public void testGetPenalty() {
		assertNull(categoryQuestion.getPenalty());
	}

	@Test
	public void testGetDefaultGrade() {
		assertNull(categoryQuestion.getDefaultGrade());
	}

	@Test
	public void testIsHidden() {
		assertNull(categoryQuestion.isHidden());
	}

	@Test
	public void testGetImageUrl() {
		assertNull(categoryQuestion.getImageUrl());
	}

	@Test
	public void testGetImageBase64() {
		assertNull(categoryQuestion.getImageBase64());
	}

	@Test
	public void testGetErrors() {
		assertNull(categoryQuestion.getErrors());
	}


}
