Feature: Account Creation

  @Test @Userdetails @TC01
  Scenario Outline: To Create a Userdetails
    Given User launch URL
    And Provide contact information "<First_name>", "<Last_name>", "<Phone>","<Email>"
    And Provide Mailing information "<Address>", "<City>","<State_Province>", "<Postal_Code>", "<Country>"
    And Provide User information "<Username>", "<Password>","<Confirmpassword>"
    And User should "Submit" button
    Then User created account successfully
    Examples:
      | First_name | Last_name    | Phone      | Email                    | Address  | City  | State_Province | Postal_Code | Country | Username | Password    |Confirmpassword|
      | Karthika   | Sengottaiyan | 9791510104 | skarthikamca10@gmail.com | Kodaiyur | Karur | TamilNadu      | 639001      | INDIA   | Karthi   | karthimalar |karthimalar    |