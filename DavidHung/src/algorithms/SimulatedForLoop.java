package algorithms;

public class SimulatedForLoop {
	
	public static void main(String[] args) {
		forLoop(10, new Action() {
			
			int count = 1;
			
			public void act() {
					System.out.println(count + ".Hello world!");
					count++;
			}
		});
	}
	
	public static void forLoop(int n, Action a) {
		
	}
}
