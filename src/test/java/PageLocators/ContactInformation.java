package PageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformation {


    @FindBy(xpath = "//input[@name='firstName']")
    public static WebElement firstName;
    @FindBy(xpath = "//*[contains(@name,'lastName')]")
    public static WebElement lastName;
    @FindBy(xpath = "//*[contains(@name,'phone')]")
    public static WebElement phone;
    @FindBy(xpath = "//*[contains(@id,'userName')]")
    public static WebElement email;


}
