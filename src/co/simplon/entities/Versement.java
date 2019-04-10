package co.simplon.entities;
import java.util.Date;
public class Versement extends Operations {
	
	private int NumOp;
	private int Amount;
	private int NumCt;
	private String type;
	private Date DateOp;
	public Versement(int Amount,Date DateOp,int NumCt) {
		super("Versement",Amount,DateOp,NumCt);
	}
	public String toString() {
		return "Versement [NumOp=" + NumOp + ", Amount=" + Amount + ", NumCt=" + NumCt + ", type=" + type + ", DateOp="
				+ DateOp + "]";
	}
}
