package kr.or.javacafe.miniCode.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class GenericSample3 {

	public void add() {
		List<String> strings = new ArrayList<String>();
		unsafeAdd(strings, new Integer(42));
		//safeAdd(strings, new Integer(42));
		
		String s = strings.get(0); // Compiler-generated cast
	}

	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
	
	private static void safeAdd(List<Object> list, Object o) {
		list.add(o);
	}	
	
	
	
	
	
	
	public int check1(Set s1, Set s2) {
		int result = 0;
		for (Object o1 : s1) {
			if (s2.contains(o1)) {
				result++;
			}
		}
		return result;
	}
	
	
	
	public int check2(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o1 : s1) {
			if (s2.contains(o1)) {
				result++;
			}
		}
		return result;
	}
	
	
	
	public int check3(Set<Integer> s1, Set<Integer> s2) {
		int result = 0;
		for (Object o1 : s1) {
			if (s2.contains(o1)) {
				result++;
			}
		}
		return result;
	}
}



