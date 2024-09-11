package generated;


public class Teacher {
	private String firstName;
	private String lastName;
	private String course;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAge() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Teacher [firstName=" + firstName + ", lastName=" + lastName
				+ ", course=" + course + "]";
	}
	
	
}
