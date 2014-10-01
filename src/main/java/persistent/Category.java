package persistent;

import pl.btbw.core.annotation.ValueOverride;

public class Category {

	@ValueOverride(key = "NAME")
	private String name;

	@ValueOverride(key = "DESCRIPTION")
	private String description;

	public Category() {
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Category{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
