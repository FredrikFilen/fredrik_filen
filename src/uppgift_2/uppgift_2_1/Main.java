package uppgift_2.uppgift_2_1;

public class Main {

	public static void main(String[] args) {
		Katt katt = new Katt("Rufus", "Nakenkatt");
		Hund hund = new Hund("Gromit", "Beagle");

		System.out.println(katt.GetName());
		System.out.println(katt.GetRace());

		System.out.println(hund.GetName());
		System.out.println(hund.GetRace());
	}

}
