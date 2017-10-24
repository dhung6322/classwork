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
		boolean doorFound = true;
		for(int i = 0; i < doors.length; i++) {
			if(doors[i] != null) {
				doorFound = true;
				directions += "There is a " + doors[i].getDescription() + "to " + toDirections(i) + ". " +
				doors[i].getDetails() + "\n";
			}
		}
		if(!doorFound) {
			directions = "There is no way out. You are trapped in this room";
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
	
	public void enter() {
		contents = "X";
	}
	
	public void leave() {
		contents = defaultContents;
	}
	/**
	 * This is how we join rooms together
	 * It gives this room access to anotherRoom and vice-versa
	 * It also puts the door between both rooms
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	public void addRoom(int dir, CaveRoom caveRoom, Door door) {
		borderingRooms[dir] = caveRoom;
		doors[dir] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a' , 's', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		int direction = "wdsa".indexOf(input);
		goToRoom(direction);
	}
	/**
	 * returns true if w,a,s, or d is the input but no if statements
	 * @param input
	 * @return
	 */
	private boolean isValid(String input) {
		return "wdsa".indexOf(input) > -1 && input.length() == 1;
		}
	/**
	 * THIS IS WHERE YOU EDIT YOUR CAVES
	 */
	public static void setUpCaves() {
		
	}
	
	public void goToRoom (int direction) {
		//make sure there is a room to go to:
		if(borderingRooms[direction] != null && doors[direction] != null &&
				doors[direction].isOpen()) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		} 
		else {
			//prints red text
			System.err.println("You can't do that!");
		}
	}
	
	/**
	 * returns the OPPOSITE direction
	 * @param dir
	 * @return
	 */
	public static int oppositeDirection(int dir) {
		int[] opposite = {2,3,0,1};
		return opposite[dir];
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