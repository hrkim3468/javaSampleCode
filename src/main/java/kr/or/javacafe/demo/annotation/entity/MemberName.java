package kr.or.javacafe.demo.annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 회원 이름 정보
 * 
 * @author hrkim
 *
 */
@Getter
@AllArgsConstructor
public class MemberName {

	private String id;
	private String locale;
	private String name;
	
}
