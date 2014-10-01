package pl.btbw.core;

import pl.btbw.core.annotation.ObjectOverride;
import pl.btbw.core.annotation.ValueOverride;

import java.lang.reflect.Field;
import java.util.Map;

public class MapObject {

	public <T> T update(T obj, Map<String, Object> data) throws IllegalAccessException {

		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {

			if (field.isAnnotationPresent(ValueOverride.class)) {
				ValueOverride annotation = field.getAnnotation(ValueOverride.class);
				String value = (String) data.get(annotation.key());
				field.setAccessible(true);
				field.set(obj, value);
				field.setAccessible(false);
			}

			if (field.isAnnotationPresent(ObjectOverride.class)) {
				ObjectOverride annotation = field.getAnnotation(ObjectOverride.class);
				Map<String, Object> newData = (Map<String, Object>) data.get(annotation.key());
				field.setAccessible(true);
				field.set(obj, update(field.get(obj), newData));
				field.setAccessible(false);
			}
		}

		return obj;
	}

}
