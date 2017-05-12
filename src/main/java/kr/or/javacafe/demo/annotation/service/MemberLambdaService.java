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
 * ȸ������ Service
 * 
 * @author hrkim
 *
 */
public class MemberLambdaService extends MemberService<UserVO> {
	
	
	/**
	 * ȸ�������� ��ȯ�Ͽ� UserVO ����Ʈ�� �����Ѵ�.<br>
	 * Lambda�� �̿��Ͽ� ������ ó���Ѵ�.
	 * 
	 * @return
	 */
	public List<UserVO> getUsers() {
		
		/**
		 * (1) ��ü ȸ�� ������ ��ȸ�Ѵ�.
		 */
		List<Member> all = getRepository().findAllMember();
		
		
		/**
		 * (2) ��ü ȸ�� �̸� ������ ��ȸ�Ѵ�.
		 */
		List<MemberName> allName = getRepository().findAllMemberName();
		
		
		/**
		 * (3) ȸ������ �ʿ� ��ü�� �����Ѵ�.
		 */
		
		// ȸ���� I18nName ��ü�� �����Ѵ�.
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
		
		// ȸ���� Status ��ü�� �����Ѵ�.
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
		 * (4) UserVO ����Ʈ�� �����Ѵ�.
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
