package uppgift_5;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

//Encoder and decoder
public class XML {
	public static void encode(ArrayList<User> userlist) {

		XMLEncoder encoder = null;

		try {
			encoder = new XMLEncoder(new FileOutputStream((new File("./src/uppgift_5/Assets/users.xml"))));
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Error: while creating or openeing the file users.xml");
		}

		encoder.writeObject(userlist);
		System.out.println("Write sucessful");

		encoder.close();

	}

	public static ArrayList<User> decode() {

		ArrayList<User> userlist = new ArrayList<User>();
		XMLDecoder decoder = null;

		try {
			decoder = new XMLDecoder(new FileInputStream((new File("./src/uppgift_5/Assets/users.xml"))));
			System.out.println("File stream opened and XMLDecoder created");

			userlist = (ArrayList<User>) decoder.readObject();

			System.out.println("Read successful from users.xml");

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File users.xml not found");

		} finally {
			if (decoder != null) {
				decoder.close();
				System.out.println("decoder closed");

			}

		}

		return userlist;
	}
}
