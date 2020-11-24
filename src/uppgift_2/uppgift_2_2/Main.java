package uppgift_2.uppgift_2_2;

public class Main {

	public static void main(String[] args) {
		Katt katt = new Katt("Nisse", "Skogskatt");
		Matte matte = new Matte("Sara", katt);

		System.out.println(matte.getKatt());

	}

}
