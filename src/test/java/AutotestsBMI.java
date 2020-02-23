import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AutotestsBMI {
    @Test
    public void categoryNormal() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("54");
        browser.findElement(By.name("ht")).sendKeys("163");
        browser.findElement(By.name("cc")).click();
        String category = browser.findElement(By.name("desc")).getAttribute("value");//если нужно взять текст, getText! не работает берём getAttribute
        assertEquals(category, "Your category is Normal", "Категория верная"); //сравнивает первое со вторым
        System.out.println(category);
        browser.quit();//закрыть браузер
    }

}
