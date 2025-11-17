package Helper_Attribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class dependsonmethod {


	@Test ()
	public void createAccount() {
		Reporter.log("Account created",true);
	}
	
	@Test(dependsOnMethods = "createAccount" )
	public void editAccount() {
		Reporter.log("Account edited",true);
	}
	
	@Test(dependsOnMethods = "createAccount")
	public void deleteAccount() {
		Reporter.log("Account deleted",true);
	}



}
