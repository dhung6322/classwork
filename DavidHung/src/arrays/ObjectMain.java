package arrays;

public class ObjectMain {

	public ObjectMain() {
		Object[] people = new Object[14];
		populate(people);
		people[0] = new Thing("toaster oven");
		for(Object p: people) {
			System.out.println(p);
		}
	}

	private void populate(Object[] people) {
		for(int i = 0; i < people.length; i++) {
			String firstName = randomNameFrom(Person.FIRST_START,
					Person.FIRST_MIDDLE, Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START,
					Person.LAST_MIDDLE, Person.LAST_END);
			Borough home = randomBorough();
			//BIG IDEA:
			//In an Object array, you can have multiple data types
			//unlike a primitive array
			if(Math.random() < .6) {
				int money = (int)(Math.random() * 100 + 1)*100000;
				people[i] = new Athlete(firstName, lastName,home, money);
			}
			else {
			people[i]= new Person(firstName,lastName,home);
			}
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
