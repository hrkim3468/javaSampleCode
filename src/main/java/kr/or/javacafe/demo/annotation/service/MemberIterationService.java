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
 * ȸ������ Service
 * 
 * @author hrkim
 *
 */
public class MemberIterationService extends MemberService<UserVO> {
	
	
	/**
	 * ȸ�������� ��ȯ�Ͽ� UserVO ����Ʈ�� �����Ѵ�.<br>
	 * �������� Iterator ����� �̿��Ͽ� ������ ó���Ѵ�.
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
		 * (3) UserVO ����Ʈ�� �����Ѵ�.
		 */
		List<UserVO> result = new ArrayList<>();
		for (Member member : all) {
			
			// ȸ���� �ٱ��� �̸� ����Ʈ�� ���Ѵ�.
			List<MemberName> memberNames = new ArrayList<>(); 
			for (MemberName obj : allName) {
				if (member.getId().equals(obj.getId())) {
					memberNames.add(obj);
				}
			}
			
			// Locale ������ Key�� ������ ������ ��ȯ�Ѵ�.
			Map<Locale, String> nameMap = new HashMap<>();
			for (MemberName obj : memberNames) {
				String[] arr = obj.getLocale().split("_");
				nameMap.put(new Locale(arr[0], arr[1]), obj.getName());
			}
			
			// I18nName ��ü�� �����Ѵ�.
			I18nName i18nName = new I18nName(member.getId(), nameMap);

			// ���ڿ��� Enum Ÿ���� Status ��ü�� ��ȯ�Ѵ�.
			Status memberStatus = Status.DEL;
			for (Status status : Status.values()) {
				if (status.getId().equals(member.getStatus())) {
					memberStatus = status;
				}
			}
			
			// UserVO ���� ���� (Name, Status �Ӽ��� ��ü�� �����ȴ�.)
			UserVO user = new UserVO();
			user.setId(member.getId());
			user.setName(i18nName);
			user.setStatus(memberStatus);
			user.setLevel(member.getLevel());
			
			// ����� �߰�
			result.add(user);
		}
		
		return result;
	}
	
	

	
}
