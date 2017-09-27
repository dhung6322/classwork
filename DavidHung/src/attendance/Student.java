package attendance;

public class Student implements Attendee {
	private String first;
	private String last;
	private boolean present;
	
	public Student(String firstName, String lastName){
		this.first = firstName;
		this.last = lastName;
		present = false; 
	}
	public boolean isPresent(){
		return present;
	}
	public void setPresent(boolean present) {	
		this.present = present;
	}
	public String getFirstName(){
		return first;
	}
	public String getLastName(){
		return last;
	}
	public boolean matches(String first, String last) {
		return first.toLowerCase().equals(first.toLowerCase()) && last.toLowerCase().equals(last.toLowerCase());
	}
	public boolean matches(String last) {
		return last.toLowerCase().equals(last.toLowerCase());
	}
	public String getReportString() {
		while(this.first.length() < 20){
			this.first += " ";
		}
		this.first += this.last;
		while(this.first.length() < 40){
			this.first += " ";
		}
		return this.first += this.present;
	}
}
