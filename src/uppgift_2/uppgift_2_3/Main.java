package uppgift_2.uppgift_2_3;

public class Main {

	public static void main(String[] args) {
		Husse husse = new Husse("erik");

		husse.buyDog(new Hund("nisse", "dalmatin"));
		husse.buyDog(new Hund("asdasd", "schäfer"));
		husse.buyDog(new Hund("lol", "katthund"));

		husse.getName();
		husse.showDogs();
	}

}
