package caveExplorer;

public class NPC {

	//fields needed to program navigation
	private CaveRoom[][] floor; //area where NPC roams
	private int currentRow;
	private int currentCol;
	private NPCRoom currentRoom;
	
	//these fields are about interaction with NPC
	private boolean active;
	private String activeDescription;
	private String inactiveDescription;
	//you might later add fields to make your NPC behave like a chatbot
	
	//default
	public NPC() {
		this.floor = CaveExplorer.caves;
		this.activeDescription = "There is a person standing in the room "
				+ "waiting to talk to you. Press 'e' to talk.";
		this.inactiveDescription = "The person you spoke to earlier is "
				+ "standing here.";
		//by default, NPC does not have a position,
		//to indicate this, use coordinates -1, -1
		this.currentCol = -1;
		this.currentRow = -1;
		currentRoom = null;
		active = true;
	}

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	public void interact() {
		// TODO Auto-generated method stub
		
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getInactiveDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSymbol() {
		// TODO Auto-generated method stub
		return null;
	}

}
