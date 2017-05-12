package kr.or.javacafe.demo.annotation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import kr.or.javacafe.demo.annotation.entity.Member;
import kr.or.javacafe.demo.annotation.entity.MemberName;
import kr.or.javacafe.demo.annotation.support.i18n.I18nName;
import kr.or.javacafe.demo.annotation.support.type.Status;
import kr.or.javacafe.demo.annotation.vo.UserVO;

/**
 * 회원정보 Service
 * 
 * @author hrkim
 *
 */
public class MemberIterationService extends MemberService<UserVO> {
	
	
	/**
	 * 회원정보를 변환하여 UserVO 리스트를 제공한다.<br>
	 * 전통적인 Iterator 방식을 이용하여 로직을 처리한다.
	 * 
	 * @return
	 */
	public List<UserVO> getUsers() {
		
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
		List<UserVO> result = new ArrayList<>();
		for (Member member : all) {
			
			// 회원의 다국어 이름 리스트를 구한다.
			List<MemberName> memberNames = new ArrayList<>(); 
			for (MemberName obj : allName) {
				if (member.getId().equals(obj.getId())) {
					memberNames.add(obj);
				}
			}
			
			// Locale 정보를 Key로 가지는 맵으로 변환한다.
			Map<Locale, String> nameMap = new HashMap<>();
			for (MemberName obj : memberNames) {
				String[] arr = obj.getLocale().split("_");
				nameMap.put(new Locale(arr[0], arr[1]), obj.getName());
			}
			
			// I18nName 객체를 생성한다.
			I18nName i18nName = new I18nName(member.getId(), nameMap);

			// 문자열을 Enum 타입의 Status 객체로 변환한다.
			Status memberStatus = Status.DEL;
			for (Status status : Status.values()) {
				if (status.getId().equals(member.getStatus())) {
					memberStatus = status;
				}
			}
			
			// UserVO 정보 생성 (Name, Status 속성에 객체가 설정된다.)
			UserVO user = new UserVO();
			user.setId(member.getId());
			user.setName(i18nName);
			user.setStatus(memberStatus);
			user.setLevel(member.getLevel());
			
			// 결과에 추가
			result.add(user);
		}
		
		return result;
	}
	
	

	
}
