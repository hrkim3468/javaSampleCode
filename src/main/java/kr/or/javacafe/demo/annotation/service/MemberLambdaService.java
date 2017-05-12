package kr.or.javacafe.demo.annotation.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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
public class MemberLambdaService extends MemberService<UserVO> {
	
	
	/**
	 * 회원정보를 변환하여 UserVO 리스트를 제공한다.<br>
	 * Lambda를 이용하여 로직을 처리한다.
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
		 * (3) 회원별로 필요 객체를 생성한다.
		 */
		
		// 회원별 I18nName 객체를 생성한다.
		Map<String, List<MemberName>> memberNamesMap = allName.stream().collect(Collectors.groupingBy(MemberName::getId));
		Map<String, I18nName> i18nNameMap = all.stream()
				.map(o -> {
					Map<Locale, String> nameMap = memberNamesMap.get(o.getId()).stream()
							.collect(Collectors.toMap(name -> {
								String[] arr = name.getLocale().split("_");
								return new Locale(arr[0], arr[1]);				
							}, name -> name.getName()));
					
					return new I18nName(o.getId(), nameMap);			
				})
				.collect(Collectors.toMap(o -> o.getId(), o -> o));
		
		// 회원별 Status 객체를 생성한다.
		Map<String, Status> statusMap = all.stream().collect(Collectors.toMap(o -> o.getId(), o -> {
			Status memberStatus = Status.DEL;
			for (Status status : Status.values()) {
				if (status.getId().equals(o.getStatus())) {
					memberStatus = status;
				}
			}
			return memberStatus;			
		}));
		
		
		/**
		 * (4) UserVO 리스트를 생성한다.
		 */
		return all.stream().map(o -> {
			UserVO user = new UserVO();
			user.setId(o.getId());
			user.setName(i18nNameMap.get(o.getId()));
			user.setStatus(statusMap.get(o.getId()));
			user.setLevel(o.getLevel());
			
			return user;
		}).collect(Collectors.toList());
	}
	
	

	
}
