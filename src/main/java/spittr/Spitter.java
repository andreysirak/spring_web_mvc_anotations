package spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.Length;

public class Spitter {

	private Long id;
	
	//@NotEmpty
	//@Length(min = 5, max = 16)
	@NotNull
	@Size(min = 5, max = 16)
	private String username;

	@NotNull
	@Size(min = 5, max = 25)
	private String password;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String firstName;
	
	@NotNull
	@Size(min = 2, max = 30)
	private String lastName;
	
	public Spitter () {
	
	}	
	
	public Spitter(
			Long id, 
			@NotNull @Size(min = 5, max = 16) String username,
			@NotNull @Size(min = 5, max = 25) String password, 
			@NotNull @Size(min = 2, max = 30) String firstName,
			@NotNull @Size(min = 2, max = 30) String lastName) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Spitter(
			@NotNull @Size(min = 5, max = 16) String username, 
			@NotNull @Size(min = 5, max = 25) String password,
			@NotNull @Size(min = 2, max = 30) String firstName, 
			@NotNull @Size(min = 2, max = 30) String lastName) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "Spitter [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
	
	
}
