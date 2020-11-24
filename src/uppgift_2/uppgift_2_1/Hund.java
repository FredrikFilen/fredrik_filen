package uppgift_2.uppgift_2_1;

public class Hund {
	private String name = "";
	private String race = "";

	Hund(String name, String race) {
		this.name = name;
		this.race = race;
	}

	String getName() {
		return name;
	}

	String getRace() {
		return race;
	}
}
