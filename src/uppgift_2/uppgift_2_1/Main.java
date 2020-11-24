package uppgift_2.uppgift_2_1;

public class Main {

	public static void main(String[] args) {
		Katt katt = new Katt("Rufus", "Nakenkatt");
		Hund hund = new Hund("Gromit", "Beagle");

		System.out.println(katt.getName());
		System.out.println(katt.getRace());

		System.out.println(hund.getName());
		System.out.println(hund.getRace());
	}

}
