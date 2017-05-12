package kr.or.javacafe.demo.annotation.vo;

import java.util.List;

import kr.or.javacafe.demo.annotation.entity.Member;
import kr.or.javacafe.demo.annotation.entity.MemberName;
import kr.or.javacafe.demo.annotation.support.annotation.UColumns;
import kr.or.javacafe.demo.annotation.support.annotation.UColumns.UType;
import kr.or.javacafe.demo.annotation.support.annotation.UColumnsProcessor;
import kr.or.javacafe.demo.annotation.support.i18n.I18nName;
import kr.or.javacafe.demo.annotation.support.type.Status;
import lombok.Getter;
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
@ToString
public class SmartUserVO {

	/** 회원 id **/
	@UColumns(type = UType.BASIC, mappedBy = "id")
	private String id;
	
	/** 회원명 (i18n) **/
	@UColumns(type = UType.I18N_TYPE, mappedBy = "id")
	private I18nName name;
	
	/** 상태 (enum) **/
	@UColumns(type = UType.ENUM_TYPE, mappedBy = "status", castClass = Status.class)
	private Status status;
	
	/** 레벨 **/
	@UColumns(type = UType.BASIC, mappedBy = "level")
	private int level;
	
	
	
	/**
	 * [생성자] SmartUserVO 객체는 생성자를 통해서만 생성이 가능하다.
	 */
	public SmartUserVO(Member member, List<MemberName> memberNames) {
		UColumnsProcessor.process(this, member, memberNames);
	}
	
	
}
