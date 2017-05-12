package kr.or.javacafe.demo.annotation.support.type;

/**
 * 계정 상태
 * 
 * @author hrkim
 *
 */
public enum Status {
	
	// 사용
	USE("USE", "사용"),
	
	// 잠김
	STOP("STOP", "잠김"), 
	
	// 삭제
	DEL("DEL", "삭제");
	
	
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
