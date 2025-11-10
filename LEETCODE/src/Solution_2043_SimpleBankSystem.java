
public class Solution_2043_SimpleBankSystem {

}

class Bank {
	int n;
	long[] balance;
    public Bank(long[] balance) {
    	this.n = balance.length;
    	this.balance = balance;
    }
    
    
    
    
    public boolean transfer(int account1, int account2, long money) {
    	if (account1 <= 0 || account1 >n) return false;
    	if (account2 <= 0 || account2 >n) return false;
    	
        if (balance[account1-1] >= money) {
        	balance[account1-1] -= money;
        	balance[account2-1] += money;
        	return true;
        }
    	return false;
    }
    
    public boolean deposit(int account, long money) {
    	if (account <= 0 || account >n) return false;
        balance[account-1] += money;
    	return true;
    }
    
    public boolean withdraw(int account, long money) {
    	if (account <= 0 || account >n) return false;
    	
    	
        if (balance[account-1] >= money) {
        	balance[account-1] -= money;
        	return true;
        }
    	return false;
    }
}