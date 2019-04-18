package co.simplon.entities;

import java.sql.Date;
import java.util.ArrayList;
import co.simplon.entities.*;
public class Accounts {
    private int NumCt;
    private Date DateCreation;
    private int Balance;
    private int IdCust;
    public static ArrayList<Operations> getListOperations() {
		return ListOperations;
	}
	public static void setListOperations(ArrayList<Operations> listOperations) {
		ListOperations = listOperations;
	}



	private String type;
    private int NumCt2;
    public static ArrayList<Operations> ListOperations=new ArrayList<Operations>();
    protected static Customers Customers;
    public Accounts(int numCpte, Date date,int Balance,String type, int IdCust) {
        this.NumCt = numCpte;
        this.DateCreation = date;
        this.Balance = Balance;
        this.type=type;
        this.IdCust = IdCust;
        
        
        
    }
    public Accounts(int numCpte,int Balance, int IdCust) {
        this.NumCt = numCpte;
        
        this.Balance = Balance;
        this.IdCust = IdCust;
        
    }
    public Accounts(int numCpte,int IdCust) {
        this.NumCt = numCpte;
        
        
        this.IdCust = IdCust;
        
    }


    public int getNumCt() {
        return NumCt;
    }
    public void setNumCt(int numCt) {
        this.NumCt = numCt;
    }
    public Date getDateCreation() {
        return this.DateCreation;
    }
    public void setDateCreation(Date date) {
        this.DateCreation = date;
    }
    public double getBalance() {
        return Balance;
    }
    public void setBalance(double Balance) {
        this.Balance = (int) Balance;
    }
    public int getIdCust() {
        return IdCust;
    }
    public void setIdCust(int IdCust) {
        this.IdCust = IdCust;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return "NumCt: " + NumCt + "<br> DateCreation: " + DateCreation +"<br> type: "+type+ "<br> Balance: "+Balance + "<br> IdCust: " + IdCust+"<br>";
    }

	
}
