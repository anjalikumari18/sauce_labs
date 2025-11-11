package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addtocartbackpack;
	
	@FindBy(id="shopping_cart_container")
	private WebElement shoppingcart_icon;
	
	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement open_menu_button;
	
	@FindBy(linkText = "About")
	private WebElement about_page_link;
	
	@FindBy(linkText = "Logout")
	private WebElement logout_link;
	
	
	public WebElement getAddtocartbackpack() {
		return addtocartbackpack;
	}

	public WebElement getShoppingcart_icon() {
		return shoppingcart_icon;
	}

	public WebElement getOpen_menu_button() {
		return open_menu_button;
	}

	public WebElement getAbout_page_link() {
		return about_page_link;
	}

	public WebElement getLogout_link() {
		return logout_link;
	}
	
    public void LogoutAction() {
    	open_menu_button.click();
    	logout_link.click();
	}

	
}
