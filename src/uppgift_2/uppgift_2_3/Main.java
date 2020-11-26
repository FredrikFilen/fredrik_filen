package uppgift_2.uppgift_2_3;

public class Main {

	public static void main(String[] args) {
		Husse husse = new Husse("Erik");

		husse.buyDog(new Hund("Nisse", "dalmatin"));
		husse.buyDog(new Hund("Brutus", "schäfer"));
		husse.buyDog(new Hund("Derp", "katthund"));

		System.out.println(husse.getName());
		husse.showDogs();
	}

}
