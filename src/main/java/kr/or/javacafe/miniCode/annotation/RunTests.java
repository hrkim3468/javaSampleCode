package kr.or.javacafe.miniCode.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("rawtypes")
public class RunTests {
	
	public static void start() throws Exception {
		int tests = 0;
		int passed = 0;
		
		// Reflection���� Class ��ü�� ���Ѵ�.
		Class testClass = Class.forName("kr.or.javacafe.miniCode.annotation.Sample");
		
		// ��� �޼ҵ带 �˻�
		for (Method m : testClass.getDeclaredMethods()) {
			
			// @Test ������ �޼ҵ常 �����Ų��.
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				
				} catch (InvocationTargetException ex) {
					System.out.println("�޼ҵ� " + m + " ������� : " + ex.getCause());
					
				} catch (Exception ex) {
					System.out.println("�޼ҵ� " + m + " �뵵�� �����ʴ� @Test Annotation ��� : " + ex.getCause());
				}
			}
		}
		
		System.out.println();
		System.out.printf("���� : %d, ���� : %d, ���� : %d%n", tests, passed, tests - passed);
	}




	
}
