package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailingInformation {
    @FindBy(xpath = "//*[contains(@name,'address1')]")
    public static WebElement address1;
    @FindBy(xpath = "//*[contains(@name,'city')]")
    public static WebElement city;
    @FindBy(xpath = "//*[contains(@name,'state')]")
    public static WebElement state;
    @FindBy(xpath = "//*[contains(@name,'postalCode')]")
    public static WebElement postalCode;
    @FindBy(xpath = "//*[contains(@name,'country')]")
    public static WebElement country;
}
