package uppgift_2.uppgift_2_3;

import java.util.ArrayList;

public class Husse extends Owner {

	private ArrayList<Hund> hundar = new ArrayList<Hund>();

	Husse(String name) {
		this.name = name;
	}

	void buyDog(Hund hund) {

		hundar.add(hund);
	}

	void showDogs() {
		for (int i = 0; i < hundar.size(); i++) {
			hundar.get(i).getName();
		}
	}
}
