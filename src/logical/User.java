package logical;

public abstract class User {
	private String email, firstname, lastname;
	
	public User(String email, String firstname, String lastname){
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public User(String email) {
		this.email = email;
	}
}