package uppgift_2.uppgift_2_1;

public class Main {

	public static void main(String[] args) {
		Katt katt = new Katt("Rufus", "Nakenkatt");
		Hund hund = new Hund("Gromit", "Beagle");

		katt.getName();
		katt.getRace();

		hund.getName();
		hund.getRace();
	}

}
