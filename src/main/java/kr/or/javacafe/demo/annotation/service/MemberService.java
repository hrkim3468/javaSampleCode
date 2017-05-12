package kr.or.javacafe.demo.annotation.service;

import java.util.List;

import kr.or.javacafe.demo.annotation.dao.MemberRepository;

/**
 * 회원정보 Service
 * 
 * @author hrkim
 *
 */
public abstract class MemberService<R> {

	private MemberRepository memberRepository;

	public MemberService() {
		memberRepository = new MemberRepository();
	}
	
	
	
	/**
	 * 회원정보 Repository를 제공한다.
	 * @return
	 */
	protected MemberRepository getRepository() {
		return memberRepository;
	}
	
	
	/**
	 * 회원정보를 변환하여 UserVO 리스트를 제공한다.
	 * @return
	 */
	abstract public List<R> getUsers();
	
}
