package kr.or.javacafe.miniCode.generic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

@Deprecated
public class TestGenericSample4 {

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void checkTestA() {
		Set s1 = new HashSet(Arrays.asList(1, 2, 3));
		Set s2 = new HashSet(Arrays.asList(1, 2, 3));
		
		GenericSample4 obj = new GenericSample4();
		obj.check1(s1, s2);
		obj.check2(s1, s2);
		obj.check3(s1, s2);

		assertEquals(1, 1);
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void checkTestB() {
		Set s1 = new HashSet(Arrays.asList(1, 2, 3));
		Set s2 = null;
		
		GenericSample4 obj = new GenericSample4();
		obj.check1(s1, s2);
		obj.check2(s1, s2);
		obj.check3(s1, s2);
		
		assertEquals(1, 1);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void checkTestC() {
		Set s1 = new HashSet(Arrays.asList(1, 2, 3));
		Set s2 = new HashSet(Arrays.asList("aa", "bb"));
		
		GenericSample4 obj = new GenericSample4();
		obj.check1(s1, s2);
		obj.check2(s1, s2);
		obj.check3(s1, s2);
		
		assertEquals(1, 1);
	}
	
	
	@Test
	public void checkTestAA() {
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(1, 2, 3));
		
		GenericSample4 obj = new GenericSample4();
		obj.check2(s1, s2);
		obj.check2(s1, s2);
		obj.check3(s1, s2);

		assertEquals(1, 1);
	}
	
	
	@Test
	public void check2TestBB() {
		Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3));
		Set<Integer> s2 = null;
		
		GenericSample4 obj = new GenericSample4();
		obj.check2(s1, s2);

		assertEquals(1, 1);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void checkTestCC() {
		Set s1 = new HashSet(Arrays.asList(1, 2, 3));
		Set s2 = new HashSet(Arrays.asList("aa", "bb"));
		
		GenericSample4 obj = new GenericSample4();
		obj.check1(s1, s2);
		obj.check2(s1, s2);
		obj.check3(s1, s2);
		
		assertEquals(1, 1);
	}

	
}
