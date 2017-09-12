package intro;

public class IntroMain 
{
	public static final String[] DESCRIPTIONS = {" is a teacher at BTHS", " is a student at BTHS"};
	
	//this is the first method that is executed. Static = independent of instances
	public static void main(String[] args)
	{
		
		
		int numberOfPeople = 10;
		for(int i =0; i < numberOfPeople; i++){
			{
				CodingConventions conventionsInstance = new CodingConventions("David Hung", i%2);
				conventionsInstance.doStuff();
				/*
					instance method call (the method belongs to the instance, not the class)
				*/
			}
		}
		/*
			this is the declaration of an instance of CodingConventions
			in the same line of code, it is also being instantiated 
			NOTE the use of the word new; 
			this word is ALWAYS used when calling constructors
			a note on local variables;
			they are NOT FIELDS (HAS-A relationships) 
			they are variables that are only used in the scope of a method
			after the method, they are destroyed 
		*/
	
	}
}
