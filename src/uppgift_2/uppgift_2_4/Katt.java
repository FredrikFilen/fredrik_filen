package uppgift_2.uppgift_2_4;

public class Katt {
	private String name = "";
	private String race = "";
	private Matte matte;

	Katt() {
		this.name = name;
		this.race = race;
	}

	void setOwner(Matte matte) {
		this.matte = matte;
	}

	void getOwner() {
		System.out.println("min ägare är: " + matte);
	}
}
