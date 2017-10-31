package caveExplorer;

public class NPCRoom extends CaveRoom {
	
	private NPC npc;

	public NPCRoom(String description) {
		super(description);
	}
	
	public boolean canEnter() {
		return npc == null;
	}
	
	public void enterNPC(NPC n) {
		this.npc = n;
	}
	
	public void leaveNPC() {
		this.npc = null;
	}
	
	public boolean containsNPC() {
		return npc != null;
	}

}
