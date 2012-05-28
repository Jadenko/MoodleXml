package test.m2glre.marsupilami.moodlexmlapi.core;

import static org.junit.Assert.*;

import m2glre.marsupilami.moodlexmlapi.core.InvalidStreamSizeException;

import org.junit.Before;
import org.junit.Test;

public class TestInvalidStreamSizeException {

	InvalidStreamSizeException invalidStreamSizeException ;
	
	@Before
	public void setUp() throws Exception {
		invalidStreamSizeException = new InvalidStreamSizeException(new Long("90"), new Long("900"));
	}

	@Test
	public void testGetMaxSize() {
		assertEquals(new Long("90"), invalidStreamSizeException.getMaxSize());
	}

	@Test
	public void testGetStreamSize() {
		assertEquals(new Long("900"), invalidStreamSizeException.getStreamSize());
	}

}
