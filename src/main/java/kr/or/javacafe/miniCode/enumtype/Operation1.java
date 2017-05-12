package kr.or.javacafe.miniCode.enumtype;

/**
 * �Ϲ����� Enum Ÿ��
 * 
 * apply �޼ҵ带 ���ο� ���������Ƿ� Enum �׸��� �߰��Ǹ� apply �޼ҵ嵵 �Բ� �����Ǿ�� �Ѵ�.
 * �޼ҵ� ������ �ȵǾ �����Ϸ��� �˼� �����Ƿ� Runtime�� ������ �߻��� ���ɼ��� ũ��.
 * 
 * @author hrkim
 *
 */
public enum Operation1 {

	PLUS, MINUS, TIMES, DIVIDE;
	
	
	// ��������� �����Ѵ�.
	public double apply(double x, double y) {
		
		// �׸� �߰��� Switch ������ �Բ� �߰��Ǿ�� ��
		switch (this) {
			case PLUS : 	return x + y;
			case MINUS : 	return x - y;
			case TIMES : 	return x * y;
			case DIVIDE : 	return x / y;
		}
		
		// ����� �ش��ϴ� ���� �ƴҰ�� ����ó�� ������ �����ؾ� �������� ������
		throw new AssertionError("Unknown op : " + this);
	}
		
}


