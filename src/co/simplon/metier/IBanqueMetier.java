package co.simplon.metier;
import java.util.ArrayList;
import co.simplon.entities.*;
public interface IBanqueMetier {
	public static void consulterAccounts(Accounts Accounts) {
		
	}
	public static void retirer(Accounts Accounts,int argent) {
		
	}
	public static void verser(Accounts Accounts,int argent) {
		
	}
	public static void virement(Accounts Accounts1,Accounts Accounts2,int argent,int NumCt) {
		
	}
	public static ArrayList<Operations> listOperations(Accounts Accounts){
		ArrayList<Operations> list=new ArrayList<Operations>();
		return list;
	}
	//public void Accounts1(Accounts cp1);
	//public void Accounts(Accounts cp1);
}