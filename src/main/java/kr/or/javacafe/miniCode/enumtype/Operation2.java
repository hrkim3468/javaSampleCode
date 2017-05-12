package kr.or.javacafe.miniCode.enumtype;

/**
 * Ư�� ��� �޼ҵ带 �����ϴ� Enum Ÿ��
 * 
 * apply �޼ҵ带 �߻� �޼ҵ�� �����ϰ� ������ Enum �׸��� �޼ҵ带 �����Ѵ�.
 * Enum �׸� �߰��� �޼ҵ尡 �Բ� �����ǹǷ� ���� �߻� Ȯ���� ���� �� �ִ�.
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
	
	
	// ��������� �����Ѵ�.
	public abstract double apply(double x, double y);
		
}

