package co.simplon.entities;
import java.util.Date;
public class Operations {
	private int NumOp;
	private String type;
	private int Amount;
	private Date DateOp;
	private int NumCt;
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