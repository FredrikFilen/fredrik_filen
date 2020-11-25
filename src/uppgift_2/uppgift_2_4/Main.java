package uppgift_2.uppgift_2_4;

public class Main {

	public static void main(String[] args) {
		Matte matte = new Matte("Felicia");
		Katt katt = new Katt("Misse", "Skogskatt");
		katt.setOwner(matte);
		katt.getOwner();

	}

}
