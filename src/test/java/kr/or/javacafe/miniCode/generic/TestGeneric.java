package kr.or.javacafe.miniCode.generic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {


	@Test
	public void test0() {
		GenericSample3 obj = new GenericSample3();
		obj.add();

		assertEquals(1, 1);
	}
	
	
	@Test
	public void test1() {
		Set s1 = new HashSet(Arrays.asList(1, 2, 3));
		Set s2 = new HashSet(Arrays.asList(1, 2, 3));
		
		GenericSample3 obj = new GenericSample3();
		obj.check1(s1, s2);

		assertEquals(1, 1);
	}

	
	@Test
	public void test2() {
		Set s1 = new HashSet(Arrays.asList(1, 2, 3));
		Set s2 = null;
		
		GenericSample3 obj = new GenericSample3();
		obj.check1(s1, s2);

		assertEquals(1, 1);
	}
	
	
	@Test
	public void test3() {
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(1, 2, 3));
		
		GenericSample3 obj = new GenericSample3();
		obj.check2(s1, s2);

		assertEquals(1, 1);
	}
	
	@Test
	public void test4() {
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> s2 = null;
		
		GenericSample3 obj = new GenericSample3();
		obj.check2(s1, s2);

		assertEquals(1, 1);
	}
	
	
	
	@Test
	public void test5() {
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<String> s2 = new HashSet<>(Arrays.asList("aa"));
		
		GenericSample3 obj = new GenericSample3();
		//obj.check3(s1, s2);

		assertEquals(1, 1);
	}
	
	
}
