package kr.or.javacafe.demo.annotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 회원 정보
 * 
 * @author hrkim
 *
 */
@Getter
@AllArgsConstructor
public class Member {

	private String id;
	private String status;
	private int level;
	
}
