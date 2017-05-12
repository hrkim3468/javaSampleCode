package kr.or.javacafe.miniCode.generic;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class GenericSample2 {

	// String 타입의 Generic 적용
	private List<String> result = new ArrayList<>();

	public void test() {
		result.add("1");
		result.add("2");

		for (int i=0; i<result.size(); i++) {			
			String data1 = (String)result.get(i);
			//int data2 = (int)result.get(i);	// 타입캐스팅 오류를 컴파일러가 알 수 있다.
		}
	}
	
	
}



