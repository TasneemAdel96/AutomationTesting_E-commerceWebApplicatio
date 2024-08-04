package checkout;

import Pages.*;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTests extends BaseTests {
    @Test
    public void VerifyAddressDetailsInCheckoutPage(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        SignUpANDLoginPage SignUpANDLoginPage = homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.setName("Adel");
        SignUpANDLoginPage.setEmailAddress("adel12@gmail.com");
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
        homePage.AddFourthProductToCart();
        homePage.AddFifthProductToCart();
        CartPage CartPage = homePage.clickCart();
        Assert.assertEquals(CartPage.VerifyCartPageDisplayed(),true);
        CheckOutPage CheckOutPage = CartPage.clickProceedToCheckOut();
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsFirstNameAndLastName(),"Mr. Adel Mohamed");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"T Company");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyNameInBilling(),"T Company");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress1(),"Zahraa Naser City");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress1Billing(),"Zahraa Naser City");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress2(),"Cairo");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress2Billing(),"Cairo");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCityAndStateAndZipCode(),"Egypt Cairo 233333");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCityAndStateAndZipCodeBilling(),"Egypt Cairo 233333");
//        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"Canada");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsMobileNo(),"01201022286262");
        DeleteAccountPage DeleteAccountPage = AccountCreatedPage.clickDeleteAccountText();
        DeleteAccountPage.checkAccountDeletedText();
        Assert.assertEquals(DeleteAccountPage.checkAccountDeletedText(),true);
        System.out.println(DeleteAccountPage.checkAccountDeletedText());
        DeleteAccountPage.clickcontinueDelete();
    }
    @Test
    public void DownloadInvoiceAfterPurchaseOrder(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        homePage.AddFourthProductToCart();
        homePage.AddFifthProductToCart();
        CartPage CartPage = homePage.clickCart();
        Assert.assertEquals(CartPage.VerifyCartPageDisplayed(),true);
        CheckOutPage CheckOutPage = CartPage.clickProceedToCheckOut();
        SignUpANDLoginPage SignUpANDLoginPage = CartPage.clickRegisterORLoginButton();
        SignUpANDLoginPage.setName("Adel");
        SignUpANDLoginPage.setEmailAddress("adel100@gmail.com");
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
        homePage.clickCart();
        CartPage.clickProceedToCheckOut();
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsFirstNameAndLastName(),"Mr. Adel Mohamed");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"T Company");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyNameInBilling(),"T Company");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress1(),"Zahraa Naser City");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress1Billing(),"Zahraa Naser City");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress2(),"Cairo");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsAddress2Billing(),"Cairo");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCityAndStateAndZipCode(),"Egypt Cairo 233333");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCityAndStateAndZipCodeBilling(),"Egypt Cairo 233333");
//        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsCompanyName(),"Canada");
        Assert.assertEquals(CheckOutPage.VerifyAddressDetailsMobileNo(),"01201022286262");
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFourthProduct(),true);
        Assert.assertEquals(CheckOutPage.VerifyAppearanceOfFifthProduct(),true);
        PaymentPage PaymentPage = CheckOutPage.AddComment("Hi, it's a Good Site");
        PaymentPage.SetNameOnCard("Adel Mohamed");
        PaymentPage.SetCardNum("435555533");
        PaymentPage.SetCVC("545");
        PaymentPage.SetExpirationMonth("2");
        PaymentPage.SetExpirationYear("2028");
        PaymentPage.clickPayandConfirmOrder();
        goBack();
        Assert.assertEquals(PaymentPage.VerifyConfirmMessageAfterPay(),"Your order has been placed successfully!");
        goForward();
        PaymentPage.clickDownloadInvoice();
        PaymentPage.clickContinue();
        Assert.assertEquals(PaymentPage.checkFileDownloaded(),true,"Error in Download");
        DeleteAccountPage DeleteAccountPage = AccountCreatedPage.clickDeleteAccountText();
        DeleteAccountPage.checkAccountDeletedText();
        Assert.assertEquals(DeleteAccountPage.checkAccountDeletedText(),true);
        System.out.println(DeleteAccountPage.checkAccountDeletedText());
        DeleteAccountPage.clickcontinueDelete();




        }
}
