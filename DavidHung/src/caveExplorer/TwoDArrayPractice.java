package caveExplorer;

public class TwoDArrayPractice {

	public static void main(String[] args) {
		String[][] pic = new String[6][10];
		for(String[] row: pic) {
			for(int col = 0; col < row.length; col++) {
				row[col] = " ";
			}
		}
		drawHorizontalLine(pic, 2);
		drawVerticalLine(pic,3);
		drawSlot(pic, 4,6);
		print(pic);
	}
	/**
	 * A slot looks like this:
	 *       | |
	 * The coordinates of the slot are where the space between the two vertical lines is found. In other words,
	 * there is a vertical line to the left of (i,j) and a vertical line to the right of (i,j)
	 * CATCH: NO Array IndexOutOfBoundsExceptions
	 * @param pic
	 * @param i
	 * @param j
	 */
	private static void drawSlot(String[][] pic, int i, int j) {
		
	}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int i = 0; i < pic.length; i++) {
			pic[i][col] = "|";
		}
		
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		for(int i = 0; i < pic[row].length; i++) {
			pic[row][i] = "-";
		}
	}
	
	/**
	 * write a method that prints every string in the pic,
	 * not separated by arrays and no brackets
	 * @param pic
	 */
	private static void print(String[][] pic) {
		for(int row = 0; row < pic.length; row++) {
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println("");
		}
	}

}
