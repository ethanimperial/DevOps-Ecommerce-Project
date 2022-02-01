package ec.ecommerce.model;

public class User {
	
	public User(String name, String password, String email, String phonenumber, int id) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		this.id = id;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	protected String name;
	 protected String password;
	 protected String email;
	 protected String phonenumber;
	 protected int id;


}
