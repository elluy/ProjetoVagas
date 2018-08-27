package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Mapeamento elementos de login
	
	@FindBy(id="login_candidatos_form_usuario")
	WebElement usuario;
	
	@FindBy (id="login_candidatos_form_senha")
	WebElement senha;
	
	@FindBy (how=How.NAME, using="commit")
	WebElement btnLogin;
	
	//Métodos
	
	public void login(String user, String pass) {
		usuario.sendKeys(user);
		senha.sendKeys(pass);
		btnLogin.click();
	}
}
