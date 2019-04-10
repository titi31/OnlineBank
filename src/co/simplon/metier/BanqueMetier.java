package co.simplon.metier;
import co.simplon.entities.Accounts;
import co.simplon.entities.Operations;
import co.simplon.entities.Retrait;
import co.simplon.entities.Versement;
import co.simplon.dao.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
public class BanqueMetier implements IBanqueMetier {
	private int year ;
	private int month ;
	private int day  ;
	public static ArrayList<Operations> listOp=new ArrayList<Operations>();
	static AccountDao Account=new AccountDao();

	
	public static void consulterAccounts(Accounts Accounts) {
		System.out.println("Balance: "+Accounts.getBalance()+"compte :"+Account.find(Accounts.getNumCt()));
		
	}
	
	public static void retirer(Accounts Accounts,int argent){
		
		if(argent<400) {
		
			Accounts.setBalance(Accounts.getBalance()-argent);
			Account.update(Accounts);
			
			listOp.add(new Retrait(argent,new Date(),Accounts.getNumCt()));
			OperationDao cd = new OperationDao();	
			cd.create(new Retrait(argent,new Date(),Accounts.getNumCt()));
			
		}
		else
			System.out.println("vous ne pouvez pas retirer plus de 400 euro !");
			
		//listOp.add(retire);
	}
	public static void verser(Accounts Accounts,int argent) {
		Accounts.setBalance(Accounts.getBalance()+argent);
		Account.update(Accounts);
		
		listOp.add(new Versement(argent,new Date(),Accounts.getNumCt()));
		OperationDao cd =new OperationDao();
		cd.create(new Versement(argent,new Date(),Accounts.getNumCt()));
		//listOp.add(verse);
		
		
	}
	public static void virement(Accounts Accounts1,Accounts Accounts2,int argent,int NumCt) {
		double Balance1=Accounts1.getBalance()-argent;
		double Balance2=Accounts2.getBalance()+argent;
		
		Accounts1.setBalance(Balance1);
		Account.update(Accounts1);
		Accounts2.setBalance(Balance2);
		Account.update(Accounts2);
		listOp.add(new Operations("Virement",argent,new Date(),NumCt));
		OperationDao cd =new OperationDao();
		cd.create(new Operations("Virement",argent,new Date(),NumCt));
		//listOp.add(virement);
		
	}
	public static ArrayList<Operations> listOperations(Accounts Accounts){
		
		
		return listOp;
	}

}
