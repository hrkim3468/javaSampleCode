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
 * ����� ����
 * 
 * @author hrkim
 *
 */
@Getter
@Setter
@ToString
public class SmartUserVO {

	/** ȸ�� id **/
	@UColumns(type = UType.BASIC, mappedBy = "id")
	private String id;
	
	/** ȸ���� (i18n) **/
	@UColumns(type = UType.I18N_TYPE, mappedBy = "id")
	private I18nName name;
	
	/** ���� (enum) **/
	@UColumns(type = UType.ENUM_TYPE, mappedBy = "status", castClass = Status.class)
	private Status status;
	
	/** ���� **/
	@UColumns(type = UType.BASIC, mappedBy = "level")
	private int level;
	
	
	
	/**
	 * [������] SmartUserVO ��ü�� �����ڸ� ���ؼ��� ������ �����ϴ�.
	 */
	public SmartUserVO(Member member, List<MemberName> memberNames) {
		UColumnsProcessor.process(this, member, memberNames);
	}
	
	
}
