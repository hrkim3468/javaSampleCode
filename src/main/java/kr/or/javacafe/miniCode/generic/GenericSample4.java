package kr.or.javacafe.miniCode.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Deprecated
@SuppressWarnings({"rawtypes", "unused"})
public class GenericSample4 {

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



