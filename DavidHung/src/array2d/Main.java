package array2d;

public class Main {

	public static void main(String[] args) {
		Array2DSampler test = new Array2DSampler();
	}
	/**
	 * PRECONDITION: i>= 0 and i <arr.length
	 * increases the element at i by 1
	 * decreases the elements at i - 1 and i + 1, if they exist
	 * AVOIDS ArrayIndexOutOfBoundsEXCEPTION
	 * THIS IS SUCH A HEAVILY TETSED CONCEPT,
	 * on every exam, you should always be in the habit of checking 
	 * ArrayIndexOutOfBoundsExceptions
	 * Trust me, don't be that guy who lost a million points 
	 * @param arr
	 * @param i
	 */
	private static void changeNeighbors(int[] arr, int i) {
		if(i < arr.length) {
			arr[i] = arr[i] + 1;
		}
		if(i >= 1) {
			arr[i-1] = arr[i] - 1;
		}
		if(i <= arr.length - 2) {
			arr[i-1] = arr[i] - 1;
		}
	}

}
