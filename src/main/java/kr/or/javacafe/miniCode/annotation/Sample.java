package kr.or.javacafe.miniCode.annotation;

public class Sample {

	/** Annotation�� ���� Test �����̵Ǵ� �޼ҵ� **/
	@Test
	public static void m1() {
		// ����
	} 
	
	/** Annotation�� ���� Test �����̵Ǵ� �޼ҵ� **/
	@Test
	public static void m2() {
		// ����
		throw new RuntimeException("Boom");
	}
	
	/** Annotation�� ���� Test �����̵Ǵ� �޼ҵ� **/
	@Test
	public void m3() {
		// Static �޼ҵ尡 �ƴϹǷ� Runtime�� ������ �߻�
	}

	/** Annotation�� ���� Test �����̵Ǵ� �޼ҵ� **/
	@Test
	public static void m4() {
		// ����
		throw new RuntimeException("Crash");
	}

	/** ���õǴ� �޼ҵ� **/
	public static void m5() {}
	
	/** ���õǴ� �޼ҵ� **/
	public static void m6() {}

	/** ���õǴ� �޼ҵ� **/
	public static void m7() {}

	/** ���õǴ� �޼ҵ� **/
	public static void m8() {}

}

