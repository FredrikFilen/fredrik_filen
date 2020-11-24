package uppgift_2.uppgift_2_2;

public class Matte {
	String name = "";
	Katt katt;

	Matte(String name, Katt katt) {
		this.name = name;
		this.katt = katt;

	}

	String getName() {
		return name;
	}

	Katt getKatt() {
		return katt;
	}
}
