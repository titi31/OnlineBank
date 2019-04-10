package co.simplon.entities;

import java.util.Date;
public class Accounts {
    private int NumCt;
    private Date DateCreation;
    private int Balance;
    private int IdCust;
    private String type;
    private int NumCt2;
    protected static Customers Customers;
    public Accounts(int numCpte, Date date,int Balance,String type, int IdCust) {
        this.NumCt = numCpte;
        this.DateCreation = DateCreation;
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


    @Override
    public String toString() {
        return "Account [NumCt=" + NumCt + "DateCreation=" + DateCreation + "Balance="+Balance + "IdCust=" + IdCust+"]";
    }

	private String DateCreation(String string, int i, int idCust2) {
		// TODO Auto-generated method stub
		return null;
	}
}
