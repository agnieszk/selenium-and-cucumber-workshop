package pageobjects;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j
public class ProductsPage extends TestBase {

    @FindBy(css = ".product_list > li:nth-child(1)") private WebElement product;

    @FindBy(css = ".clearfix .btn:nth-child(2) span") private WebElement proceedButton;

    private By productTable = By.cssSelector("#columns .row #center_column");

    private By addToCartButton = By.cssSelector(".button-container a:nth-child(1)");

    @Override 
    public boolean isLoaded() {
        return isPresent(productTable);
    }

    public void addToCart() {
        log.info("Add item to cart");
        getWait(2).until(ExpectedConditions.visibilityOf(product));
        new Actions(getDriver()).moveToElement(product).perform();
        product.findElement(addToCartButton).click();
    }

    public void proceedCheckout() {
        log.info("Proceed checkout");
        getWait(3).until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
    }
}
