package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCheckout_button() {
		return checkout_button;
	}

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[text()='Checkout']")
	 private WebElement checkout_button;
	
	
		
}
