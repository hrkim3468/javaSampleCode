package kr.or.javacafe.demo.annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ȸ�� �̸� ����
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
