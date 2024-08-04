package products;

import Pages.*;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTests {
    @Test
    public void ViewCategoryProducts(){
        Assert.assertEquals(homePage.verifyCategoriesVisible(),true);
        homePage.clickWomenCategory();
        ProductsPage ProductsPage =homePage.clickWomenDress();

        Assert.assertEquals(ProductsPage.VerifyCategoryIsDisplayed(),true);
        Assert.assertEquals(ProductsPage.VerifyTextIsDisplayed(),"WOMEN - DRESS PRODUCTS");
        homePage.clickMenCategory();
        homePage.clickMenTShirts();
        Assert.assertEquals(ProductsPage.VerifyTextIsDisplayed(),"MEN - TSHIRTS PRODUCTS");


    }
    @Test
    public void ViewAndCartBrandProducts(){
        ProductsPage ProductsPage = homePage.clickProducts();
        Assert.assertEquals(homePage.verifyBrandsVisible(),true);
        homePage.clickPoloBrand();
        Assert.assertEquals(ProductsPage.verifyNavigationToBrandPage(),"Polo");
        Assert.assertEquals(ProductsPage.VerifyBrandProductIsDisplayed(),"BRAND - POLO PRODUCTS");
        homePage.clickBibaBrand();
        Assert.assertEquals(ProductsPage.verifyNavigationToBrandPage(),"Biba");
        Assert.assertEquals(ProductsPage.VerifyBrandProductIsDisplayed(),"BRAND-BIBA PRODUCTS");

    }
    @Test
    public void SearchProductsAndVerifyCartAfterLogin(){
        ProductsPage ProductsPage =homePage.clickProducts();
        Assert.assertEquals(ProductsPage.VerifyTextIsDisplayed(),"ALL PRODUCTS");
        ProductsPage.setSearchInput("shirts");
        Assert.assertEquals(ProductsPage.SearchProductTextVisibilty(),true);
        Assert.assertEquals(ProductsPage.verifyShirtSearchResults(),true);
        ProductsPage.AddProductsToCart();
        CartPage CartPage = homePage.clickCart();
        Assert.assertEquals(CartPage.verifyProductInCart(),true);
        SignUpANDLoginPage SignUpANDLoginPage =homePage.clickSignUpANDLoginPage();
        SignUpANDLoginPage.setEmailAddressforLogin("adel@gmail.com");
        SignUpANDLoginPage.setPasswordforLogin("Adel");
        HomePage HomePage = SignUpANDLoginPage.clickLoginButton();
        homePage.clickCart();
        Assert.assertEquals(CartPage.verifyProductInCart(),true);



    }
    @Test
    public void AddReviewOnProduct(){
        ProductsPage ProductsPage = homePage.clickProducts();
        Assert.assertEquals(ProductsPage.AllProductsPageVisibility(),true);
        ProductDetailsPage ProductDetailsPage =ProductsPage.clickViewProductForFirstProduct();
        Assert.assertEquals( ProductDetailsPage.checkVisibilityOfWriteReviewText(),true);
        ProductDetailsPage.setNameInReview("Tasnim");
        ProductDetailsPage.setEmailInReview("Tasnim@gmail.com");
        ProductDetailsPage.setMessageInReview("Good product.");
        ProductDetailsPage.clickSubmitReview();
        Assert.assertEquals(ProductDetailsPage.successReviewSubmit(),true);

    }


}
