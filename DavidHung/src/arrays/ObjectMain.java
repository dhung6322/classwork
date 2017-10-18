package arrays;

public class ObjectMain {

	public ObjectMain() {
		Person[] people = new Person[14];
		populate(people);
		for(Person p: people) {
			System.out.println(p);
		}
	}

	private void populate(Person[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START,
					Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START,
					Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			people[i]= new Person(firstName,lastName,home);
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random() * Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		return a[(int)(Math.random() * a.length)];
	}

	public static void main(String[] args) {
		ObjectMain obj = new ObjectMain();

	}

}
