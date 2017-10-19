package arrays;

public class Hobby extends Thing {

	public Hobby(String description) {
		super(description);
	}

	public static Hobby randomHobby() {
		Hobby[] h = {new Hobby("Playing Video Games"),
				new Hobby("Playing Footy"),
				new Hobby("Playing Basketball"),
				new Hobby("Dancing"),
				new Hobby("Eating"),
		};
		return h[(int)(Math.random() * h.length)];
	}

}
