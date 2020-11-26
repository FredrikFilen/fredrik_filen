package uppgift_2.uppgift_2_4;

public class Katt extends Animal {
	private Matte matte;

	Katt(String name, String race) {
		this.name = name;
		this.race = race;
	}

	void setOwner(Matte matte) {
		this.matte = matte;
	}

	void getOwner() {
		System.out.println("min ägare är: " + matte.getName());
	}
}
