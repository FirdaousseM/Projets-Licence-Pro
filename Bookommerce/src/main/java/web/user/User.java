package web.user;
import java.util.HashMap;

import web.Model;


public class User extends Model{

	private String username; // varchar : 64
	private String email; // varchar : 128 
	private String password; // varchar : 128
	private String firstname; // varchar : 32
	private String lastname; // varchar : 32
	private String phone; // varchar : 32
	private String address; // varchar : 256
	
	public User() {
		super();
	}
	
	public User(HashMap<String, String> values) {
		super(values.get("user-id"));
		
		this.username = values.get("user-username");	
		this.email = values.get("user-email");	
		this.password = values.get("user-password");	
		this.firstname = values.get("user-firstname");	
		this.lastname = values.get("user-lastname");	
		this.phone = values.get("user-phone");	
		this.address = values.get("user-address");	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
}

