package kr.or.javacafe.demo.annotation.dao;

import java.util.ArrayList;
import java.util.List;

import kr.or.javacafe.demo.annotation.entity.Member;
import kr.or.javacafe.demo.annotation.entity.MemberName;

/**
 * 회원정보 Repository
 * 
 * @author hrkim
 *
 */
public class MemberRepository {

	/**
	 * 전체 회원 정보를 조회한다.
	 * @return
	 */
	public List<Member> findAllMember() {
		
		List<Member> result = new ArrayList<>();
		result.add(new Member("batman", "USE", 1));
		result.add(new Member("superman", "STOP", 1));
		result.add(new Member("ironman", "USE", 1));
		
		return result;
	}
	
	
	/**
	 * 전체 회원이름 정보를 조회한다.
	 * @return
	 */
	public List<MemberName> findAllMemberName() {
		
		List<MemberName> result = new ArrayList<>();
		
		result.add(new MemberName("batman", "ko_KR", "배트맨"));
		result.add(new MemberName("batman", "en_US", "BatMan"));
		result.add(new MemberName("batman", "ja_JP", "バットマン"));
		
		result.add(new MemberName("superman", "ko_KR", "슈퍼맨"));
		result.add(new MemberName("superman", "en_US", "SuperMan"));
		result.add(new MemberName("superman", "ja_JP", "スーパーマン"));
		
		result.add(new MemberName("ironman", "ko_KR", "아이언맨"));
		result.add(new MemberName("ironman", "en_US", "IronMan"));
		result.add(new MemberName("ironman", "ja_JP", "アイアンマン"));
		
		return result;	
	}
	
	
}


