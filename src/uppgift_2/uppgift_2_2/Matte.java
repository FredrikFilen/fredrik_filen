package uppgift_2.uppgift_2_2;

public class Matte {
	String name = "";
	Katt katt;

	Matte(String name, Katt katt) {
		this.name = name;
		this.katt = katt;

	}

	String GetName() {
		return name;
	}

	Katt GetKatt() {
		return katt;
	}
}
