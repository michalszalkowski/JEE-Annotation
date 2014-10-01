package persistent;

import pl.btbw.core.annotation.BtbwText;

public class Post {

	@BtbwText(someText = "Lorem ipsum dolor sit amet.")
	private String name;

	public Post() {
	}

	public String getName() {
		return name;
	}

}