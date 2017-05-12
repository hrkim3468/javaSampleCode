package kr.or.javacafe.demo.annotation.service;

import java.util.List;

import kr.or.javacafe.demo.annotation.dao.MemberRepository;

/**
 * ȸ������ Service
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
	 * ȸ������ Repository�� �����Ѵ�.
	 * @return
	 */
	protected MemberRepository getRepository() {
		return memberRepository;
	}
	
	
	/**
	 * ȸ�������� ��ȯ�Ͽ� UserVO ����Ʈ�� �����Ѵ�.
	 * @return
	 */
	abstract public List<R> getUsers();
	
}
