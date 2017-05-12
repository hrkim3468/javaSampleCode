package kr.or.javacafe.demo.annotation.vo;

import kr.or.javacafe.demo.annotation.support.i18n.I18nName;
import kr.or.javacafe.demo.annotation.support.type.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 사용자 정보
 * 
 * @author hrkim
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {

	/** 회원 id **/
	private String id;
	
	/** 회원명 (i18n) **/
	private I18nName name;
	
	/** 상태 (enum) **/
	private Status status;
	
	/** 레벨 **/
	private int level;
	
	
}
