package Helper_Attribute;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class priority {

		
	@Test(priority = 1)
	public void Swiggy() {
		Reporter.log("Swiggy executed",true);
	}
	
	
	@Test(priority = -1)
	public void Amazon() {
		Reporter.log("Amazon executed",true);
	}
	
	@Test(priority = -2)
	public void Flipkart() {
		Reporter.log("Flipkart executed",true);
	}
	
	@Test(priority = 4)
	public void BigBasket() {
		Reporter.log("BigBasket executed",true);
	}
	
	@Test(priority = -10)
	public void Zepto() {
		Reporter.log("Zepto executed",true);
	}
	@Test(priority = 6)
	public void Blinkit() {
		Reporter.log("Blinkit executed",true);
	}
	
	
	
	
	
	
	
	
}
