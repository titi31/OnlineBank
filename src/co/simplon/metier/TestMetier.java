package co.simplon.metier;
import co.simplon.entities.*;
import co.simplon.dao.AccountDao;
import java.util.Date;
public class TestMetier {
	public static void main(String[] args) {
		Accounts c1=new Accounts(1,3000,1);
		BanqueMetier.consulterAccounts(c1);
		BanqueMetier.retirer(c1,30);
		//BanqueMetier.verser(c1,100);
		BanqueMetier.consulterAccounts(c1);
		AccountDao account=new AccountDao();
		System.out.println(account.find(c1.getNumCt()));
		
		System.out.println("reussie");
	}
}
