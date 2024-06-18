package BusinessLogic;

import PageLocators.AckConfirmation;
import PageLocators.ContactInformation;
import PageLocators.MailingInformation;
import PageLocators.UserInformation;
import Utility.GlobalLogic;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class BusinessLogin {
    public static BusinessLogin INSTANCE = new BusinessLogin();

    /****************************************************************************************
     * DESCRIPTION:This method is used to get the contactInformation page
     * Created By:Karthika Sengottaiyan
     * Created DATE:10 May 2021
     * UPDATED BY:
     * UPDATED DATE :
     * method:contactInformation
     * Example:
     * /
     ****************************************************************************************/
    public static void contactInformation(String first_name, String last_name, String phone, String email) throws IOException {
        PageFactory.initElements(GlobalLogic.getInstance().driver, ContactInformation.class);
        ContactInformation.lastName.sendKeys(last_name);

        ContactInformation.firstName.sendKeys(first_name);
        ContactInformation.lastName.sendKeys(last_name);
        ContactInformation.phone.sendKeys(phone);
        ContactInformation.email.sendKeys(email);
      //  GlobalLogic.takescreenshot();
        GlobalLogic.propertiesLoad();


    }


    /****************************************************************************************
     * DESCRIPTION:This method is used to get the mailinginformation page
     * Created By:Karthika Sengottaiyan
     * Created DATE:10 May 2021
     * UPDATED BY:
     * UPDATED DATE :
     * method:mailinginformation
     * Example:
     * /
     ****************************************************************************************/
    public static void mailinginformation(String address, String city, String state_province, String postal_code, String country) throws InterruptedException {
        PageFactory.initElements(GlobalLogic.getInstance().driver, MailingInformation.class);
        MailingInformation.address1.sendKeys(address);
        MailingInformation.city.sendKeys(city);
        MailingInformation.state.sendKeys(state_province);
        MailingInformation.postalCode.sendKeys(postal_code);
        Select countrylist = new Select(MailingInformation.country);
        countrylist.selectByValue(country);
        //GlobalLogic.takescreenshot();
       //Thread.sleep(5000);

    }
    /****************************************************************************************
     * DESCRIPTION:This method is used to get the userInformtion page
     * Created By:Karthika Sengottaiyan
     * Created DATE:10 May 2021
     * UPDATED BY:
     * UPDATED DATE :
     * method:userInformtion
     * Example:
     * /
     ****************************************************************************************/
    public static void userInformtion(String username, String password, String confirmpassword) throws InterruptedException {
        PageFactory.initElements(GlobalLogic.getInstance().driver, UserInformation.class);
        UserInformation.username.sendKeys(username);
        UserInformation.password.sendKeys(password);
        UserInformation.confirmpassword.sendKeys(confirmpassword);
        //GlobalLogic.takescreenshot();
        Thread.sleep(5000);

    }
    /****************************************************************************************
     * DESCRIPTION:This method is used to submit the page
     * Created By:Karthika Sengottaiyan
     * Created DATE:10 May 2021
     * UPDATED BY:
     * UPDATED DATE :
     * method:submitPage
     * Example:
     * /
     ****************************************************************************************/
    public static void submitPage(String submit) throws InterruptedException {
        PageFactory.initElements(GlobalLogic.getInstance().driver, UserInformation.class);
        assert(UserInformation.submitBtn.isEnabled());
UserInformation.submitBtn.click();
        //GlobalLogic.takescreenshot();
        Thread.sleep(5000);
    }

    /****************************************************************************************
     * DESCRIPTION:This method is used to get the acknowledge page
     * Created By:Karthika Sengottaiyan
     * Created DATE:10 May 2021
     * UPDATED BY:
     * UPDATED DATE :
     * method:ackConfirmation
     * Example:
     * /
     ****************************************************************************************/
    public static void ackConfirmation() throws InterruptedException {
        PageFactory.initElements(GlobalLogic.getInstance().driver, AckConfirmation.class);
        assert(AckConfirmation.ackconfirmation.isDisplayed());
        String success=AckConfirmation.ackconfirmation.getText();
        //GlobalLogic.scenario.wr(success);
        GlobalLogic.takescreenshot();
        Thread.sleep(5000);

    }
    public static BusinessLogin getInstance() {
        return INSTANCE;
    }

}
