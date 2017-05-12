package kr.or.javacafe.demo.annotation.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import kr.or.javacafe.demo.annotation.entity.Member;
import kr.or.javacafe.demo.annotation.entity.MemberName;
import kr.or.javacafe.demo.annotation.vo.SmartUserVO;

/**
 * ȸ������ Service
 * 
 * @author hrkim
 *
 */
public class MemberAnnotationService extends MemberService<SmartUserVO> {
	
	
	/**
	 * ȸ�������� ��ȯ�Ͽ� UserVO ����Ʈ�� �����Ѵ�.<br>
	 * Annotation�� �̿��Ͽ� ������ ó���Ѵ�.
	 * 
	 * @return
	 */
	public List<SmartUserVO> getUsers() {
		
		/**
		 * (1) ��ü ȸ�� ������ ��ȸ�Ѵ�.
		 */
		List<Member> all = getRepository().findAllMember();
		
		
		/**
		 * (2) ��ü ȸ�� �̸� ������ ��ȸ�Ѵ�.
		 */
		List<MemberName> allName = getRepository().findAllMemberName();
		
		
		/**
		 * (3) UserVO ����Ʈ�� �����Ѵ�.
		 */
		
		// ȸ���� I18nName ��ü�� �����Ѵ�.
		Map<String, List<MemberName>> memberNamesMap = allName.stream().collect(Collectors.groupingBy(MemberName::getId));
		
		return all.stream()
				.map(o -> new SmartUserVO(o, memberNamesMap.get(o.getId())))
				.collect(Collectors.toList());
	}
	
	

	
}
