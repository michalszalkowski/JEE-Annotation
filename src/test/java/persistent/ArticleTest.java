package persistent;

import org.junit.Test;
import pl.btbw.core.MapObject;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class ArticleTest {

	private MapObject object = new MapObject();

	@Test
	public void testName() throws Exception {



		Map<String, Object> category = new HashMap<>();
		category.put("NAME", "category no 1");
		category.put("DESCRIPTION", "category long description");

		Map<String, Object> article = new HashMap<>();
		article.put("NAME", "article no 1");
		article.put("DESCRIPTION", "article long description");
		article.put("CATEGORY", category);

		Article obj = object.update(new Article(), article);

		assertThat(obj.getName()).isEqualTo("article no 1");
		assertThat(obj.getDescription()).isNull();
		assertThat(obj.getCategory().getName()).isEqualTo("category no 1");
		assertThat(obj.getCategory().getDescription()).isEqualTo("category long description");
	}
}