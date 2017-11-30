package algorithms;

public class LionsPuzzle {

	public static void main(String[] args) {
		int numberOfLions = 101;
		if(willEat(numberOfLions)) {
			System.out.println("Eat the sheep!");
		}
		else {
			System.out.println("Do not eat the sheep!");
		}
	}

	private static boolean willEat(int numberOfLions) {
		//base case is one lion and should ALWAYS be TRIVIAL
		if(numberOfLions == 1) {
			return true;
		}
		else {
			return !willEat(numberOfLions - 1);
		}
	}

}
	