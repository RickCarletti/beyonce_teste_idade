package exselenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    protected WebDriver driver;

    @Test
    public void teste_data_nascimento_beyonce_true() {
        System.setProperty("webdriver.chrome.driver", "D:\\Libs\\chromedriver\\107\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://pt.wikipedia.org/wiki");

        Dimension newDimension = new Dimension(1600, 900);
        driver.manage().window().setSize(newDimension);
        WebElement caixaBusca = driver.findElement(By.name("search"));
        caixaBusca.sendKeys("Beyonce");
        caixaBusca.submit();

        WebElement teste = driver.findElement(By.xpath("//td[contains(.,'Nascimento')]/../*[2]"));

        assertTrue(teste.getText().contains("4 de setembro"));
        driver.quit();

    }

    @Test
    public void teste_data_nascimento_beyonce_false() {
        System.setProperty("webdriver.chrome.driver", "D:\\Libs\\chromedriver\\107\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://pt.wikipedia.org/wiki");

        Dimension newDimension = new Dimension(1600, 900);
        driver.manage().window().setSize(newDimension);
        WebElement caixaBusca = driver.findElement(By.name("search"));
        caixaBusca.sendKeys("Beyonce");
        caixaBusca.submit();

        WebElement teste = driver.findElement(By.xpath("//td[contains(.,'Nascimento')]/../*[2]"));

        assertFalse(teste.getText().contains("11 de setembro"));
        driver.quit();

    }

}
