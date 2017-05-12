package kr.or.javacafe.miniCode.generic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.javacafe.miniCode.enumtype.Operation1;
import kr.or.javacafe.miniCode.enumtype.Operation2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestEnum {


	@Test
	public void test1() {
		double x = 100;
		double y = 10;

		for (Operation1 op : Operation1.values()) {
			log.info("{}, {}", op, op.apply(x, y));
		}
		
		assertEquals(1, 1);
	}
	

	@Test
	public void test2() {
		double x = 100;
		double y = 10;

		for (Operation2 op : Operation2.values()) {
			log.info("{}, {}", op, op.apply(x, y));
		}
		
		assertEquals(1, 1);
	}
	

	
	
}
