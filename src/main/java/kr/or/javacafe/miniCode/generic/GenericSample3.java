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
	


}



