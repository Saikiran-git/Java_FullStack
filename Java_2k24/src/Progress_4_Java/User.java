package Progress_4_Java;

public abstract class User {
    protected String username;
    protected String password;
    protected String userType;

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType; // User Can be client or visitor
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
	
	public String getUserType() {
        return userType;
    }

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
