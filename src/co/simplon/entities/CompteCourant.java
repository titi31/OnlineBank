package co.simplon.entities;
import java.util.ArrayList;
import java.util.Date;
public class CompteCourant extends Accounts {
	 public static boolean bool=false;
	
	private int decouvert;
	private double Balance;
	public ArrayList<Operations> listOp=new ArrayList<Operations>();
	
	public CompteCourant(int NumCt,Date DateCreation,int Balance,String type,int IdCust,int decouvert) {
		super(NumCt,DateCreation,Balance,type,IdCust);
		this.decouvert=decouvert;
		this.Balance=Balance;
		
	}
	public String toString() {
		return super.toString()+" Balance: "+Balance+" decouvert: "+decouvert+" ]";
	}
	public void setDecouvert(int decouvert) {
		this.decouvert=decouvert;
	}
	public float getDecouvert() {
		return decouvert;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double Balance) {
		if(Balance>=-decouvert) {
			bool=true;
			//System.out.println("ok");
			this.Balance=Balance;
		}
		else {
			bool=false;
			//System.out.println("vous depassez votre decouvert autoriser ");
			//listOp.remove(listOp.get(listOp.size()-1));
			
			
			
		}}
		/*public void consulterAccounts(Accounts Accounts) {
			System.out.println("Balance: "+Accounts.getBalance());
		}
		
		public void retirer(Accounts compte,int argent){
			compte.setBalance(compte.getBalance()-argent);
			if(bool) {
				
				
				listOp.add(new Operations("Retrait",new Date(),argent,compte));
			
			}else if(!bool) {
				System.out.println("retrait refuser");
				//listOp.remove(listOp.get(listOp.size()-1));
			}else
				System.out.println("vous ne pouvez pas retirer plus de 400 euro !");
				
			//listOp.add(retire);
		}
		public void verser(Accounts compte,int argent) {
			compte.setBalance(compte.getBalance()+argent);
			listOp.add(new Operations("Versement",new Date(),argent,compte));
			
			//listOp.add(verse);
			
		}
		public void virement(Accounts Accounts,Accounts Accounts2,int argent) {
			double solde1=Accounts.getBalance()-argent;
			double solde2=Accounts2.getBalance()+argent;
			Accounts.setBalance(solde1);
			
			if(bool) {
				listOp.add(new Operations("Virement",new Date(),argent,Accounts));
				Accounts2.setBalance(solde2);
			}
			if(!bool)
				System.out.println("virement refuser");
			//listOp.add(virement);
			
		}
		public ArrayList<Operations> listOperations(Accounts Accounts){
		
			return listOp;
		}*/
	}
	