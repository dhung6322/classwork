package chatbot;

public class chatbot {
	
	private String username;
	private boolean chatting;
	private Topic david;
	
	public chatbot() {
		david = new DavidBookBot();
		username = "Unknown User";
		chatting = true;
	}
	public void StartChatting() {
		//whenever you print or get input, use ChatbotMain
		ChatbotMain.print("Hi! I am an intelligent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("I know a lot about entertainment. What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(david.isTriggered(response)) {
				chatting = false;//exits the while loop. IMPORTANT you get graded for this!
				david.talk(response);
			}
			else {
				ChatbotMain.print("Im sorry but that is not something I know about.");
			}
		}
		
	}
}
