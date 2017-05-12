package kr.or.javacafe.miniCode.enumtype;

/**
 * 특정 상수 메소드를 구현하는 Enum 타입
 * 
 * apply 메소드를 추상 메소드로 선언하고 각각의 Enum 항목이 메소드를 구현한다.
 * Enum 항목 추가시 메소드가 함께 구현되므로 오류 발생 확률을 줄일 수 있다.
 * 
 * @author hrkim
 *
 */
public enum Operation2 {

	PLUS {
		public double apply(double x, double y) {
			return x + y;
		}
	}, 
	MINUS {
		public double apply(double x, double y) {
			return x - y;
		}		
	}, 
	TIMES {
		public double apply(double x, double y) {
			return x * y;
		}
	}, 
	DIVIDE {
		public double apply(double x, double y) {
			return x / y;
		}
	};
	
	
	// 산술연산을 수행한다.
	public abstract double apply(double x, double y);
		
}

