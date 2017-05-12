package kr.or.javacafe.demo.annotation.support.i18n;

import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import kr.or.javacafe.demo.annotation.support.util.ThreadContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class I18nName {

	private String id;
	private Map<Locale, String> nameMap;
	
	
	@Override
	public String toString() {
		Locale locale = ThreadContext.getLocale();
		if (null == locale) {
			return "ERR";
		}
		
		String name = nameMap.get(locale);
		if (StringUtils.isNotEmpty(name)) {
			return name;
		}
		
		return "ERR";
	}
	
	
}
