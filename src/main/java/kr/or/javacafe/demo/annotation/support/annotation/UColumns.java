package kr.or.javacafe.demo.annotation.support.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UColumns {

	public enum UType {
		BASIC("BASIC"), 
		ENUM_TYPE("ENUM_TYPE"),
		I18N_TYPE("I18N_TYPE");
		
		String value;
		
		private UType(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return this.value;
		}
	}
	
	UType type() default UType.BASIC;
	String mappedBy() default "";
	Class<?> castClass() default Object.class;
	
}
