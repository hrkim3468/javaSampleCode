package kr.or.javacafe.miniCode.generic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.javacafe.miniCode.annotation.RunTests;

public class TestAnnotation {


	@Test
	public void test1() throws Exception {
		RunTests.start();
		
		assertEquals(1, 1);
	}
	

	
	
}
