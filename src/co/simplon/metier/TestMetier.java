package co.simplon.metier;
import co.simplon.entities.*;
import co.simplon.dao.AccountDao;
import java.util.Date;
public class TestMetier {
	public static void main(String[] args) {
		Accounts c1=new Accounts(1,3000,1);
		BanqueMetier banqueMetier=new BanqueMetier();
		Accounts compte=banqueMetier.consulterAccounts(c1.getNumCt());
		banqueMetier.retirer(c1,30);
		//BanqueMetier.verser(c1,100);
		banqueMetier.consulterAccounts(c1.getNumCt());
		AccountDao account=new AccountDao();
		System.out.println(account.find(c1.getNumCt()));
		
		System.out.println("reussie");
	}
}
