package kr.or.javacafe.miniCode.enumtype;

public class EnumSample {

	// 상수 선언
	public static final int APPLE_PUJI = 0;
	public static final int APPLE_PIPPIN = 1;
	public static final int APPLE_GRANNY_SMITH = 2;
	
	public static final int ORANGE_NAVEL = 0;
	public static final int ORANGE_TEMPLE = 0;
	public static final int ORANGE_BLOOD = 0;
	

	// 열거형 선언
	public enum Apple {
		PUJI, PIPPIN, GRANNY_SMITH
	}
		
	public enum Orange {
		NAVEL, TEMPLE, BLOOD
	}
	
	
}
