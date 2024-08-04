package testcases;

import Pages.TestCasesPage;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCasesTest extends BaseTests {
    @Test
    public void VerifyTestCasesPage(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        TestCasesPage TestCasesPage = homePage.clickTestCases();
        TestCasesPage.checkNavigationToTestCasePage();
        Assert.assertEquals(TestCasesPage.checkNavigationToTestCasePage(),true);

    }
}
