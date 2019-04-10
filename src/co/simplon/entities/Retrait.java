package co.simplon.entities;
import java.util.Date;
public class Retrait extends Operations {
	
	private int NumOp;
	private int Amount;
	private int NumCt;
	private String type;
	private Date date;
	public Retrait(int Amount,Date date,int NumCt) {
		super("Retrait",Amount,date,NumCt);
	}
	public String toString() {
		return "Retrait [NumOp=" + NumOp + ", Amount=" + Amount + ", NumCt=" + NumCt + ", type=" + type + ", date="
				+ date + "]";
	}
}
