package co.simplon.entities;

public class User {
	private int IdCust;
	private String nameUser;
	private String passwordUser;
	public User(int IdCust,String nameUser,String passwordUser) {
		this.IdCust=IdCust;
		this.nameUser=nameUser;
		this.passwordUser=passwordUser;
	}
	public User(String nameUser,String passwordUser) {
		this.nameUser=nameUser;
		this.passwordUser=passwordUser;
	};
	public int getIdCust() {
		return IdCust;
	}
	@Override
	public String toString() {
		return "User [IdCust=" + IdCust + ", nameUser=" + nameUser + ", passwordUser=" + passwordUser + "]";
	}
	public void setIdCust(int idCust) {
		IdCust = idCust;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	
}
