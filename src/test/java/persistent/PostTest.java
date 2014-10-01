package persistent;

import org.junit.Test;
import pl.btbw.core.annotation.BtbwText;

import java.lang.reflect.Field;

import static org.fest.assertions.Assertions.assertThat;

public class PostTest {

	@Test
	public void testBtbwTextAnnotation() throws IllegalAccessException {

		Post obj = new Post();

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(BtbwText.class)) {
				field.setAccessible(true);
				BtbwText annotation = field.getAnnotation(BtbwText.class);
				field.set(obj, annotation.someText());
				field.setAccessible(false);
			}
		}
		assertThat(obj.getName()).isEqualTo("Lorem ipsum dolor sit amet.");
	}


}