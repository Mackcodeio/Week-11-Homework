package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String url = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(url);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        By mouseHoverLeptops = By.xpath("//a[normalize-space()='Laptops & Notebooks']");
        By mouseClickShowLaptops = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']");

        mouseHoverAndClick(mouseHoverLeptops, mouseClickShowLaptops);

        By selectFromDropDown = By.xpath("//select[@id='input-sort']");
        String selectValue = "Price (High > Low)";
        selectByVisibleTextFromDropDown(selectFromDropDown, selectValue);
        Thread.sleep(5000);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        // 2.1 to 2.3
        verifyProductsPriceDisplayHighToLowSuccessfully();

        // 2.4 Select product “MacBook”
        By select_MacBook_Product = By.xpath("//img[@title='MacBook Pro']");
        clickOnElement(select_MacBook_Product);


        // 2.5 Verify the Text "MacBook"
        By confromation_text = By.xpath("//h1[normalize-space()='MacBook Pro']");
        String expectedMessage = "MacBook Pro";
        verifyText("MacBook Pro", confromation_text);

        //2.6 Click on ‘Add To Cart’ button
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”

        //2.8 Click on link “shopping cart” display into success message

        //2.9 Verify the text "Shopping Cart"

        //2.10 Verify the Product name "MacBook"
    }

    @After
    public void close(){
        closeBrowser();
    }
}
