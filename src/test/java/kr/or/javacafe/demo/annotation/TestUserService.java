package kr.or.javacafe.demo.annotation;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Locale;

import org.junit.Test;

import kr.or.javacafe.demo.annotation.service.MemberAnnotationService;
import kr.or.javacafe.demo.annotation.service.MemberIterationService;
import kr.or.javacafe.demo.annotation.service.MemberLambdaService;
import kr.or.javacafe.demo.annotation.service.MemberService;
import kr.or.javacafe.demo.annotation.support.util.ThreadContext;
import kr.or.javacafe.demo.annotation.vo.SmartUserVO;
import kr.or.javacafe.demo.annotation.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestUserService {


	/**
	 * Iteration 방식 테스트
	 */
	@Test
	public void testIterator() {
		
		MemberService<UserVO> service = new MemberIterationService();
		List<UserVO> users = service.getUsers();
		
		log.info("### Iteration 방식 테스트를 수행합니다.\n");
		printUser(users);

		assertEquals(3, users.size());
	}
	

	/**
	 * Lambda 방식 테스트
	 */
	@Test
	public void testLambda() {
		
		MemberService<UserVO> service = new MemberLambdaService();
		List<UserVO> users = service.getUsers();
		
		log.info("### Lambda 방식 테스트를 수행합니다.\n");
		printUser(users);

		assertEquals(3, users.size());
	}
	
	
	/**
	 * Annotation 방식 테스트
	 */
	@Test
	public void testAnnotation() {
		
		MemberService<SmartUserVO> service = new MemberAnnotationService();
		List<SmartUserVO> users = service.getUsers();
		
		log.info("### Annotation 방식 테스트를 수행합니다.\n");
		printUser(users);

		assertEquals(3, users.size());
	}
	
	
	
	private void printUser(List<?> params) {
		log.info("================================");
		log.info("한국어 이름으로 출력");
		log.info("================================");
		for (Object param : params) {
			log.info(param.toString());
		}
		
		
		ThreadContext.setLocale(Locale.US);
		
		log.info("================================");
		log.info("영어 이름으로 출력");
		log.info("================================");
		for (Object param : params) {
			log.info(param.toString());
		}

		
		ThreadContext.setLocale(Locale.JAPAN);

		log.info("================================");
		log.info("일본어 이름으로 출력");
		log.info("================================");
		for (Object param : params) {
			log.info(param.toString());
		}		
	}
	
	
}
