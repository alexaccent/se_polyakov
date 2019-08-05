package sef.module8.activity;


/**
 * Thsi class represents a simple representation of an account encapsulating
 * a name 
 * 
 * @author John Doe
 *
 */
public class Account {

	private String name;

	/**
	 * Creates an Account object with the specified name.  If the accout name
	 * given violates the minimum requirements, then an AccountException is thrown
	 * 
	 * @param accountName
	 * @throws AccountException
	 */
	public  Account(String accountName) throws AccountException{
		name = accountName;

		if (accountName.length() < 4) {
			throw new AccountException("Name must be longer than 4 characters", accountName);
		}

		if (name.length() < 4 && !name.matches("[a-zA-Z0-9]")) {
			throw new AccountException("Name must contain a combination of letters and numbers", accountName);
		}
	}
	
	
	/**
	 * Returns the account name
	 * 
	 * @return the account name
	 */
	public String getName(){

		return name;
	}
}
