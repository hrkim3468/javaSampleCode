package kr.or.javacafe.demo.annotation.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import kr.or.javacafe.demo.annotation.entity.Member;
import kr.or.javacafe.demo.annotation.entity.MemberName;
import kr.or.javacafe.demo.annotation.vo.SmartUserVO;

/**
 * 회원정보 Service
 * 
 * @author hrkim
 *
 */
public class MemberAnnotationService extends MemberService<SmartUserVO> {
	
	
	/**
	 * 회원정보를 변환하여 UserVO 리스트를 제공한다.<br>
	 * Annotation을 이용하여 로직을 처리한다.
	 * 
	 * @return
	 */
	public List<SmartUserVO> getUsers() {
		
		/**
		 * (1) 전체 회원 정보를 조회한다.
		 */
		List<Member> all = getRepository().findAllMember();
		
		
		/**
		 * (2) 전체 회원 이름 정보를 조회한다.
		 */
		List<MemberName> allName = getRepository().findAllMemberName();
		
		
		/**
		 * (3) UserVO 리스트를 생성한다.
		 */
		
		// 회원별 I18nName 객체를 생성한다.
		Map<String, List<MemberName>> memberNamesMap = allName.stream().collect(Collectors.groupingBy(MemberName::getId));
		
		return all.stream()
				.map(o -> new SmartUserVO(o, memberNamesMap.get(o.getId())))
				.collect(Collectors.toList());
	}
	
	

	
}
