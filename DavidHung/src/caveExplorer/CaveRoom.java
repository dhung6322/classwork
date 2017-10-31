package caveExplorer;

public class CaveRoom {
	
	private String description;
	private String directions; // tells you which door can be used
	private String contents; //a symbol showing you what is in the room ('X' when you are in the room)
	private String defaultContents; //what is in the room when you aren't in the room
	
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
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
				directions += "There is a " + doors[i].getDescription() + " to " + toDirections(i) + ". " +
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
	 * THIS IS WHERE YOU EDIT YOUR CAVES (change to incorporate NPCs?)
	 */
	public static void setUpCaves() {
		//1. Determine size of Caves
		CaveExplorer.caves = new CaveRoom[5][5];
		CaveRoom[][] c = CaveExplorer.caves; //create a shortcut for accessing CaveExplorer.caves
		//2. Populate with default caves
		for(int row = 0; row < c.length; row++) {
			for(int col = 0; col < c[row].length; col++) {
				c[row][col] = new CaveRoom("This cave has coordinates " + row +", " + col);
			}
		}
		//3. Replace some default rooms with custom rooms (SAVE FOR LATER)
		
		//4. Set starting room
		CaveExplorer.currentRoom = c[0][1];
		CaveExplorer.currentRoom.enter();
		
		//5. Set up doors
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		c[1][1].setConnection(EAST, c[1][2], new Door());
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
	public Door getDoor(int directions) {
		return doors[directions];
	}

}
