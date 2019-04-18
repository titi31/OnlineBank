package co.simplon.entities;
import java.util.Date;
import java.util.ArrayList;
public class Operations {
	private int NumOp;
	private String type;
	private int Amount;
	private Date DateOp;
	private int NumCt;
	public static ArrayList<Operations> ListOperations=new ArrayList<Operations>();
	public static ArrayList<Operations> getListOperations() {
		return ListOperations;
	}
	public static void setListOperations(ArrayList<Operations> listOperations) {
		ListOperations = listOperations;
	}
	public Operations() {};
	public Operations(int NumOp,String type, int Amount,Date DateOp, int NumCt) {
		this.NumOp = NumOp;
		this.type=type;
		this.Amount = Amount;
		this.DateOp=DateOp;
		this.NumCt = NumCt;
	}
	public Operations(String type, int Amount,Date DateOp, int NumCt) {
		
		this.type=type;
		this.Amount = Amount;
		this.DateOp=DateOp;
		this.NumCt = NumCt;
	}
	public Operations(String type, int Amount, int NumCt) {
		
		this.type=type;
		this.Amount = Amount;
		//this.DateOp=DateOp;
		this.NumCt = NumCt;
	}
	public Operations(int NumCt) {
		
	//	this.type=type;
		//this.Amount = Amount;
		//this.DateOp=DateOp;
		this.NumCt = NumCt;
	}
	public Date getDateOp() {
		return DateOp;
	}
	public void setDateOp(Date dateOp) {
		DateOp = dateOp;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Operations [NumOp=" + NumOp + ", type=" + type + ", Amount=" + Amount + ", DateOp=" + DateOp
				+ ", NumCt=" + NumCt + "]";
	}

	public int getNumOp() {
		return NumOp;
	}

	public void setNumOp(int NumOp) {
		this.NumOp = NumOp;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int Amount) {
		this.Amount = Amount;
	}

	public int getNumCt() {
		return NumCt;
	}
	public String getType() {
		return type;
	}

	public void setNumCt(int NumCt) {
		this.NumCt = NumCt;
	}	
}