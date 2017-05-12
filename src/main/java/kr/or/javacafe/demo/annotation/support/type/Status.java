package kr.or.javacafe.demo.annotation.support.type;

/**
 * ���� ����
 * 
 * @author hrkim
 *
 */
public enum Status {
	
	// ���
	USE("USE", "���"),
	
	// ���
	STOP("STOP", "���"), 
	
	// ����
	DEL("DEL", "����");
	
	
	String id;
	String name;
	
	Status(String id, String name) {
		this.id = id;
		this.name= name;
	}
	
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
