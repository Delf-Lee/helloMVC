package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

 public class Customer {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String email;
	
	public boolean isPasswordCorrect(String password) {
		return this.password.equals(password);
	}
}