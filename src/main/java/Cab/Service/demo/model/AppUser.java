package Cab.Service.demo.model;

public class AppUser {

	private String email;
	private String password;

	public AppUser() {

	}

	public AppUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AppUser [email=" + email + ", password=" + password + "]";
	}

}
