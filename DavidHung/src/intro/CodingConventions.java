package intro;

public class CodingConventions
{	
	// FIELDS ARE AT THE TOP 
	private String name; 
	private String description;
	public CodingConventions(String name, int descriptionIndex)
	{
		//there are two variables called name. local and field
		//distinguish between the two by using the word THIS 
		this.name = name;
		description = IntroMain.DESCRIPTIONS[descriptionIndex];
		/*
			this is a constructor. it is like a method except the return type 
	  		is the instance of the class for this reason, a constructor must ALWAYS be 
	  		named after the class	
		*/
	}
	//normal method "void" is the return type 
	public void doStuff()
	{
		//static method call
		String output = name + description; // use spaces in between operations like so 1 + 1 =2
		System.out.println(output);
	}
}
