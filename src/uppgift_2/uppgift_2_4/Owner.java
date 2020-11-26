package uppgift_2.uppgift_2_4;

import uppgift_2.uppgift_2_2.Katt;
import uppgift_2.uppgift_2_3.Hund;

public class Owner {
	String name = "";
	Katt katt;
	Hund hund;

	String getName() {
		return name;
	}

	Katt getKatt() {
		return katt;
	}

	Hund getHund() {
		return hund;
	}
}
