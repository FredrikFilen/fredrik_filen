package uppgift_2.uppgift_2_3;

public class Hund {
	private String name = "";
	private String race = "";

	Hund(String name, String race) {
		this.name = name;
		this.race = race;
	}

	void getName() {
		System.out.println(name);
	}

	void getRace() {
		System.out.println(race);
	}
}
