package algorithms;

public class Fibonacci {

	public static void main(String[] args) {
		
	}
	
	public int fib(int n) {
		if(n <= 1) {
			return 1;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}

}
