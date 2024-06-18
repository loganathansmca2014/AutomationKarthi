package StepDef;

import BusinessLogic.BusinessLogin;
import Utility.GlobalLogic;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;


public class AccountCreation    {
    public static String testcaseid;

    @Given("^User launch URL$")
    public void userLaunchURL() throws IOException {

      GlobalLogic.BrowserOpen();
    }

    @And("^Provide contact information \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void provideContactInformation(String First_name, String Last_name, String Phone, String Email) throws Throwable {
   BusinessLogin.contactInformation(First_name,Last_name,Phone,Email);
    }

    @And("^Provide Mailing information \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void provideMailingInformation(String Address, String City, String State_Province, String Postal_Code, String Country) throws Throwable {
        BusinessLogin.mailinginformation(Address,City,State_Province,Postal_Code,Country);
    }


    @And("^User should \"([^\"]*)\" button$")
    public void userShouldButton(String Submit) throws Throwable {
BusinessLogin.submitPage(Submit);
    }

    @Then("^User created account successfully$")
    public void userCreatedAccountSuccessfully() throws InterruptedException {
        BusinessLogin.ackConfirmation();
    }


    @Given("^Provide User information \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\"$")
    public void provide_User_information(String Username, String Password, String Confirmpassword) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BusinessLogin.userInformtion(Username,Password,Confirmpassword);
    }


}
