package beans;

public class BeanUser {
	private String login;
	private String password;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean valiadte(String login, String senha) {
		
		return login.equalsIgnoreCase("admin") ? true : false;
		
			
	}
	
	
	
	

}