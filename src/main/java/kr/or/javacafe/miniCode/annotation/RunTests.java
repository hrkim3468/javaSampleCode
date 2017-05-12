package kr.or.javacafe.miniCode.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("rawtypes")
public class RunTests {
	
	public static void start() throws Exception {
		int tests = 0;
		int passed = 0;
		
		// Reflection으로 Class 객체를 구한다.
		Class testClass = Class.forName("kr.or.javacafe.miniCode.annotation.Sample");
		
		// 모든 메소드를 검사
		for (Method m : testClass.getDeclaredMethods()) {
			
			// @Test 설정된 메소드만 실행시킨다.
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				
				} catch (InvocationTargetException ex) {
					System.out.println("메소드 " + m + " 실행실패 : " + ex.getCause());
					
				} catch (Exception ex) {
					System.out.println("메소드 " + m + " 용도에 맞지않는 @Test Annotation 사용 : " + ex.getCause());
				}
			}
		}
		
		System.out.println();
		System.out.printf("실행 : %d, 성공 : %d, 실패 : %d%n", tests, passed, tests - passed);
	}




	
}
