package uppgift_2.uppgift_2_3;

import java.util.ArrayList;

public class Husse {
	private String name = "";
	private ArrayList<Hund> hundar = new ArrayList<Hund>();

	Husse(String name) {
		this.name = name;
	}

	void buyDog(Hund hund) {

		hundar.add(hund);
	}

	void getName() {
		System.out.println("jag heter " + name);
	}

	void showDogs() {
		for (int i = 0; i < hundar.size(); i++) {
			hundar.get(i).getName();
		}
	}
}
