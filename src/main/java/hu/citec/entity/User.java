package hu.citec.entity;

public class User {

	private Integer userId;
	private String username;
	private String password;
	private String email;
	private String adress;

	public User() {

	}

	public User(Integer userId, String username, String password, String email, String adress) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.adress = adress;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	

	
}
