package co.simplon.entities;
import java.util.Date;
import java.util.ArrayList;
public class CompteEpargne extends Accounts  {
		public static boolean bool=false; 
		public ArrayList<Operations> listOp=new ArrayList<Operations>();
		private int taux;
		private double Balance;
		
		public CompteEpargne(int NumCt,Date DateCreation,int Balance,String type,int IdCust,int taux) {
			super(NumCt,DateCreation,Balance,type,IdCust);
			this.taux=taux;
			this.Balance=Balance;
			
		}
		public String toString() {
			return super.toString()+" Balance: "+Balance+" taux: "+taux+" ]";
		}
		public void setTaux(int taux) {
			this.taux=taux;
		}
		public double getTaux() {
			return taux;
		}
		public void setBalance(double Balance) {
			if(Balance>=0) {
				bool=true;
				this.Balance=Balance;
			//System.out.println("ok");
			}
			else {
				bool=false;
				System.out.println("vous ne pouvez pas etre a decouvert");
				
			}
				//this.solde=0;
				}
		public double getBalance() {
			return this.Balance;
		}
		/*public void consulterAccounts(Accounts Accounts) {
			System.out.println("Balance: "+Accounts.getBalance());
		}
		
		public void retirer(Accounts Accounts,int argent){
			Accounts.setBalance(Accounts.getBalance()-argent);
			
			
			if(bool) {
				
				
				listOp.add(new Operations("Retrait",new Date(),argent,Accounts));
			
			}else {
				System.out.println("retrait refuser");
				//listOp.remove(listOp.get(listOp.size()-1));
			}
		}
		public void verser(Accounts Accounts,int argent) {
			Accounts.setBalance(Accounts.getBalance()+argent);
			listOp.add(new Operations("Versement",new Date(),argent,Accounts));
			
			//listOp.add(verse);
			
		}
		public void virement(Accounts Accounts1,Accounts Accounts2,int argent) {
			double Balance1=Accounts1.getBalance()-argent;
			double Balance2=Accounts2.getBalance()+argent;
			Accounts1.setBalance(Balance1);
			
			if(bool) {
				listOp.add(new Operations("Virement",new Date(),argent,Accounts1));
				Accounts2.setBalance(Balance2);
			}
			else 
				System.out.println("virement refuser");
			//listOp.add(virement);
			
		}
		public ArrayList<Operations> listOperations(Accounts Accounts){
		
			return listOp;
		}*/
		
				
}