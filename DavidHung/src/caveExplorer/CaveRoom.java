package caveExplorer;

public class CaveRoom {
	
	private String description;
	private String directions; // tells you which door can be used
	private String contents; //a symbol showing you what is in the room ('X' when you are in the room)
	private String defaultContents; //what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	private static final int NORTH = 0;
	private static final int EAST = 1;
	private static final int SOUTH = 2;
	private static final int WEST = 3;
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
	/**
	 * for every Door in doors[] that is not null,
	 * this method appends a String to 'descriptions' describing the door and where it is 
	 * for example: 
	 * 		There is a (passage) to (the North)
	 * 		There is a (passage) to (the East)
	 * If there are no doors that are not null, this sets directions to 
	 * 		"There is no way out. You are trapped in this room."
	 */
	public void setDirections() {
		//hint: to check if a door is null use:
		//doors[0] = null OR USE doors[0] != null;
		directions = "";
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				directions += "There is a passage to " + toDirections(i) + ".";
			}
				directions += "There is no way out. You are trapped in this room";
		}
	}
	/**
	 * converts an int to a direction:
	 * 0 -> "the North"
	 * 1 -> "the East"
	 * hint: complete this method w/o using and if statement
	 * @param dir
	 * @return
	 */
	public static String toDirections(int dir) {
		String[] direction = {"the North","the East","the South","the West"};
		//NOTE: when I say "no long if=else" statements,
		//this is how you should be thinking
		return direction[dir];
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
