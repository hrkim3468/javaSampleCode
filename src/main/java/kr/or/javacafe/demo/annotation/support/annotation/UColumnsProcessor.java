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
	 * SmartUserVO 객체를 생성한다.
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

					// UType 따라서 처리를 분기한다.
					if (UType.BASIC.equals(col.type())) {
						basicTypeProcess(obj, f, rawObj, col);
						
					} else if (UType.I18N_TYPE.equals(col.type())) {
						i18nTypeProcess(obj, f, rawObj, col, names);
						
					} else if (UType.ENUM_TYPE.equals(col.type())) {
						enumTypeProcess(obj, f, rawObj, col);
						
					} else {
						log.error("@UColumns Annotation에 알수없는 타입이 지정되었습니다. (" + col.toString() + ")");
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
	 * BAISC 타입의 컬럼을 맵핑 처리한다.
	 * 
	 * @param obj
	 * @param f
	 * @param rawObj
	 * @param annotation
	 */
	private static void basicTypeProcess(Object obj, Field f, Object rawObj, UColumns annotation) {
		try {
			// 처리할 Raw 필드를 구한다.
			Field rawField = readRawFieldInfo(rawObj, annotation);
			if (null == rawField) {
				return;
			}
			
			// 생성 클래스의 필드에 정보를 저장한다.
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
		
		log.error("[@UColumns] 지원하지않는 DataType이 존재합니다. (mappedBy:{})", annotation.mappedBy());
	}

	
	/**
	 * I18N 타입의 컬럼을 맵핑 처리한다.
	 * 
	 * @param obj
	 * @param f
	 * @param rawObj
	 * @param annotation
	 * @param names
	 */
	private static void i18nTypeProcess(Object obj, Field f, Object rawObj, UColumns annotation, List<MemberName> names) {
		try {
			// 처리할 Raw 필드를 구한다.
			Field rawField = readRawFieldInfo(rawObj, annotation);
			if (null == rawField) {
				return;
			}
			
			// 생성 클래스의 필드에 정보를 저장한다.
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
	 * ENUM 타입의 컬럼을 맵핑 처리한다.
	 * 
	 * @param obj
	 * @param f
	 * @param rawObj
	 * @param annotation
	 */
	private static void enumTypeProcess(Object obj, Field f, Object rawObj, UColumns annotation) {
		try {
			// 처리할 Raw 필드를 구한다.
			Field rawField = readRawFieldInfo(rawObj, annotation);
			if (null == rawField) {
				return;
			}
			
			// 생성 클래스의 필드에 정보를 저장한다.
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
		
		log.error("[@ImColumns] 지원하지않는 DataType이 존재합니다. (mappedBy:{})", annotation.mappedBy());
	}
	
	
	
	/**
	 * Raw Class 정보 중 처리할 Raw Field 정보를 추출한다. 
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











