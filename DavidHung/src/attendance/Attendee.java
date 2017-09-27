package attendance;

public interface Attendee {

	/**In addition to the following methods, please create a class called 
	 * 'Student' that implements the Attendee interface and include a 
	 * constructor that takes two parameters: firstName and lastName.
	 * Use these values to instantiate corresponding fields.
	 * @return
	 */
	
	//returns true if the student has been marked present, false otherwise
	boolean isPresent();

	//sets whether the student has been marked present
	void setPresent(boolean present);

	//returns the firstName
	String getFirstName();

	//returns the lastNameName
	String getLastName();

	//returns true if 'first' and 'last' match this Attendee's firstName and lastName. This should NOT be case sensitive. 
	boolean matches(String first, String last);

	
	//returns true if 'first' matches this Attendee's firstName. This should NOT be case sensitive.
	boolean matches(String last);

	//returns three words separated by 20 spaces: 
	//at index 0, the last name
	//at index 20, the first name
	//at index 40, the word PRESENT or ABSENT
	//ADDED CHALLENGE:
	//if last name or first name is longer than 20 characters, 
	//cut off the last three letters and replace with "..."
	String getReportString();	
}

public class Student implements Attendee{
	private String first;
	private String last;
	private String present
	public Student("String firstName, String lastName"){
		this.first = firstName;
		this.last = lastName;
		this.present = ABSENT; 
	}
	public boolean isPresent(){
		if(indexOf("P")== "40"{
			return true;	
		}
		else{
			return false;
		}
	public void setPresent(boolean present){
		this.present = PRESENT;
	}
	public String getFirstName(){
		return this.first;
	}
	public String getLastName(){
		return this.last;
	}
	public boolean matches(String first, String last){
		
	}
	public boolean matches(String last){
		
	}
	public getReportString(){
		while(this.first.length < 20){
			this.first += " ";
		}
		this.first += this.last;
		while(this.first < 40){
			this.first += " ";
		}
		this.first += this.present;
	}
}
