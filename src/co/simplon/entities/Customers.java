package co.simplon.entities;

public class Customers {
	private int IdCust;
	private String Name;
	private String FirstName;
	
	public Customers(int IdCust, String Name, String FirstName) {
		this.IdCust = IdCust;
		this.Name = Name;
		this.FirstName = FirstName;
	}

	@Override
	public String toString() {
		return "Customers [IdCust=" + IdCust + ", Name=" + Name + ", FirstName=" + FirstName + "]";
	}

	public int getIdCust() {
		return IdCust;
	}

	public void setIdCust(int IdCust) {
		this.IdCust = IdCust;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}	
}