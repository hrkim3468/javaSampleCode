package kr.or.javacafe.demo.annotation.support.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import kr.or.javacafe.demo.annotation.entity.Member;
import kr.or.javacafe.demo.annotation.entity.MemberName;
import kr.or.javacafe.demo.annotation.support.annotation.UColumns.UType;
import kr.or.javacafe.demo.annotation.support.i18n.I18nName;
import kr.or.javacafe.demo.annotation.support.type.Status;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UColumnsProcessor {
	
	

	/**
	 * SmartUserVO ��ü�� �����Ѵ�.
	 * 
	 * @param user
	 * @param member
	 * @param memberNames
	 */
	public static void process(Object obj, Object rawObj, List<MemberName> names) {
		try {
			@SuppressWarnings("rawtypes")
			Class klass = obj.getClass();			
			for (Field f : klass.getDeclaredFields()) {
				try {
					UColumns col = f.getAnnotation(UColumns.class);			
					if (null == col) {
						continue;
					}
					
					log.debug("type : {}", col.type());
					log.debug("mappedBy {}: ", col.mappedBy());
					log.debug("castClass : {}", col.castClass());

					// UType ���� ó���� �б��Ѵ�.
					if (UType.BASIC.equals(col.type())) {
						basicTypeProcess(obj, f, rawObj, col);
						
					} else if (UType.I18N_TYPE.equals(col.type())) {
						i18nTypeProcess(obj, f, rawObj, col, names);
						
					} else if (UType.ENUM_TYPE.equals(col.type())) {
						enumTypeProcess(obj, f, rawObj, col);
						
					} else {
						log.error("@UColumns Annotation�� �˼����� Ÿ���� �����Ǿ����ϴ�. (" + col.toString() + ")");
					}							
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	/**
	 * BAISC Ÿ���� �÷��� ���� ó���Ѵ�.
	 * 
	 * @param obj
	 * @param f
	 * @param rawObj
	 * @param annotation
	 */
	private static void basicTypeProcess(Object obj, Field f, Object rawObj, UColumns annotation) {
		try {
			// ó���� Raw �ʵ带 ���Ѵ�.
			Field rawField = readRawFieldInfo(rawObj, annotation);
			if (null == rawField) {
				return;
			}
			
			// ���� Ŭ������ �ʵ忡 ������ �����Ѵ�.
			f.setAccessible(true);
			
			if (f.getType() == int.class || f.getType() == Integer.class) {
				f.set(obj, (int)rawField.get(rawObj));
				return;			
			} 
			
			if (f.getType() == long.class || f.getType() == Long.class) {
				f.set(obj, (long)rawField.get(rawObj));
				return;	
			} 
			
			if (f.getType() == float.class || f.getType() == Float.class) {
				f.set(obj, (float)rawField.get(rawObj));
				return;	
			}
			
			if (f.getType() == String.class) {
				f.set(obj, (String)rawField.get(rawObj));
				return;	
			}
			
			if (f.getType() == java.util.Date.class) {
				f.set(obj, (java.util.Date)rawField.get(rawObj));	
				return;	
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		log.error("[@UColumns] ���������ʴ� DataType�� �����մϴ�. (mappedBy:{})", annotation.mappedBy());
	}

	
	/**
	 * I18N Ÿ���� �÷��� ���� ó���Ѵ�.
	 * 
	 * @param obj
	 * @param f
	 * @param rawObj
	 * @param annotation
	 * @param names
	 */
	private static void i18nTypeProcess(Object obj, Field f, Object rawObj, UColumns annotation, List<MemberName> names) {
		try {
			// ó���� Raw �ʵ带 ���Ѵ�.
			Field rawField = readRawFieldInfo(rawObj, annotation);
			if (null == rawField) {
				return;
			}
			
			// ���� Ŭ������ �ʵ忡 ������ �����Ѵ�.
			Map<Locale, String> nameMap = new HashMap<>();					
			for (MemberName name : names) {
				String[] arr = name.getLocale().split("_");
				nameMap.put(new Locale(arr[0], arr[1]), name.getName());
			}
			
			Member member = (Member)rawObj;
			I18nName i18nName = new I18nName(member.getId(), nameMap);
			
			f.setAccessible(true);
			f.set(obj, i18nName);				

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

	
	/**
	 * ENUM Ÿ���� �÷��� ���� ó���Ѵ�.
	 * 
	 * @param obj
	 * @param f
	 * @param rawObj
	 * @param annotation
	 */
	private static void enumTypeProcess(Object obj, Field f, Object rawObj, UColumns annotation) {
		try {
			// ó���� Raw �ʵ带 ���Ѵ�.
			Field rawField = readRawFieldInfo(rawObj, annotation);
			if (null == rawField) {
				return;
			}
			
			// ���� Ŭ������ �ʵ忡 ������ �����Ѵ�.
			if ("status".equals(annotation.mappedBy()) && annotation.castClass() == Status.class) {
				String fieldValue = (String)rawField.get(rawObj);
				
				Status memberStatus = Status.DEL;
				for (Status status : Status.values()) {
					if (status.getId().equals(fieldValue)) {
						memberStatus = status;
					}
				}
				
				f.setAccessible(true);
				f.set(obj, memberStatus);
				
				return;				
			}				

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		log.error("[@ImColumns] ���������ʴ� DataType�� �����մϴ�. (mappedBy:{})", annotation.mappedBy());
	}
	
	
	
	/**
	 * Raw Class ���� �� ó���� Raw Field ������ �����Ѵ�. 
	 * @param rawObj
	 * @param annotation
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static Field readRawFieldInfo(Object rawObj, UColumns annotation) {
		
		Class rawKlass = rawObj.getClass();
		
		for (Field field : rawKlass.getDeclaredFields()) {
			
			field.setAccessible(true);
			if (!annotation.mappedBy().equals(field.getName())) {
				continue;
			}
			
			return field;				
		}
		
		return null;
	}
	
	
}











