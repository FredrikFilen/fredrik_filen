package uppgift_4;

import java.io.Serializable;
//objekt som skall serialiseras skall ha private variabler, konstruktor utan parametrar och getters och setters.

//bör skaffa ett serialVersionUID, kolla upp hur
public class Person implements Serializable {
	private String firstName;
	private String lastName;
	private String age;

	Person() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
