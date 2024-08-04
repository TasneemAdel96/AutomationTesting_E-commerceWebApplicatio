package signupandlogin;

import Pages.*;
import Utilies.WindowManger;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpAndLoginTests extends BaseTests {
    @Test (priority = 1)
    public void RegisterUser(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        System.out.println(homePage.HomeVisibility());
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.signupformVisibility();
        Assert.assertEquals(SignUpANDLoginPage.signupformVisibility(),true);
        System.out.println(SignUpANDLoginPage.signupformVisibility());
        SignUpANDLoginPage.setName("Adel");
        SignUpANDLoginPage.setEmailAddress("adel@gmail.com");
        ENTERACCOUNTINFORMATIONPage ENTERACCOUNTINFORMATIONPage = SignUpANDLoginPage.clickSignUpButton();
        ENTERACCOUNTINFORMATIONPage.enterAccountInformationVisibility();
        Assert.assertEquals(ENTERACCOUNTINFORMATIONPage.enterAccountInformationVisibility(),true);
        System.out.println(ENTERACCOUNTINFORMATIONPage.enterAccountInformationVisibility());
        ENTERACCOUNTINFORMATIONPage.chooseMale();
        ENTERACCOUNTINFORMATIONPage.SetPassword("Adel");
        ENTERACCOUNTINFORMATIONPage.SetDay("22");
        ENTERACCOUNTINFORMATIONPage.SetMonth("February");
        ENTERACCOUNTINFORMATIONPage.SetYear("2003");
        ENTERACCOUNTINFORMATIONPage.clickOnFirstCheckbox();
        ENTERACCOUNTINFORMATIONPage.clickOnSecondCheckbox();
        ENTERACCOUNTINFORMATIONPage.setFirstName("Adel");
        ENTERACCOUNTINFORMATIONPage.setLastName("Mohamed");
        ENTERACCOUNTINFORMATIONPage.setCompanyname("T Company");
        ENTERACCOUNTINFORMATIONPage.setAddress1("Zahraa Naser City");
        ENTERACCOUNTINFORMATIONPage.setAddress2("Cairo");
        ENTERACCOUNTINFORMATIONPage.selectFromCountryDropdown("New Zealand");
        ENTERACCOUNTINFORMATIONPage.setState("Cairo");
        ENTERACCOUNTINFORMATIONPage.setCity("Egypt");
        ENTERACCOUNTINFORMATIONPage.setZipcodeNo("233333");
        ENTERACCOUNTINFORMATIONPage.setMobileNo("01201022286262");
        AccountCreatedPage AccountCreatedPage = ENTERACCOUNTINFORMATIONPage.clickCreateAccountButton();
        AccountCreatedPage.checkText();
        Assert.assertEquals(AccountCreatedPage.checkText(),true);
        System.out.println(AccountCreatedPage.checkText());
        AccountCreatedPage.clickContinue();
        AccountCreatedPage.GetLogedinText();
        Assert.assertEquals(AccountCreatedPage.GetLogedinText(),"Logged in as Adel");
        System.out.println(AccountCreatedPage.GetLogedinText());
        DeleteAccountPage DeleteAccountPage = AccountCreatedPage.clickDeleteAccountText();
        DeleteAccountPage.checkAccountDeletedText();
        Assert.assertEquals(DeleteAccountPage.checkAccountDeletedText(),true);
        System.out.println(DeleteAccountPage.checkAccountDeletedText());
        DeleteAccountPage.clickcontinueDelete();

     }
     @Test(priority = 2)
    public void LoginUserWithCorrectEmailAndPassword(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.loginFormVisibility();
        Assert.assertEquals(SignUpANDLoginPage.loginFormVisibility(),true);
        SignUpANDLoginPage.setEmailAddressforLogin("Toty@gmail.com");
        SignUpANDLoginPage.setPasswordforLogin("Toty");
        HomePage HomePage = SignUpANDLoginPage.clickLoginButton();
        HomePage.GetLogedinTextAfterlogin();
        Assert.assertEquals(HomePage.GetLogedinTextAfterlogin(),"Logged in as Toty");
        DeleteAccountPage DeleteAccountPage = HomePage.clickDeleteAccountText();
        DeleteAccountPage.checkAccountDeletedText();
        Assert.assertEquals(DeleteAccountPage.checkAccountDeletedText(),true);
     }
    @Test(priority = 3)
    public void LoginUserWithIncorrectEmailAndPassword(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.loginFormVisibility();
        Assert.assertEquals(SignUpANDLoginPage.loginFormVisibility(),true);
        SignUpANDLoginPage.setEmailAddressforLogin("Aya@gmail.com");
        SignUpANDLoginPage.setPasswordforLogin("Ayaaaa");
        SignUpANDLoginPage.clickLoginButton();
        SignUpANDLoginPage.EnsureErrorMessageForIncorrectLogin();
        Assert.assertEquals(SignUpANDLoginPage.EnsureErrorMessageForIncorrectLogin(),true);

    }
    @Test (priority = 4)
    public void LogoutUser(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.loginFormVisibility();
        Assert.assertEquals(SignUpANDLoginPage.loginFormVisibility(),true);
        SignUpANDLoginPage.setEmailAddressforLogin("Aya11@gmail.com");
        SignUpANDLoginPage.setPasswordforLogin("Aya");
        HomePage HomePage = SignUpANDLoginPage.clickLoginButton();
        HomePage.GetLogedinTextAfterlogin();
        Assert.assertEquals(HomePage.GetLogedinTextAfterlogin(),"Logged in as Aya Ahmed");
        homePage.clickLogout();
        SignUpANDLoginPage.loginFormVisibility();
        Assert.assertEquals(SignUpANDLoginPage.loginFormVisibility(),true);
        SignUpANDLoginPage.signupformVisibility();
        Assert.assertEquals(SignUpANDLoginPage.signupformVisibility(),true);




    }
    @Test (priority = 5)
    public void RegisterUserWithExistingEmail(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.signupformVisibility();
        Assert.assertEquals(SignUpANDLoginPage.signupformVisibility(),true);
        SignUpANDLoginPage.setName("Aya");
        SignUpANDLoginPage.setEmailAddress("Aya11@gmail.com");
        SignUpANDLoginPage.clickSignUpButton();
        SignUpANDLoginPage.EnsureErrorMessageForIncorrectRegister();
        Assert.assertEquals(SignUpANDLoginPage.EnsureErrorMessageForIncorrectRegister(),true);

    }
    @Test (priority = 6)
    public void PlaceOrderRegisterWhileCheckout(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        homePage.AddFourthProductToCart();
        homePage.AddFifthProductToCart();
        CartPage CartPage = homePage.clickCart();
        Assert.assertEquals(CartPage.VerifyCartPageDisplayed(),true);
        CartPage.clickProceedToCheckOut();
        SignUpANDLoginPage SignUpANDLoginPage = CartPage.clickRegisterORLoginButton();
        SignUpANDLoginPage.setName("John");
        SignUpANDLoginPage.setEmailAddress("John1888@gmail.com");
        ENTERACCOUNTINFORMATIONPage ENTERACCOUNTINFORMATIONPage = SignUpANDLoginPage.clickSignUpButton();
        ENTERACCOUNTINFORMATIONPage.chooseMale();
        ENTERACCOUNTINFORMATIONPage.SetPassword("John");
        ENTERACCOUNTINFORMATIONPage.SetDay("1");
        ENTERACCOUNTINFORMATIONPage.SetMonth("January");
        ENTERACCOUNTINFORMATIONPage.SetYear("2003");
        ENTERACCOUNTINFORMATIONPage.clickOnFirstCheckbox();
        ENTERACCOUNTINFORMATIONPage.clickOnSecondCheckbox();
        ENTERACCOUNTINFORMATIONPage.setFirstName("John");
        ENTERACCOUNTINFORMATIONPage.setLastName("J");
        ENTERACCOUNTINFORMATIONPage.setCompanyname("j.high");
        ENTERACCOUNTINFORMATIONPage.setAddress1("Maadi");
        ENTERACCOUNTINFORMATIONPage.setAddress2("Zahraa");
        ENTERACCOUNTINFORMATIONPage.selectFromCountryDropdown("Canada");
        ENTERACCOUNTINFORMATIONPage.setState("Canada");
        ENTERACCOUNTINFORMATIONPage.setCity("CA");
        ENTERACCOUNTINFORMATIONPage.setZipcodeNo("111111");
        ENTERACCOUNTINFORMATIONPage.setMobileNo("0127336355353");
        AccountCreatedPage AccountCreatedPage = ENTERACCOUNTINFORMATIONPage.clickCreateAccountButton();
        Assert.assertEquals(AccountCreatedPage.checkText(),true);
        AccountCreatedPage.clickContinue();
        Assert.assertEquals(homePage.GetLogedinTextAfterlogin(),"Logged in as John");
        homePage.clickCart();
        CheckOutPage CheckOutPage = CartPage.clickProceedToCheckOut();
        CheckOutPage.VerifyAddressDetailsFirstNameAndLastName();
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsFirstNameAndLastName(),"Mr. John J");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"j.high");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress1(),"Maadi");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress2(),"Zahraa");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCityAndStateAndZipCode(),"CA Canada 111111");
//        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"Canada");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsMobileNo(),"0127336355353");
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFourthProduct(),true);
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFifthProduct(),true);
        PaymentPage PaymentPage = CheckOutPage.AddComment("Hi, it's a Good Site");
        PaymentPage.SetNameOnCard("John j");
        PaymentPage.SetCardNum("435555533");
        PaymentPage.SetCVC("545");
        PaymentPage.SetExpirationMonth("2");
        PaymentPage.SetExpirationYear("2028");
        PaymentPage.clickPayandConfirmOrder();
        goBack();
        Assert.assertEquals(PaymentPage.VerifyConfirmMessageAfterPay(),"Your order has been placed successfully!");
        DeleteAccountPage DeleteAccountPage = homePage.clickDeleteAccountText();
        Assert.assertEquals(DeleteAccountPage.checkAccountDeletedText(),true);
        DeleteAccountPage.clickcontinueDelete();
    }
    @Test(priority = 7)
    public void PlaceOrderRegisterBeforeCheckout(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.setName("Lili");
        SignUpANDLoginPage.setEmailAddress("Lili8@gmail.com");
        ENTERACCOUNTINFORMATIONPage ENTERACCOUNTINFORMATIONPage = SignUpANDLoginPage.clickSignUpButton();
        ENTERACCOUNTINFORMATIONPage.chooseFemale();
        ENTERACCOUNTINFORMATIONPage.SetPassword("Lili");
        ENTERACCOUNTINFORMATIONPage.SetDay("1");
        ENTERACCOUNTINFORMATIONPage.SetMonth("January");
        ENTERACCOUNTINFORMATIONPage.SetYear("2003");
        ENTERACCOUNTINFORMATIONPage.clickOnFirstCheckbox();
        ENTERACCOUNTINFORMATIONPage.clickOnSecondCheckbox();
        ENTERACCOUNTINFORMATIONPage.setFirstName("Lili");
        ENTERACCOUNTINFORMATIONPage.setLastName("L");
        ENTERACCOUNTINFORMATIONPage.setCompanyname("L.high");
        ENTERACCOUNTINFORMATIONPage.setAddress1("Maadi");
        ENTERACCOUNTINFORMATIONPage.setAddress2("Zahraa");
        ENTERACCOUNTINFORMATIONPage.selectFromCountryDropdown("Canada");
        ENTERACCOUNTINFORMATIONPage.setState("Canada");
        ENTERACCOUNTINFORMATIONPage.setCity("CA");
        ENTERACCOUNTINFORMATIONPage.setZipcodeNo("122111");
        ENTERACCOUNTINFORMATIONPage.setMobileNo("0123334151551");
        AccountCreatedPage AccountCreatedPage = ENTERACCOUNTINFORMATIONPage.clickCreateAccountButton();
        Assert.assertEquals(AccountCreatedPage.checkText(),true);
        AccountCreatedPage.clickContinue();
        Assert.assertEquals(homePage.GetLogedinTextAfterlogin(),"Logged in as Lili");
        homePage.AddFourthProductToCart();
        homePage.AddFifthProductToCart();
        CartPage CartPage = homePage.clickCart();
        Assert.assertEquals(CartPage.VerifyCartPageDisplayed(),true);
        CheckOutPage CheckOutPage = CartPage.clickProceedToCheckOut();
        CheckOutPage.VerifyAddressDetailsFirstNameAndLastName();
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsFirstNameAndLastName(),"Mrs. Lili L");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"L.high");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress1(),"Maadi");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress2(),"Zahraa");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCityAndStateAndZipCode(),"CA Canada 122111");
//        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"Canada");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsMobileNo(),"0123334151551");
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFourthProduct(),true);
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFifthProduct(),true);
        PaymentPage PaymentPage = CheckOutPage.AddComment("Hi, it's a Good Site");
        PaymentPage.SetNameOnCard("Lili L");
        PaymentPage.SetCardNum("435555533");
        PaymentPage.SetCVC("545");
        PaymentPage.SetExpirationMonth("2");
        PaymentPage.SetExpirationYear("2028");
        PaymentPage.clickPayandConfirmOrder();
        goBack();
        Assert.assertEquals(PaymentPage.VerifyConfirmMessageAfterPay(),"Your order has been placed successfully!");
        DeleteAccountPage DeleteAccountPage = homePage.clickDeleteAccountText();
        Assert.assertEquals(DeleteAccountPage.checkAccountDeletedText(),true);
        DeleteAccountPage.clickcontinueDelete();
    }
    @Test(priority = 8)
    public void PlaceOrderLoginBeforeCheckout(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.setEmailAddressforLogin("adel@gmail.com");
        SignUpANDLoginPage.setPasswordforLogin("Adel");
        HomePage HomePage = SignUpANDLoginPage.clickLoginButton();
        HomePage.GetLogedinTextAfterlogin();
        Assert.assertEquals(HomePage.GetLogedinTextAfterlogin(),"Logged in as Adel");
        homePage.AddFourthProductToCart();
        homePage.AddFifthProductToCart();
        CartPage CartPage = homePage.clickCart();
        Assert.assertEquals(CartPage.VerifyCartPageDisplayed(),true);
        CheckOutPage CheckOutPage = CartPage.clickProceedToCheckOut();
        CheckOutPage.VerifyAddressDetailsFirstNameAndLastName();
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsFirstNameAndLastName(),"Mr. Adel Mohamed");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"T Company");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress1(),"Zahraa Naser City");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress2(),"Cairo");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCityAndStateAndZipCode(),"Egypt Cairo 233333");
//        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"Canada");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsMobileNo(),"01201022286262");
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFourthProduct(),true);
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFifthProduct(),true);
        PaymentPage PaymentPage = CheckOutPage.AddComment("Hi, it's a Good Site");
        PaymentPage.SetNameOnCard("Adel Mohamed");
        PaymentPage.SetCardNum("435555533");
        PaymentPage.SetCVC("545");
        PaymentPage.SetExpirationMonth("2");
        PaymentPage.SetExpirationYear("2060");
        PaymentPage.clickPayandConfirmOrder();
        goBack();
        Assert.assertEquals(PaymentPage.VerifyConfirmMessageAfterPay(),"Your order has been placed successfully!");
        DeleteAccountPage DeleteAccountPage = homePage.clickDeleteAccountText();
        Assert.assertEquals(DeleteAccountPage.checkAccountDeletedText(),true);
        DeleteAccountPage.clickcontinueDelete();
    }



}
