package kr.or.javacafe.miniCode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test Annotation을 정의한다.
 * 
 * - 사용시 Static Method만 가능하다. (Annotation 개발자가 정의한 범위)
 * - 아쉽지만 컴파일러는 모른다. (Runtime에서만 발견가능)
 * 
 * 
 * Annotation 정의시 상단에 설정하는 Meta-Annotation
 * 
 * - Meta-Annotation 사용시 컴파일러 레벨에서 유효성 검사가 가능하다.
 * - 동작이 유효한 범위는 Runtime
 * - 사용 가능한 범위는 Method 
 * 
 * @author hrkim
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

}


