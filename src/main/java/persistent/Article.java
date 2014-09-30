package persistent;

import pl.btbw.core.RestOverride;

public class Article {

	@RestOverride
	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
