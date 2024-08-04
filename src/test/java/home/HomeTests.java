package home;

import Pages.CartPage;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends BaseTests {
    @Test
    public void VerifySubscriptionInHomePage(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        homePage.ScrollDownToFooter();
        Assert.assertEquals(homePage.ScrollDownToFooter(),true);
        homePage.SetEmailForSubscription("TAU@gmail.com");
        homePage.clickArrowButton();
        Assert.assertEquals(homePage.clickArrowButton(),"You have been successfully subscribed!");
    }
    @Test
    public void AddToCartFromRecommendedItems(){
     Assert.assertEquals(homePage.scrollToDownAndCheckVisibiltOfRecommendedItemsText(),true);
     homePage.addRecommendedProductToACart();
     CartPage CartPage = homePage.clickCart();
     Assert.assertEquals(CartPage.VerifyAdditionOfFirstProduct(),true);
    }
    @Test
    public void VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        Assert.assertEquals(homePage.ScrollDownToFooter(),true);
        homePage.ScrollUpByArrow();
        Assert.assertEquals(homePage.checkVisibilityOfIntroText(),true);
    }
    @Test
    public void VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        Assert.assertEquals(homePage.ScrollDownToFooter(),true);
        Assert.assertEquals(homePage.ScrollUp(),true);


    }
}
