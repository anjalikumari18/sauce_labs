package Helper_Attribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class enabled {
	
	@Test (enabled = false)
	public void Myntra() {
		Reporter.log("Myntra executed",true);
	}
	
	@Test(enabled = false)
	public void Swiggy() {
		Reporter.log("Swiggy executed",true);
	}
	
	@Test()
	public void Amazon() {
		Reporter.log("Amazon executed",true);
	}


}
