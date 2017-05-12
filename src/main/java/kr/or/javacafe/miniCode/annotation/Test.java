package kr.or.javacafe.miniCode.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Test Annotation�� �����Ѵ�.
 * 
 * - ���� Static Method�� �����ϴ�. (Annotation �����ڰ� ������ ����)
 * - �ƽ����� �����Ϸ��� �𸥴�. (Runtime������ �߰߰���)
 * 
 * 
 * Annotation ���ǽ� ��ܿ� �����ϴ� Meta-Annotation
 * 
 * - Meta-Annotation ���� �����Ϸ� �������� ��ȿ�� �˻簡 �����ϴ�.
 * - ������ ��ȿ�� ������ Runtime
 * - ��� ������ ������ Method 
 * 
 * @author hrkim
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

}


