package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Autohealing
	@FindAll({	@FindBy(id = "user-name"),	@FindBy(name = "user-name")})
	private WebElement usernametf;
	
	@FindBy(id = "password")
	private WebElement passwordtf;
	
	@FindBy(xpath = "//input[@value=\"Login\"]")
	private WebElement loginbutton;
	
	
	public void LoginAction(String user,String pass) {
		usernametf.sendKeys(user);
		passwordtf.sendKeys(pass);
		loginbutton.click();
		
	}
}
