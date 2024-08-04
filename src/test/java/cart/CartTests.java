package cart;

import Pages.CartPage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTests {
    @Test(priority = 1)
    public void VerifySubscriptionInCartPage(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        CartPage CartPage = homePage.clickCart();
        CartPage.ScrollDownToFooterInCart();
        Assert.assertEquals(CartPage.ScrollDownToFooterInCart(),true);
        CartPage.SetEmailForSubscriptionInCart("Tasnim@gmail.com");
        CartPage.clickArrowButtonInCart();
        Assert.assertEquals(CartPage.clickArrowButtonInCart(),"You have been successfully subscribed!");
    }
    @Test(priority = 2)
    public void AddProductsInCart(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        ProductsPage ProductsPage = homePage.clickProducts();
        ProductsPage.HoverOverFirstProduct();
        ProductsPage.AddFirstProductToCart();
        ProductsPage.HoverOverSecondProduct();
        ProductsPage.AddSecondProductToCart();
        CartPage CartPage = ProductsPage.ClickViewCart();
        CartPage.VerifyAdditionOfFirstProduct();
        Assert.assertEquals(CartPage.VerifyAdditionOfFirstProduct(),true);
        CartPage.VerifyAdditionOfSecondProduct();
        Assert.assertEquals(CartPage.VerifyAdditionOfSecondProduct(),true);
        Assert.assertEquals(CartPage.GetFirstProductPrice(),"Rs. 500");
        Assert.assertEquals(CartPage.GetFirstProductQuantity(),"1");
        Assert.assertEquals(CartPage.GetFirstProductTotal(),"Rs. 500");
        Assert.assertEquals(CartPage.GetSecondProductPrice(),"Rs. 400");
        Assert.assertEquals(CartPage.GetSecondProductQuantity(),"1");
        Assert.assertEquals(CartPage.GetSecondProductTotal(),"Rs. 400");
    }
    @Test(priority = 3)
    public void VerifyProductQuantityInCart(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        ProductDetailsPage ProductDetailsPage = homePage.clickViewProductForThirdProduct();
        ProductDetailsPage.VerifyVisibilityOfThirdProductDetails();
        Assert.assertEquals(ProductDetailsPage.VerifyVisibilityOfThirdProductDetails(),true);
        ProductDetailsPage.IncreaseQuantityForThirdProduct("4");
        ProductDetailsPage.AddThirdProductToCart();
        CartPage CartPage = ProductDetailsPage.ClickViewCartAfterAddingThirdProduct();
        Assert.assertEquals(CartPage.checkThirdProductAddition(),true);
        Assert.assertEquals(CartPage.GetQuantityOfThirdProduct(),"4");


    }
    @Test
    public void RemoveProductsFromCart(){
        Assert.assertEquals(homePage.HomeVisibility(),true);
        homePage.AddFourthProductToCart();
        homePage.AddFifthProductToCart();
        CartPage CartPage = homePage.clickCart();
        Assert.assertEquals(CartPage.VerifyCartPageDisplayed(),true);
        CartPage.DeleteParticularItemFromCart();
        Assert.assertEquals(CartPage.CheckProductDeletion(),true);
    }





}
