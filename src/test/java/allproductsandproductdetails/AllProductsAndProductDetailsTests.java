package allproductsandproductdetails;

import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AllProductsAndProductDetailsTests extends BaseTests {
    @Test
    public void VerifyAllProductsAndProductDetailPage(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        ProductsPage ProductsPage = homePage.clickProducts();
        ProductsPage.AllProductsPageVisibility();
        Assert.assertEquals(ProductsPage.AllProductsPageVisibility(),true);
        ProductsPage.ProductsListVisibility();
        Assert.assertEquals(ProductsPage.ProductsListVisibility(),true);
        ProductDetailsPage ProductDetailsPage = ProductsPage.clickViewProductForFirstProduct();
        ProductDetailsPage.CheckVisibilityOfProductName();
        Assert.assertEquals(ProductDetailsPage.CheckVisibilityOfProductName(),true);
        ProductDetailsPage.CheckVisibilityOfProductCategory();
        Assert.assertEquals(ProductDetailsPage.CheckVisibilityOfProductCategory(),true);
        ProductDetailsPage.CheckVisibilityOfProductPrice();
        Assert.assertEquals(ProductDetailsPage.CheckVisibilityOfProductPrice(),true);
        ProductDetailsPage.CheckVisibilityOfProductAvailability();
        Assert.assertEquals(ProductDetailsPage.CheckVisibilityOfProductAvailability(),true);
        ProductDetailsPage.CheckVisibilityOfProductCondition();
        Assert.assertEquals(ProductDetailsPage.CheckVisibilityOfProductCondition(),true);
        ProductDetailsPage.CheckVisibilityOfProductBrand();
        Assert.assertEquals(ProductDetailsPage.CheckVisibilityOfProductBrand(),true);
    }
    @Test
    public void SearchProduct(){
        homePage.HomeVisibility();
        Assert.assertEquals(homePage.HomeVisibility(),true);
        ProductsPage ProductsPage = homePage.clickProducts();
        ProductsPage.AllProductsPageVisibility();
        Assert.assertEquals(ProductsPage.AllProductsPageVisibility(),true);
        ProductsPage.setSearchInput("Dresses");
        ProductsPage.SearchProductTextVisibilty();
        Assert.assertEquals(ProductsPage.SearchProductTextVisibilty(),true);
        ProductsPage.ProductsRelatedToSearchVisibilty();
        Assert.assertEquals(ProductsPage.ProductsRelatedToSearchVisibilty(), true);
    }
}
