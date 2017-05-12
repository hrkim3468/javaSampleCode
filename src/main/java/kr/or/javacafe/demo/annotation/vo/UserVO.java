package kr.or.javacafe.demo.annotation.vo;

import kr.or.javacafe.demo.annotation.support.i18n.I18nName;
import kr.or.javacafe.demo.annotation.support.type.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserVO {

	/** ȸ�� id **/
	private String id;
	
	/** ȸ���� (i18n) **/
	private I18nName name;
	
	/** ���� (enum) **/
	private Status status;
	
	/** ���� **/
	private int level;
	
	
}
