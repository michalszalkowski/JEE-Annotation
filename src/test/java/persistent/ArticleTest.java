package persistent;

import org.junit.Test;
import pl.btbw.core.RestOverride;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class ArticleTest {

	@Test
	public void testName() throws Exception {

		Article obj = new Article();

		Map<String, String> dataFromRest = new HashMap<>();
		dataFromRest.put("name", "article no 1");
		dataFromRest.put("description", "article long description");

		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(RestOverride.class)) {
				String s = dataFromRest.get(field.getName());
				field.setAccessible(true);
				field.set(obj, s);
				field.setAccessible(false);
			}
		}

		assertThat(obj.getName()).isEqualTo("article no 1");
		assertThat(obj.getDescription()).isNull();
	}
}