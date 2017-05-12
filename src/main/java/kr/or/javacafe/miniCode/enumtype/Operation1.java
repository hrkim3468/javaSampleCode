package kr.or.javacafe.miniCode.enumtype;

/**
 * 일반적인 Enum 타입
 * 
 * apply 메소드를 내부에 구현했으므로 Enum 항목이 추가되면 apply 메소드도 함께 수정되어야 한다.
 * 메소드 수정이 안되어도 컴파일러가 알수 없으므로 Runtime에 오류가 발생할 가능성이 크다.
 * 
 * @author hrkim
 *
 */
public enum Operation1 {

	PLUS, MINUS, TIMES, DIVIDE;
	
	
	// 산술연산을 수행한다.
	public double apply(double x, double y) {
		
		// 항목 추가시 Switch 조건이 함께 추가되어야 함
		switch (this) {
			case PLUS : 	return x + y;
			case MINUS : 	return x - y;
			case TIMES : 	return x * y;
			case DIVIDE : 	return x / y;
		}
		
		// 상수에 해당하는 값이 아닐경우 예외처리 구문이 존재해야 컴파일이 가능함
		throw new AssertionError("Unknown op : " + this);
	}
		
}


