package contactus;

import Pages.ContactUsPage;
import Pages.HomePage;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends BaseTests {
    @Test
    public void ContactUsForm(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        ContactUsPage ContactUsPage = homePage.clickContactUs();
        ContactUsPage.checkGetInTouchTextVisibility();
        Assert.assertEquals(ContactUsPage.checkGetInTouchTextVisibility(),true);
        ContactUsPage.setNameInContactUs("Tasnim");
        ContactUsPage.setEmailInContactUs("tasnim@gmail.com");
        ContactUsPage.setSubjectInContactUs("hello");
        ContactUsPage.setMessageInContactUs("hiiii");
        ContactUsPage.ChooseFileToUpload("C:\\Users\\Twins\\IdeaProjects\\Test_Automation_Exercise\\src\\main\\resources\\Tasnim.txt");
        ContactUsPage.clickSubmitButton();
        ContactUsPage.clickOKFromAlert();
        ContactUsPage.checkSuccessMessage();
        Assert.assertEquals(ContactUsPage.checkSuccessMessage(),true);
        HomePage HomePage = ContactUsPage.clickHomePage();
        HomePage.HomeVisibility();
        Assert.assertEquals(HomePage.HomeVisibility(),true);

    }
}
