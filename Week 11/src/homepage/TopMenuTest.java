package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        System.out.println("Current Menu : " + menu);

        if (menu.equalsIgnoreCase("Show AllDesktops")) {
            String actualDesktop = "Desktops"; //
            String exceptedDesktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']")).getText();
            Assert.assertEquals(actualDesktop, exceptedDesktop);
        }

        if (menu.equalsIgnoreCase("Show AllLaptops & Notebooks")) {
            String exceptedLaptopNotebooks = driver.findElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")).getText();
            String actualLaptopsNotebooks = "Laptops & Notebooks";
            Assert.assertEquals(actualLaptopsNotebooks, exceptedLaptopNotebooks);
        }

        if (menu.equalsIgnoreCase("Components")) {
            String exceptedComponents = driver.findElement(By.xpath("//h2[normalize-space()='Components']")).getText();
            String actualComponents = "Components";
            Assert.assertEquals(actualComponents, exceptedComponents);
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        Actions actions = new Actions(driver);
        WebElement computers = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        actions.moveToElement(computers).perform();
        WebElement showAllDesktops = driver.findElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        String Destopstext = showAllDesktops.getText();
        actions.click(showAllDesktops).perform();
        selectMenu(Destopstext);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        Actions actions = new Actions(driver);
        WebElement leptopsNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        actions.moveToElement(leptopsNotebooks).perform();
        WebElement showAllLeptopNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        String pass = showAllLeptopNotebooks.getText();
        actions.click(showAllLeptopNotebooks).perform();
        selectMenu(pass);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        Actions actions = new Actions(driver);//a[normalize-space()='Components']
        WebElement components = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
        actions.moveToElement(components).perform();
        WebElement showComponents = driver.findElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
        String passComponents = showComponents.getText();
        actions.click(showComponents).perform();
        selectMenu(passComponents);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
