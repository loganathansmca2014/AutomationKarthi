package PageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AckConfirmation {
    @FindBy(xpath = "//*[contains(text(),'Your user ')]")
    public static WebElement ackconfirmation;

}
