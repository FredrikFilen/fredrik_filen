package uppgift_2.uppgift_2_1;

public class Katt {
	private String name = "";
	private String race = "";

	Katt(String name, String race) {
		this.name = name;
		this.race = race;
	}

	String GetName() {
		return name;
	}

	String GetRace() {
		return race;
	}
}
