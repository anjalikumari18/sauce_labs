package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_UserInfoPage {

	WebDriver driver;
	public CheckOut_UserInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getFirst_name() {
		return first_name;
	}

	public WebElement getLast_name() {
		return last_name;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getContinue_button() {
		return continue_button;
	}

	@FindBy(id="first-name")
	WebElement first_name;
	
	@FindBy(id = "last-name")
	WebElement last_name;
	
	@FindBy(name = "postalCode")
	WebElement pincode;
	
	@FindBy(name = "continue")
	WebElement continue_button;
	
	
}
