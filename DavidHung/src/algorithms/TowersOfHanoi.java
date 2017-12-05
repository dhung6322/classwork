package algorithms;

public class TowersOfHanoi {

	public static void main(String[] args) {
		hanoi(7,"a","b","c");
	}
	
	public static void hanoi(int n, String start, String help, String end) {
		if(n == 1) {
			System.out.println(start + " to " + end);
		}
		else {
			hanoi(n-1,start,help,end);
			System.out.println(start + " to " + end);
			hanoi(n-1,help,start,end);
		}
	}

}
