package desktops;

import broswertesting.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DesktopsTest extends BaseTest {

    String url = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(url);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){
        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        actions.moveToElement(computers).perform();
        WebElement showAllDesktops = driver.findElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        String Destopstext = showAllDesktops.getText();
        actions.click(showAllDesktops).perform();
    }
    public void verifyProductAddedToShoppingCartSuccessFully(){

    }

    @After
    public void close() {
        closeBrowser();
    }
}
