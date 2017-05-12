package kr.or.javacafe.demo.annotation.support.util;

import java.util.Locale;

public class ThreadContext {

	private static Locale currentLocale = Locale.KOREA;
	
	public static void setLocale(Locale locale) {
		currentLocale = locale;
	}
			
	public static Locale getLocale() {
		return currentLocale;
	}
}
