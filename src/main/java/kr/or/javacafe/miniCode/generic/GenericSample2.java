package kr.or.javacafe.miniCode.generic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class GenericSample2 {

	private List<String> result = new ArrayList<>();

	public void test() {
		result.add("1");
		result.add("2");

		for (int i=0; i<result.size(); i++) {
			String data1 = (String)result.get(i);
			//int data2 = (int)result.get(i);
		}
	}
	
}



