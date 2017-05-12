package kr.or.javacafe.miniCode.annotation;

public class Sample {

	/** Annotation에 의해 Test 수행이되는 메소드 **/
	@Test
	public static void m1() {
		// 성공
	} 
	
	/** Annotation에 의해 Test 수행이되는 메소드 **/
	@Test
	public static void m2() {
		// 실패
		throw new RuntimeException("Boom");
	}
	
	/** Annotation에 의해 Test 수행이되는 메소드 **/
	@Test
	public void m3() {
		// Static 메소드가 아니므로 Runtime에 오류가 발생
	}

	/** Annotation에 의해 Test 수행이되는 메소드 **/
	@Test
	public static void m4() {
		// 실패
		throw new RuntimeException("Crash");
	}

	/** 무시되는 메소드 **/
	public static void m5() {}
	
	/** 무시되는 메소드 **/
	public static void m6() {}

	/** 무시되는 메소드 **/
	public static void m7() {}

	/** 무시되는 메소드 **/
	public static void m8() {}

}

