package caveExplorer;

public class CaveRoom {
	
	private String description;
	private String directions; // tells you which door can be used
	private String contents; //a symbol showing you what is in the room ('X' when you are in the room)
	private String defaultContents; //what is in the room when you aren't in the room
	
	private Caveroom[] borderingRooms;
	private Door[] doors;
	
	//constants
	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;
	
	public CaveRoom() {
		// TODO Auto-generated constructor stub
	}

}
